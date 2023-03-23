package com.nemo.githubrepositories_kmm.data.apis.implements

import com.nemo.githubrepositories_kmm.data.apis.EndPoints.githubApiEndpoint
import com.nemo.githubrepositories_kmm.data.apis.NetworkService
import com.nemo.githubrepositories_kmm.data.apis.interfaces.GithubApi
import com.nemo.githubrepositories_kmm.data.apis.responses.FetchAllProjectsResponse

internal class GithubApiImpl(private val networkService: NetworkService) : GithubApi {
    override suspend fun fetchAllProjects(userName: String): FetchAllProjectsResponse {
        return networkService.get("$githubApiEndpoint/users/{userName}/repos")
    }
}
