package org.unreal.core.di.component

import android.app.Application
import android.content.res.Resources
import dagger.Component
import org.unreal.core.di.module.CoreModule
import org.unreal.core.di.module.NetModule
import org.unreal.core.di.scope.LocalRetrofit
import retrofit2.Retrofit
import javax.inject.Singleton
/**
 * Created by lincoln on 17-5-24.
 */
@Singleton
@Component(modules = arrayOf(CoreModule::class,NetModule::class))
interface CoreComponent {
    fun application() : Application

    fun resource() : Resources

    @LocalRetrofit fun localRetorfit() : Retrofit
}
