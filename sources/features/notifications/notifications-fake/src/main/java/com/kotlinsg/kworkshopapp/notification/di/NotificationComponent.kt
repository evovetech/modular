package com.kotlinsg.kworkshopapp.notification.di

import codegraft.inject.BootstrapComponent
import com.kotlinsg.kworkshopapp.di.MainToolsProvider
import com.kotlinsg.kworkshopapp.tools.Toaster
import dagger.Module
import dagger.Provides

interface NotificationProvider {
    fun provideNotificationUseCase(): NotificationUseCase
}

@Module
class NotificationModule {
    @Provides fun providesNotificationUseCase(toaster: Toaster): NotificationUseCase =
            object : NotificationUseCase {
                override fun showMessage() {
                    toaster.show("notifications are not implemented")
                }
            }
}
@BootstrapComponent(
    applicationModules = [NotificationModule::class],
    flatten = true
)
interface NotificationComponent : NotificationProvider
