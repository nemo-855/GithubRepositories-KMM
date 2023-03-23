package com.nemo.githubrepositories_kmm.data.apis

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.post

class NetworkService(val httpClient: HttpClient) {
    suspend inline fun <reified T : Any> get(
        url: String
    ): T = httpClient.get(url).body()

    suspend inline fun <reified T> post(
        urlString: String,
        block: HttpRequestBuilder.() -> Unit = {},
    ): T = httpClient.post(urlString, block).body()
}
