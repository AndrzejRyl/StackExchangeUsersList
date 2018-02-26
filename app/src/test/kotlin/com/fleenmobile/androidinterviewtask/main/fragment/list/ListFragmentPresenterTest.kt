package com.fleenmobile.androidinterviewtask.main.fragment.list

import com.fleenmobile.androidinterviewtask.data.User
import com.fleenmobile.androidinterviewtask.main.BaseTest
import com.fleenmobile.androidinterviewtask.utils.repository.Repository
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.BehaviorSubject
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*

/**
 * @author FleenMobile at 2018-02-26
 */
class ListFragmentPresenterTest : BaseTest() {

    @Mock
    private lateinit var view: ListFragmentContract.View

    @Mock
    private lateinit var router: ListFragmentContract.Router

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var compositeDisposable: CompositeDisposable

    @Mock
    private lateinit var userSelectedCommunicationSubject: BehaviorSubject<User>

    @Mock
    private lateinit var user: User

    private val users = arrayListOf<User>()
    private val mockUserId = 3L
    private val mockString = "mock"

    private lateinit var presenter: ListFragmentContract.Presenter

    override fun setup() {
        super.setup()

        trampolineRxPlugin()

        users.add(user)

        presenter = ListFragmentPresenter(
                view,
                router,
                repository,
                compositeDisposable,
                userSelectedCommunicationSubject,
                users
        )
    }

    override fun tearDown() {
        super.tearDown()
        verifyNoMoreInteractions(
                view,
                router,
                repository,
                compositeDisposable,
                userSelectedCommunicationSubject,
                user
        )
    }

    @Test
    fun `should show search info on startup`() {
        presenter.visible()

        verify(view, times(1)).showSearchInfo()
    }

    @Test
    fun `should clear composite disposable on clear`() {
        presenter.clear()

        verify(compositeDisposable, times(1)).clear()
    }

    @Test
    fun `should communicate with details fragment when user is chosen`() {
        `when`(user.userId).thenReturn(mockUserId)

        presenter.userChosen(mockUserId)

        verify(user, times(1)).userId
        verify(userSelectedCommunicationSubject, times(1)).onNext(user)
        verify(router, times(1)).navigateToDetailsFragment()
    }

    @Test
    fun `should show users on search term button clicked`() {
        `when`(repository.getUsers(mockString)).thenReturn(Observable.just(users))

        presenter.searchButtonClicked(mockString)

        verify(repository, times(1)).getUsers(mockString)
        verify(compositeDisposable, times(1)).add(any())
        verify(repository, times(1)).getUsers(mockString)
        verify(view, times(1)).showUsers(users)
    }

    @Test
    fun `should show search info in case users fetch fails`() {
        `when`(repository.getUsers(mockString)).thenReturn(Observable.error(IllegalStateException("Sth went wrong")))

        presenter.searchButtonClicked(mockString)

        verify(repository, times(1)).getUsers(mockString)
        verify(compositeDisposable, times(1)).add(any())
        verify(view, times(1)).showSearchInfo()
    }
}