package org.mhenro.AppOrganizer.util

fun getErrorOrDefaultMessage(e: Exception, defaultMessage: String): String? {
    if (e != null && e.message != null) {
        return e.message
    } else {
        return defaultMessage
    }
}