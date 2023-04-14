package com.nemo.githubrepositories_kmm.data.apis.responses

import com.nemo.githubrepositories_kmm.data.models.GithubProject
import com.nemo.githubrepositories_kmm.data.models.Owner
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
    val createdAt: String,
    @SerialName("html_url")
    val htmlUrl: String,
) {
    fun toGithubProject() = GithubProject(
        id = id,
        name = name,
        isPrivate = private,
        owner = owner.toOwner(),
        createdTime = Instant.parse(createdAt).toLocalDateTime(TimeZone.currentSystemDefault()),
        htmlUrl = htmlUrl,
    )
}

@Serializable
class OwnerResponse(
    val login: String,
    @SerialName("avatar_url")
    val avatarUrl: String,
) {
    fun toOwner() = Owner(
        name = login,
        avatarUrl = avatarUrl,
    )
}

@Serializable
class GithubApiErrorResponse(
    val message: String,
    val documentationUrl: String
)
