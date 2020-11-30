package com.onirutla.submissiondicoding.data.model.remote

import com.onirutla.submissiondicoding.utils.vo.StatusResponse
import com.onirutla.submissiondicoding.utils.vo.StatusResponse.SUCCESS

class ApiResponse<T>(val status: StatusResponse, val body: T, val message: String?) {
    companion object {
        fun <T> success(body: T): ApiResponse<T> = ApiResponse(SUCCESS, body, null)
    }
}