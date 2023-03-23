package com.nemo.githubrepositories_kmm.data.apis.interfaces

import com.nemo.githubrepositories_kmm.data.apis.responses.FetchAllProjectsResponse

interface GithubApi {
    suspend fun fetchAllProjects(userName: String): FetchAllProjectsResponse
}
