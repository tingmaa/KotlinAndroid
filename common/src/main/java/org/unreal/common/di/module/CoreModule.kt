package org.unreal.common.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by lincoln on 17-5-24.
 */

@Module
class CoreModule(val application : Application){

    @Singleton
    @Provides
    fun provideApplication() = application

}