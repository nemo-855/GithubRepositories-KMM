package com.nemo.githubrepositories_kmm.di

import org.koin.core.context.startKoin

fun initDi() {
    startKoin {
        modules(appModule())
    }
}