package org.unreal.common.di.component

import android.app.Application
import dagger.Component
import org.unreal.common.di.module.CoreModule
import javax.inject.Singleton
/**
 * Created by lincoln on 17-5-24.
 */
@Singleton
@Component(modules = arrayOf(CoreModule::class))
interface CoreComponent {
    fun application() : Application
}
