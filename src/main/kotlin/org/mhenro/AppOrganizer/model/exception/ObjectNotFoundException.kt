package org.mhenro.AppOrganizer.model.exception

class ObjectNotFoundException : RuntimeException {
    constructor() : super()
    constructor(message: String) : super(message)
}