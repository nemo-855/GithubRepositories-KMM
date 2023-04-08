package com.nemo.githubrepositories_kmm.data.apis

import com.nemo.githubrepositories_kmm.BuildConfig
import com.nemo.githubrepositories_kmm.data.defaultKtorConfig
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

actual object APICommunicationImpl {
    actual fun createAPICommunication(): APICommunication {
        return object : APICommunication {
            override fun client(): HttpClient {
                return HttpClient(OkHttp) {
                    engine {
                        config {
                            preconfigured = provideOkHttpClient()
                            addInterceptor(
                                HttpLoggingInterceptor().apply {
                                    level = if (BuildConfig.DEBUG) {
                                        HttpLoggingInterceptor.Level.BODY
                                    } else {
                                        HttpLoggingInterceptor.Level.NONE
                                    }
                                }
                            )
                        }
                    }
                    defaultKtorConfig()
                }
            }
        }
    }

    private fun provideOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
            builder.addNetworkInterceptor(httpLoggingInterceptor)
        }
        return builder.build()
    }
}