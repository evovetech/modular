package com.kotlinsg.kworkshopapp.di

import codegraft.inject.BootstrapComponent
import com.kotlinsg.kworkshopapp.actions.ShowGithubScreenAction
import com.kotlinsg.kworkshopapp.repo.GithubRepo
import com.kotlinsg.kworkshopapp.tools.Toaster

@BootstrapComponent(
    bootstrapModules = [MainToolsModule::class],
    flatten = true
)
interface MainToolsProvider {
    val logger: Logger
    val toast: Toaster
}

interface GithubBrowserProvider {
    val showGithubScreenAction: ShowGithubScreenAction
}

interface RepoProvider {
    val githubRepo: GithubRepo
}
