package com.fleenmobile.androidinterviewtask.injection.modules

import android.content.Context
import com.fleenmobile.androidinterviewtask.utils.resourceprovider.ResourceProvider
import com.fleenmobile.androidinterviewtask.utils.resourceprovider.ResourceProviderImpl
import dagger.Module
import dagger.Provides

/**
 * @author FleenMobile at 2018-02-25
 */
@Module
class ResourceProviderModule {

    @Provides
    fun resourceProvider(context: Context): ResourceProvider = ResourceProviderImpl(context)
}