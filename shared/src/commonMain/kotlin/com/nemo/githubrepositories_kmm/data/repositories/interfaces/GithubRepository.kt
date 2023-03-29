package com.nemo.githubrepositories_kmm.data.repositories.interfaces

import com.nemo.githubrepositories_kmm.data.models.GithubProject

internal interface GithubRepository {
    suspend fun fetchGithubProjects(userName: String): List<GithubProject>
}
