package org.unreal.core.base

import android.app.Application
import org.unreal.core.di.component.CoreComponent
import org.unreal.core.di.component.DaggerCoreComponent
import org.unreal.core.di.module.CoreModule


abstract class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initBaseComponent()
        initApplication()
    }

    private fun initBaseComponent() {
        coreComponent = DaggerCoreComponent
                .builder()
                .coreModule(CoreModule(this))
                .build()
    }

    companion object {
        lateinit var coreComponent: CoreComponent
    }

    abstract fun initApplication()
}