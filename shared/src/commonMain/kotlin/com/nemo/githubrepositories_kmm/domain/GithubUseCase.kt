package com.nemo.githubrepositories_kmm.domain

import com.nemo.githubrepositories_kmm.data.models.GithubProject
import kotlinx.coroutines.flow.Flow

interface GithubUseCase {
    suspend fun fetchGithubProjects(userName: String): Flow<List<GithubProject>>
}
