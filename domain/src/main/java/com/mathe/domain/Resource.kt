package com.mathe.domain

class Resources<T> private constructor(
    var status: StatusRequest,
    var data: T? = null,
    var error: String? = null
) {

    companion object {
        fun <T> successResponse(data: T?): Resources<T> {
            return Resources(
                StatusRequest.SUCCESS,
                data
            )
        }

        fun <T> errorResponse(error: String?): Resources<T> {
            return Resources(
                StatusRequest.ERROR,
                error = error
            )
        }

    }

    enum class StatusRequest {
        SUCCESS, ERROR
    }

}