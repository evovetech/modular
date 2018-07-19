package com.kotlinsg.kworkshopapp.repo.di

import codegraft.inject.BootstrapComponent
import com.kotlinsg.kworkshopapp.di.RepoProvider

@BootstrapComponent(
    applicationModules = [RepoModule::class],
    flatten = true
)
interface RepoComponent : RepoProvider
