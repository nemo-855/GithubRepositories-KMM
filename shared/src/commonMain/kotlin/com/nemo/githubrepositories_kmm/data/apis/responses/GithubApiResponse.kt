package com.nemo.githubrepositories_kmm.data.apis.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class FetchAllProjectsResponse(
    val id: Int,
    val name: String,
    val private: Boolean,
    val owner: OwnerResponse,
    @SerialName("created_at")
    val createdAt: String
)

@Serializable
class OwnerResponse(
    val login: String
)

@Serializable
class GithubApiErrorResponse(
    val message: String,
    val documentationUrl: String
)
