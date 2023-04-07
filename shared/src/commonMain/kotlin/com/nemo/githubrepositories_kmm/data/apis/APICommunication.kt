package com.nemo.githubrepositories_kmm.data.apis

import io.ktor.client.HttpClient

interface APICommunication {
    fun client(): HttpClient
}