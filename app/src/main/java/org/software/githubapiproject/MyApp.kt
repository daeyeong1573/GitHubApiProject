package org.software.githubapiproject

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApp : Application() {

    companion object {
        private lateinit var myApplication: MyApp
        fun getInstance(): MyApp = myApplication
    }

    override fun onCreate() {
        super.onCreate()
        myApplication = this
    }

}