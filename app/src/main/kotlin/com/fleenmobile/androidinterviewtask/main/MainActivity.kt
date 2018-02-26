package com.fleenmobile.androidinterviewtask.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.fleenmobile.androidinterviewtask.R
import com.fleenmobile.androidinterviewtask.findFragmentByTag
import com.fleenmobile.androidinterviewtask.main.fragment.details.DetailsFragment
import com.fleenmobile.androidinterviewtask.main.fragment.list.ListFragment
import com.fleenmobile.androidinterviewtask.replaceFragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainActivityContract.View, MainActivityContract.Router, HasSupportFragmentInjector {

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var presenter: MainActivityContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.visible()
    }

    override fun onBackPressed() {
        val detailsFragment = supportFragmentManager.findFragmentByTag(DetailsFragment::class.java.name)

        detailsFragment?.let {
            navigateToListFragment()
        } ?: finish()
    }

    override fun navigateToListFragment() {
        showFragment(ListFragment::class.java.name) { ListFragment() }
    }

    override fun navigateToDetailsFragment() {
        showFragment(DetailsFragment::class.java.name) { DetailsFragment() }
    }

    private fun showFragment(tag: String, defaultFragment: () -> Fragment) {
        val fragment =
                supportFragmentManager.findFragmentByTag(tag) { defaultFragment.invoke() }
        replaceFragment(R.id.main_screen_root, fragment, tag)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> =
            fragmentInjector
}
