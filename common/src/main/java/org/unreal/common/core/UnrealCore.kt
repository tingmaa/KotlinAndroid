package org.unreal.common.core

import android.app.Application
import org.unreal.common.preference.PreferenceDelegate

/**
 * Created by lincoln on 17-5-24.
 */
class UnrealCore {

    fun init(application: Application) {
        PreferenceDelegate.init(application)
    }
}