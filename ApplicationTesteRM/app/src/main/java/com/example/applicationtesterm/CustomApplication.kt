package com.example.applicationtesterm

import android.app.Application
import com.example.applicationtesterm.koinmodule.imageUtilsModule
import com.example.applicationtesterm.koinmodule.serverModule
import org.koin.core.context.startKoin

class CustomApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                imageUtilsModule,
                serverModule
            )
        }
    }
}