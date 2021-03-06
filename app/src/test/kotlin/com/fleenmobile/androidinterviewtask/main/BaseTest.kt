package com.fleenmobile.androidinterviewtask.main

import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.After
import org.junit.Before
import org.mockito.ArgumentCaptor
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 * @author FleenMobile at 2018-02-26
 */
abstract class BaseTest {

    @Before
    open fun setup() = MockitoAnnotations.initMocks(this)

    protected fun trampolineRxPlugin() {
        RxAndroidPlugins.setMainThreadSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setSingleSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setNewThreadSchedulerHandler { Schedulers.trampoline() }
    }

    @After
    open fun tearDown() {
        RxAndroidPlugins.reset()
        RxJavaPlugins.reset()
    }

    protected fun <T> any(): T {
        Mockito.any<T>()
        return uninitialized()
    }

    protected fun <T> any(c: Class<T>): T {
        Mockito.any<T>()
        return uninitialized()
    }

    protected fun <T> ArgumentCaptor<T>.kCapture(): T {
        capture()
        return uninitialized()
    }

    private fun <T> uninitialized(): T = null as T
}