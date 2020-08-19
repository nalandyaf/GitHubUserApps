package com.cermati.test.di.builder


import com.cermati.test.ui.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {

    @ContributesAndroidInjector(modules = [])
    abstract fun bindLoginFragment(): HomeFragment?

}