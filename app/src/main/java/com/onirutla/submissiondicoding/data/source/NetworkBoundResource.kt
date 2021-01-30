package com.onirutla.submissiondicoding.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.onirutla.submissiondicoding.data.model.remote.ApiResponse
import com.onirutla.submissiondicoding.utils.vo.Resource
import com.onirutla.submissiondicoding.utils.vo.StatusResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class NetworkBoundResource<ResultType, RequestType> {
    private val result = MediatorLiveData<Resource<ResultType>>()

    init {
        result.value = Resource.loading(null)
        @Suppress("LeakingThis")
        val dbSource = loadFromDb()
        result.addSource(dbSource) { data ->
            result.removeSource(dbSource)
            if (shouldFetch(data)) {
                CoroutineScope(Dispatchers.IO).launch {
                    fetchFromNetwork(dbSource)
                }
            } else {
                result.addSource(dbSource) { newData ->
                    result.value = Resource.success(newData)
                }
            }
        }
    }

    private fun onFetchFailed() {}
    protected abstract fun loadFromDb(): LiveData<ResultType>
    protected abstract fun shouldFetch(data: ResultType?): Boolean
    protected abstract fun createCall(): LiveData<ApiResponse<RequestType>>
    protected abstract suspend fun saveCallResult(data: RequestType)

    private suspend fun fetchFromNetwork(dbSource: LiveData<ResultType>) {
        val apiResponse = createCall()

        result.addSource(dbSource) { newData ->
            result.value = Resource.loading(newData)
        }

        result.addSource(apiResponse) { response ->
            result.removeSource(apiResponse)
            result.removeSource(dbSource)
            suspend {
                when (response.status) {
                    StatusResponse.SUCCESS -> {
                        saveCallResult(response.body)
                        result.addSource(loadFromDb()) { newData ->
                            result.value = Resource.success(newData)
                        }
                    }
                    StatusResponse.EMPTY ->

                        result.addSource(loadFromDb()) { newData ->
                            result.value = Resource.success(newData)
                        }

                    StatusResponse.ERROR -> {
                        onFetchFailed()
                        result.addSource(dbSource) { newData ->
                            result.value = Resource.error(response.message, newData)
                        }
                    }
                }
            }
        }
    }

    fun asLiveData(): LiveData<Resource<ResultType>> = result
}