package org.mhenro.AppOrganizer.model.request

import java.time.*

class AppointmentRequest(
        var appId: Long = 0,
        var date: LocalDate? = null,
        var time: LocalTime? = null,
        var companyId: Long = 0
)