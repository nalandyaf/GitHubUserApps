package com.cermati.test.di.module

import android.app.Application
import android.content.Context
import com.cermati.test.R
import com.cermati.test.utils.AndroidUtils
import com.cermati.test.utils.AppSchedulerProvider
import com.cermati.test.utils.SchedulerProvider
import dagger.Module
import dagger.Provides
import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider {
        return AppSchedulerProvider()
    }

    @Provides
    @Singleton
    fun provideCalligraphyDefaultConfig(): CalligraphyConfig {
        return CalligraphyConfig.Builder()
                .setDefaultFontPath(AndroidUtils.getString(R.string.font_path_poppins))
                .setFontAttrId(R.attr.fontPath)
                .build()
    }
}