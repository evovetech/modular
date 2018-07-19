package com.kotlinsg.kworkshopapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import codegraft.inject.AndroidInject
import codegraft.inject.BootstrapComponent
import com.kotlinsg.kworkshopapp.actions.ShowGithubScreenAction
import com.kotlinsg.kworkshopapp.appB.R
import com.kotlinsg.kworkshopapp.di.GithubBrowserProvider
import com.kotlinsg.kworkshopapp.di.Logger
import com.kotlinsg.kworkshopapp.di.MainToolsProvider
import javax.inject.Inject

@AndroidInject
class MainActivity : AppCompatActivity() {

    @Inject lateinit var log: Logger
    @Inject lateinit var showGithubScreenAction: ShowGithubScreenAction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.icon).setOnClickListener { openGithubScreen() }
        log.d("Main activity created. Logger injected successfully")
    }

    private fun openGithubScreen() {
        showGithubScreenAction.show(this)
    }
}
