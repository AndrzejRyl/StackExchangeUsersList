package com.fleenmobile.androidinterviewtask.injection

import android.app.Application
import android.content.Context
import com.fleenmobile.androidinterviewtask.BaseApp
import com.fleenmobile.androidinterviewtask.injection.binding.ActivityBinderModule
import com.fleenmobile.androidinterviewtask.injection.binding.FragmentBinderModule
import com.fleenmobile.androidinterviewtask.injection.modules.NetworkModule
import com.fleenmobile.androidinterviewtask.injection.modules.RepositoryModule
import com.fleenmobile.androidinterviewtask.injection.modules.ResourceProviderModule
import com.fleenmobile.androidinterviewtask.injection.modules.UserSelectedCommunicationModule
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Scope
import javax.inject.Singleton

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class RuntimeScope

@Module
class AppModule {

    @Provides
    fun context(application: Application): Context =
            application

    @Provides
    fun compositeDisposable(): CompositeDisposable =
            CompositeDisposable()
}

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    ActivityBinderModule::class,
    FragmentBinderModule::class,
    RepositoryModule::class,
    ResourceProviderModule::class,
    UserSelectedCommunicationModule::class,
    NetworkModule::class,
    AppModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: BaseApp)
}
