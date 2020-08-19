package com.cermati.test

import androidx.lifecycle.ViewModelProvider.NewInstanceFactory
import com.cermati.test.domain.mappers.UserMapper
import com.cermati.test.domain.usecases.user.IUserUsecases
import com.cermati.test.domain.usecases.user.UserUsecases
import com.cermati.test.data.remote.UserRepository
import com.cermati.test.utils.SchedulerProvider
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ViewModelProviderFactory @Inject constructor(private val schedulerProvider: SchedulerProvider) :
    NewInstanceFactory() {
    private val userUsecases: IUserUsecases

    init {
        userUsecases = UserUsecases(UserMapper(), UserRepository.instance!!)
    }

//    @Suppress("UNCHECKED_CAST")
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        when {
////            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
////                return HomeViewModel(userUsecases, schedulerProvider) as T
//            }
//            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
//        }
//    }


}