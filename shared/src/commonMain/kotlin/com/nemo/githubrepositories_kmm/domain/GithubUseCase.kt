package com.nemo.githubrepositories_kmm.domain

import com.nemo.githubrepositories_kmm.data.models.GithubProject

interface GithubUseCase {
    suspend fun fetchGithubProjects(userName: String): List<GithubProject>
}
