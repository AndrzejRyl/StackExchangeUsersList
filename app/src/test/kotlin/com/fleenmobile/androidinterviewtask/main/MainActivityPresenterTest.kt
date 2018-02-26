package com.fleenmobile.androidinterviewtask.main

import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*

/**
 * @author FleenMobile at 2018-02-26
 */
class MainActivityPresenterTest : BaseTest() {

    @Mock
    private lateinit var view: MainActivityContract.View

    @Mock
    private lateinit var router: MainActivityContract.Router

    private lateinit var presenter: MainActivityContract.Presenter

    override fun setup() {
        super.setup()

        presenter = MainActivityPresenter(view, router)
    }

    override fun tearDown() {
        super.tearDown()
        verifyNoMoreInteractions(view, router)
    }

    @Test
    fun `should navigate to list fragment on startup`() {
        presenter.visible()

        verify(router, times(1)).navigateToListFragment()
    }

    @Test
    fun `shouldn't do anything on clear`() {
        presenter.clear()

        // Nothing to clear here
    }

}