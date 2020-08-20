package com.cermati.test.ui.home

import android.text.Editable
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.cermati.test.databinding.ItemUserBinding
import com.cermati.test.domain.models.User
import com.cermati.test.domain.usecases.user.IUserUsecases
import com.cermati.test.ui.base.BaseViewModel
import com.cermati.test.ui.home.adapter.UserListAdapter
import com.cermati.test.utils.SchedulerProvider
import com.github.apps.ui.home.HomeNavigator
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

open class HomeViewModel(baseUsecase: IUserUsecases, schedulerProvider: SchedulerProvider) :
    BaseViewModel<IUserUsecases, HomeNavigator>(baseUsecase, schedulerProvider) {

    var search = ObservableField<String>()
    var isEmpty = ObservableBoolean(true)
    var isLoadingLoadMore = false

    var userListAdapter = UserListAdapter(ArrayList(), ::goToDetailUser)

    var page: Int = 1

    override fun defineLayout() {

    }

    fun afterTextSearchChanged(s: Editable) {
        page = 1
        search.set(s.toString())
        doGetUser(page)
    }

    fun getAdapter(): UserListAdapter {
        return userListAdapter
    }

    private fun goToDetailUser(user: User, binding: ItemUserBinding) {

    }


    private fun doGetUser(page: Int) {
        viewModelScope.launch {
            if (!isLoadingLoadMore) {
                isLoading(true)
            }
            try {
                val responseApi = baseUsecase.getUser(search.get(), page)
                checkResponse(responseApi.blockingGet())
            } catch (e: Exception) {
                onError(e)
            }
        }
    }

    @Suppress("UNCHECKED_CAST")
    private fun checkResponse(responseApi: Any?) {
        isLoading(false)
        if (responseApi is String) {
            navigator?.showError(responseApi.toString())
        } else {
            populateData(responseApi as List<User>)
        }
        if (isLoadingLoadMore) {
            isLoadingLoadMore = false
        }
    }

    private fun populateData(list: List<User>) {
        isEmpty.set(list.isEmpty())
        if (!isLoadingLoadMore) {
            userListAdapter.clearItems()
        } else {
            userListAdapter.clearLatest()
        }
        userListAdapter.addItems(list)
        runBlocking { }
    }

    override fun onSuccess(o: Any?) {
        isLoading(false)
        if (o is Boolean) {
            navigator?.movePage()
        } else {
            navigator?.showError(o.toString())
        }
    }

    fun loadMoreData(linearLayoutManager: LinearLayoutManager?) {
        if (!isLoadingLoadMore) {
            if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == userListAdapter.itemCount - 1) {
                userListAdapter.addItem(User())
                isLoadingLoadMore = true
                doGetUser(++page);
            }
        }

    }


}