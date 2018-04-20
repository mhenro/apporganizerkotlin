package org.mhenro.AppOrganizer.repository

import org.mhenro.AppOrganizer.model.entity.Appointment
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface AppointmentRepository : JpaRepository<Appointment, Long> {
    @Query("SELECT a FROM Appointment a ORDER BY a.cancelled, a.confirmed, a.date, a.time")
    fun findAppointments(pageable: Pageable): Page<Appointment>
}