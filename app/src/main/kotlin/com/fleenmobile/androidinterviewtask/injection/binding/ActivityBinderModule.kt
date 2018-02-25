package com.fleenmobile.androidinterviewtask.injection.binding

import android.support.v7.app.AppCompatActivity
import com.fleenmobile.androidinterviewtask.injection.RuntimeScope
import com.fleenmobile.androidinterviewtask.injection.modules.MainActivityModule
import com.fleenmobile.androidinterviewtask.main.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBinderModule {

    @Binds
    abstract fun activity(activity: AppCompatActivity): AppCompatActivity

    @RuntimeScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity
}
