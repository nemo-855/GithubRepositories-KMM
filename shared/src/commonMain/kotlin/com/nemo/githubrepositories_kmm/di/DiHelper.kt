package com.nemo.githubrepositories_kmm.di

import org.koin.core.context.startKoin

fun init() {
    startKoin { appModule }
}