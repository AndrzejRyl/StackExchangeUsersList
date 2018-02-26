package com.fleenmobile.androidinterviewtask.injection.modules

import com.fleenmobile.androidinterviewtask.data.User
import dagger.Module
import dagger.Provides
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Singleton

/**
 * @author FleenMobile at 2018-02-25
 */
@Module
class UserSelectedCommunicationModule {

    @Provides
    @Singleton
    fun userSelectedSubject(): BehaviorSubject<User> = BehaviorSubject.create()
}