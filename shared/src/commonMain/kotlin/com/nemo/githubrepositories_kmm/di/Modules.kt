package com.nemo.githubrepositories_kmm.di

import org.koin.dsl.module


private val commonModule = module {

}

private val platFormModule = module {

}

val appModule = listOf(commonModule, platFormModule)
