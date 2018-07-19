package com.kotlinsg.kworkshopapp

import android.app.Application
import codegraft.inject.AndroidInject
import codegraft.inject.android.BootApplication
import com.kotlinsg.kworkshopapp.tools.LoggerImpl
import com.kotlinsg.kworkshopapp.tools.Toaster
import com.kotlinsg.kworkshopapp.tools.ToasterImpl
import javax.inject.Inject

@AndroidInject
class RealApp : Application(), BootApplication<AppComponent> {
    @Inject lateinit var toaster: Toaster

    override
    val bootstrap = bootstrap {
        loggerApplicationFunction1 { LoggerImpl() }
        toasterApplicationFunction1 { ToasterImpl(applicationContext) }
        this@RealApp
    }

    override fun onCreate() {
        super.onCreate()
        toaster.show("app injected")
    }
}
