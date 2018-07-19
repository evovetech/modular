/*
 * Copyright 2018 evove.tech
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kotlinsg.kworkshopapp.di

import android.util.Log
import android.widget.Toast
import codegraft.inject.BootScope
import codegraft.inject.android.AndroidApplication
import com.kotlinsg.kworkshopapp.tools.Toaster
import dagger.Module
import dagger.Provides
import javax.inject.Named

typealias LoggerInit = (AndroidApplication) -> Logger
typealias ToasterInit = (AndroidApplication) -> Toaster

@Module
object MainToolsModule {
    @JvmStatic
    @Provides
    @BootScope
    fun provideLogger(
        app: AndroidApplication,
        @Named("logger") logger: LoggerInit?
    ): Logger {
        logger?.let { init ->
            return init(app)
        }

        // Default
        return object : Logger {
            override fun d(message: String) {
                Log.d("Logger", message)
            }
        }
    }

    @JvmStatic
    @Provides
    @BootScope
    fun provideToaster(
        app: AndroidApplication,
        @Named("toaster") toaster: ToasterInit?
    ): Toaster {
        toaster?.let { init ->
            return init(app)
        }

        // Default
        return object : Toaster {
            override fun show(msg: String) {
                Toast.makeText(app, msg, Toast.LENGTH_SHORT)
                        .show()
            }
        }
    }
}
