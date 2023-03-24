package com.nemo.githubrepositories_kmm.data.apis.responses

import com.nemo.githubrepositories_kmm.data.models.GithubProject
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
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
) {
    fun toGithubProject() = GithubProject(
        id = id,
        name = name,
        isPrivate = private,
        ownerName = owner.login,
        createdTime = Instant.parse(createdAt).toLocalDateTime(TimeZone.currentSystemDefault())
    )
}

@Serializable
class OwnerResponse(
    val login: String
)

@Serializable
class GithubApiErrorResponse(
    val message: String,
    val documentationUrl: String
)
