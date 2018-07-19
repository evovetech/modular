package com.kotlinsg.kworkshopapp.github

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import codegraft.inject.AndroidInject
import com.kotlinsg.kworkshopapp.GithubProject
import com.kotlinsg.kworkshopapp.app.R
import com.kotlinsg.kworkshopapp.di.GithubActivityModule
import com.kotlinsg.kworkshopapp.notification.di.NotificationUseCase
import com.kotlinsg.kworkshopapp.tools.Toaster
import javax.inject.Inject

@AndroidInject(
    includes = [GithubActivityModule::class]
)
class GithubActivity : AppCompatActivity() {

    @Inject lateinit var toaster: Toaster
    @Inject lateinit var useCase: GithubUseCase
    @Inject lateinit var notifications: NotificationUseCase

    lateinit var refreshButton: Button
    lateinit var starsCountText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_github)
        refreshButton = findViewById(R.id.stars_refresh) as Button
        starsCountText = findViewById(R.id.stars_count_text) as TextView

        refreshButton.setOnClickListener { useCase.loadInfoFromGithub(onLoaded = ::updateUI, onError = ::updateErrorUI) }

        notifications.showMessage()
    }

    private fun updateErrorUI(error: Throwable) {
        toaster.show(error.message ?: "unable to load")
    }

    private fun updateUI(result: GithubProject) {
        starsCountText.setText("${result.name} stars count: ${result.stargazers_count}")
    }
}
