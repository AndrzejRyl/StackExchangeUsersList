package com.fleenmobile.androidinterviewtask.injection.modules

import android.app.Activity
import com.fleenmobile.androidinterviewtask.utils.resourceprovider.ResourceProvider
import dagger.Module
import dagger.Provides

/**
 * @author FleenMobile at 2018-02-25
 */
@Module
class ResourceProviderModule(private val activity: Activity) {

    @Provides
    fun resourceProvider() = ResourceProvider(activity)
}