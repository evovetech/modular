package com.kotlinsg.kworkshopapp.network.di

import codegraft.inject.BootstrapComponent
import com.kotlinsg.kworkshopapp.network.NetworkClient
import com.kotlinsg.kworkshopapp.network.NetworkClientImpl
import dagger.Binds
import dagger.Module

interface NetworkProvider {
    val networkClient: NetworkClient
}

@Module
interface NetworkModule {
    @Binds fun bindsNetworkClient(impl: NetworkClientImpl): NetworkClient
}

@BootstrapComponent(
    applicationModules = [NetworkModule::class],
    flatten = true
)
interface NetworkComponent : NetworkProvider
