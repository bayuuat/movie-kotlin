package com.example.data.test

import com.example.challengelima.api.ApiClient
import com.example.data.api.ApiKey
import org.junit.Test

class ApiClientTest {
    @Test
    fun testPlacesService() {
        //Execute the API call
        val response = ApiClient.apiClient.getTrendingMovie("tv",ApiKey.apiKeyTMDB).execute()
        //Check for error body
        val errorBody = response.errorBody()
        assert(errorBody == null)
        //Check for success body
        val responseWrapper = response.body()
        assert(responseWrapper != null)
        assert(response.code() == 200)
    }
}