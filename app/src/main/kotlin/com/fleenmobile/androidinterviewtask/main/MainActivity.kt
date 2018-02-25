package com.fleenmobile.androidinterviewtask.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.fleenmobile.androidinterviewtask.R

class MainActivity : AppCompatActivity(), MainActivityContract.View, MainActivityContract.Router {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun navigateToListFragment() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun navigateToDetailsFragment() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
