package com.nemo.githubrepositories_kmm.di

import com.nemo.githubrepositories_kmm.domain.GithubUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class UseCaseModule : KoinComponent {
    private val githubUseCase: GithubUseCase by inject()

    fun provideGithubUseCase() = githubUseCase
}
