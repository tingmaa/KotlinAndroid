package org.unreal.common.base

import android.app.Application
import org.unreal.common.di.component.CoreComponent
import org.unreal.common.di.component.DaggerCoreComponent
import org.unreal.common.di.module.CoreModule

/**
 * Created by lincoln on 17-5-24.
 */
abstract class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        coreComponent = DaggerCoreComponent
                .builder()
                .coreModule(CoreModule(this))
                .build()
        initApplication()
    }

    companion object {
        lateinit var coreComponent: CoreComponent
    }

    abstract fun initApplication()
}