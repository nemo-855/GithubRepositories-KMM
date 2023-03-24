package com.nemo.githubrepositories_kmm.domain

import com.nemo.githubrepositories_kmm.data.models.GithubProject
import com.nemo.githubrepositories_kmm.data.repositories.interfaces.GithubRepository

class GithubUseCaseImpl(
    private val githubRepository: GithubRepository
) : GithubUseCase {
    override suspend fun fetchGithubProjects(userName: String): List<GithubProject> {
        return githubRepository.fetchGithubProjects(userName = userName)
    }
}
