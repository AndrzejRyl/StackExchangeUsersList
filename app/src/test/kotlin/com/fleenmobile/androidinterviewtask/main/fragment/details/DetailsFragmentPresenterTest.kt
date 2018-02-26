package com.fleenmobile.androidinterviewtask.main.fragment.details

import com.fleenmobile.androidinterviewtask.R
import com.fleenmobile.androidinterviewtask.data.User
import com.fleenmobile.androidinterviewtask.main.BaseTest
import com.fleenmobile.androidinterviewtask.utils.resourceprovider.ResourceProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.BehaviorSubject
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*

/**
 * @author FleenMobile at 2018-02-26
 */
class DetailsFragmentPresenterTest : BaseTest() {

    @Mock
    private lateinit var view: DetailsFragmentContract.View

    @Mock
    private lateinit var router: DetailsFragmentContract.Router

    @Mock
    private lateinit var compositeDisposable: CompositeDisposable

    @Mock
    private lateinit var resourceProvider: ResourceProvider

    @Mock
    private lateinit var user: User

    private val userSelectedCommunicationSubject: BehaviorSubject<User> = BehaviorSubject.create()
    private val mockString = "mock"

    private lateinit var presenter: DetailsFragmentContract.Presenter

    override fun setup() {
        super.setup()

        presenter = DetailsFragmentPresenter(
                view,
                router,
                userSelectedCommunicationSubject,
                compositeDisposable,
                resourceProvider
        )
    }

    override fun tearDown() {
        super.tearDown()

        verifyNoMoreInteractions(
                view,
                router,
                compositeDisposable,
                resourceProvider,
                user
        )
    }

    @Test
    fun `should show user on startup`() {
        userSelectedCommunicationSubject.onNext(user)

        presenter.visible()

        verify(compositeDisposable, times(1)).add(any())
        verify(view, times(1)).showUser(user)
    }

    @Test
    fun `should show error is user is unavailable`() {
        userSelectedCommunicationSubject.onError(IllegalStateException("User is unavailable"))
        `when`(resourceProvider.getString(R.string.no_user)).thenReturn(mockString)

        presenter.visible()

        verify(compositeDisposable, times(1)).add(any())
        verify(view, times(1)).showError(mockString)
        verify(resourceProvider, times(1)).getString(R.string.no_user)
    }

    @Test
    fun `should clear composite disposable on clear`() {
        presenter.clear()

        verify(compositeDisposable, times(1)).clear()
    }

}