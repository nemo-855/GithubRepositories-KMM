package com.nemo.githubrepositories_kmm.di

import com.nemo.githubrepositories_kmm.domain.GithubUseCase

class UseCaseModule(private val githubUseCase: GithubUseCase) {
    fun provideGithubUseCase() = githubUseCase
}
