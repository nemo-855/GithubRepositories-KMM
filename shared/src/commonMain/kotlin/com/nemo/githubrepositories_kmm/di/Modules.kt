package com.nemo.githubrepositories_kmm.di

import com.nemo.githubrepositories_kmm.data.apis.NetworkService
import io.ktor.client.HttpClient
import org.koin.dsl.module


private val commonModule = module {

    single { HttpClient() }
    single { NetworkService(get()) }
}

private val platFormModule = module {

}

val appModule = listOf(commonModule, platFormModule)
