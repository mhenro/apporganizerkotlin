package org.mhenro.AppOrganizer.model.exception

class WrongDataException : RuntimeException {
    constructor() : super()
    constructor(message: String) : super(message)
}