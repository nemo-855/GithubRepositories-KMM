package com.nemo.githubrepositories_kmm.di

import com.nemo.githubrepositories_kmm.data.apis.NetworkService
import com.nemo.githubrepositories_kmm.data.apis.implements.GithubApiImpl
import com.nemo.githubrepositories_kmm.data.apis.interfaces.GithubApi
import com.nemo.githubrepositories_kmm.data.repositories.implementations.GithubRepositoryImpl
import com.nemo.githubrepositories_kmm.data.repositories.interfaces.GithubRepository
import io.ktor.client.HttpClient
import org.koin.dsl.module


private val commonModule = module {
    single { HttpClient() }
    single { NetworkService(get()) }
    single<GithubApi> { GithubApiImpl(get()) }

    single<GithubRepository> { GithubRepositoryImpl(get()) }
}

private val platFormModule = module {

}

val appModule = listOf(commonModule, platFormModule)
