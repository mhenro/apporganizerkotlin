package org.mhenro.AppOrganizer.model

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class Response<T> {
    var message: T? = null
}

fun <T> createResponseEntity(message: T, httpStatus: HttpStatus): ResponseEntity<Response<T>> {
    var response = Response<T>()
    response.message = message
    return ResponseEntity(response, httpStatus)
}