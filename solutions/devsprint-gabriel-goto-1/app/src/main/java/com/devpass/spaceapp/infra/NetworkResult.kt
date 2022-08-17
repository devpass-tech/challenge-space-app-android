package com.devpass.spaceapp.infra

sealed class NetworkResult<T>(
    val data: T? = null,
    val message: String? = null
) {

    class Success<SUCCESS>(data: SUCCESS) : NetworkResult<SUCCESS>(data)

    class Error<ERROR>(message: String?) : NetworkResult<ERROR>(null, message)

    class Loading<LOADING> : NetworkResult<LOADING>()
}

suspend fun <T> isSuccess(block: suspend () -> T): NetworkResult<T> {
    return try {
        val result = block()

        NetworkResult.Success(result)
    } catch (ex: Exception) {
        NetworkResult.Error(ex.localizedMessage)
    }
}
