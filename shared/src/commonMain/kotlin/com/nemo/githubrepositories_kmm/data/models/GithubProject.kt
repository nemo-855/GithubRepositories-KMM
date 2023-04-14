package com.nemo.githubrepositories_kmm.data.models

import kotlinx.datetime.LocalDateTime

class GithubProject(
    val id: Int,
    val name: String,
    val isPrivate: Boolean,
    val owner: Owner,
    val createdTime: LocalDateTime,
    val htmlUrl: String,
)
