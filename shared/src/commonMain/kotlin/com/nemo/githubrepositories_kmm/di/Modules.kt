package com.nemo.githubrepositories_kmm.di

import com.nemo.githubrepositories_kmm.data.apis.APICommunicationImpl
import com.nemo.githubrepositories_kmm.data.apis.NetworkService
import com.nemo.githubrepositories_kmm.data.apis.implements.GithubApiImpl
import com.nemo.githubrepositories_kmm.data.apis.interfaces.GithubApi
import com.nemo.githubrepositories_kmm.data.repositories.implementations.GithubRepositoryImpl
import com.nemo.githubrepositories_kmm.data.repositories.interfaces.GithubRepository
import com.nemo.githubrepositories_kmm.domain.GithubUseCase
import com.nemo.githubrepositories_kmm.domain.GithubUseCaseImpl
import org.koin.dsl.module


private val commonModule = module {
    single { NetworkService(get()) }
    single<GithubApi> { GithubApiImpl(get()) }

    single<GithubRepository> { GithubRepositoryImpl(get()) }

    single<GithubUseCase> { GithubUseCaseImpl(get()) }

    single { UseCaseModule() }
}

private val platFormModule = module {
    single { APICommunicationImpl.createAPICommunication() }
}

fun appModule() = listOf(commonModule, platFormModule)
