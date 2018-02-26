package com.fleenmobile.androidinterviewtask.injection.modules

import com.fleenmobile.androidinterviewtask.utils.repository.Repository
import com.fleenmobile.androidinterviewtask.utils.repository.RepositoryImpl
import dagger.Module
import dagger.Provides

/**
 * @author FleenMobile at 2018-02-25
 */
@Module
class RepositoryModule {

    @Provides
    fun repository(): Repository = RepositoryImpl()
}