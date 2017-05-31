package org.unreal.core.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by lincoln on 17-5-24.
 */

@Module
class CoreModule(val app: Application) {
    @Provides
    @Singleton
    fun provideApplication() = app

    @Provides
    @Singleton
    fun provideResource () = app.resources

}