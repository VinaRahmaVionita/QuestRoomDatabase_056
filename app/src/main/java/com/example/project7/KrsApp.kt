package com.example.project7

import android.app.Application
import com.example.project7.dependeciesinjection.ContainerApp
import com.example.project7.dependeciesinjection.InterfaceContainerApp

class KrsApp : Application() {
    //fungsinya untuk menyimpan instance ContainerApp
    lateinit var containerApp: ContainerApp

    override fun onCreate() {
        super.onCreate()
        //membuat instance ContainerApp
        containerApp = ContainerApp(this)
        //instance adalah object yang dibuat dari class
    }
}