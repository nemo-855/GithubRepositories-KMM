package com.nemo.githubrepositories_kmm.data.repositories.implementations

import com.nemo.githubrepositories_kmm.data.apis.interfaces.GithubApi
import com.nemo.githubrepositories_kmm.data.models.GithubProject
import com.nemo.githubrepositories_kmm.data.repositories.interfaces.GithubRepository

class GithubRepositoryImpl(private val githubApi: GithubApi) : GithubRepository {
    override suspend fun fetchGithubProjects(userName: String): List<GithubProject> {
        return githubApi.fetchAllProjects(userName = userName).map {
            it.toGithubProject()
        }
    }
}