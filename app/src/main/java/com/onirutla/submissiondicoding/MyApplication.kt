package com.onirutla.submissiondicoding

import android.app.Application
import com.onirutla.submissiondicoding.di.jsonHelperModule
import com.onirutla.submissiondicoding.di.repositoryModule
import com.onirutla.submissiondicoding.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    jsonHelperModule,
                    repositoryModule,
                    viewModelModule
                )
            )
        }
    }
}