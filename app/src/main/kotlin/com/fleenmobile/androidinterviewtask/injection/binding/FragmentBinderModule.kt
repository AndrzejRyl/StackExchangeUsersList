package com.fleenmobile.androidinterviewtask.injection.binding

import android.support.v4.app.Fragment
import android.support.v4.app.ListFragment
import com.fleenmobile.androidinterviewtask.injection.modules.DetailsFragmentModule
import com.fleenmobile.androidinterviewtask.injection.modules.ListFragmentModule
import com.fleenmobile.androidinterviewtask.main.fragment.details.DetailsFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBinderModule {

    @Binds
    abstract fun fragment(fragment: Fragment): Fragment

    @ContributesAndroidInjector(modules = [ListFragmentModule::class])
    abstract fun bindListFragment(): ListFragment

    @ContributesAndroidInjector(modules = [DetailsFragmentModule::class])
    abstract fun bindDetailsFragment(): DetailsFragment

}
