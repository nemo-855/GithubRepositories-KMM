package com.nemo.githubrepositories_kmm.domain

import com.nemo.githubrepositories_kmm.data.models.GithubProject
import com.nemo.githubrepositories_kmm.data.repositories.interfaces.GithubRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class GithubUseCaseImpl(
    private val githubRepository: GithubRepository
) : GithubUseCase {
    override fun fetchGithubProjects(userName: String): Flow<List<GithubProject>> {
        return flow {
            githubRepository.fetchGithubProjects(userName = userName)
        }
    }
}
