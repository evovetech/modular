package com.kotlinsg.kworkshopapp.di;

import codegraft.inject.BootstrapComponent
import com.kotlinsg.kworkshopapp.actions.ShowGithubScreenAction
import com.kotlinsg.kworkshopapp.actions.ShowGithubScreenActionRealImpl
import dagger.Module
import dagger.Provides

@Module
class GithubBrowserExportModule {
    @Provides
    fun provideShowGithubAction(): ShowGithubScreenAction = ShowGithubScreenActionRealImpl()
}

@BootstrapComponent(
    applicationModules = [GithubBrowserExportModule::class],
    flatten = true
)
interface GithubBrowserExportComponent : GithubBrowserProvider
