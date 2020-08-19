package com.github.apps.ui.home

import com.cermati.test.ui.base.BaseNavigator

interface HomeNavigator : BaseNavigator {
    fun showError(message: String)
    fun movePage()
}