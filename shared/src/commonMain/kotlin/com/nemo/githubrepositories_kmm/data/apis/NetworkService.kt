package com.nemo.githubrepositories_kmm.data.apis

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.post

class NetworkService(val apiCommunication: APICommunication) {
    suspend inline fun <reified T : Any> get(
        url: String
    ): T = apiCommunication.client().get(url).body()

    suspend inline fun <reified T> post(
        urlString: String,
        block: HttpRequestBuilder.() -> Unit = {},
    ): T = apiCommunication.client().post(urlString, block).body()
}
