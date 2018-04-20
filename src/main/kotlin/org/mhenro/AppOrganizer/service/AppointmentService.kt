package org.mhenro.AppOrganizer.service

import org.mhenro.AppOrganizer.model.exception.ObjectNotFoundException
import org.mhenro.AppOrganizer.model.exception.WrongDataException
import org.mhenro.AppOrganizer.model.request.AppointmentNoteRequest
import org.mhenro.AppOrganizer.model.request.AppointmentRequest
import org.mhenro.AppOrganizer.repository.AppointmentRepository
import org.mhenro.AppOrganizer.repository.CompanyRepository
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class AppointmentService(val appointmentRepository: AppointmentRepository, val companyRepository: CompanyRepository) {

    fun getAppointments(pageable: Pageable) = appointmentRepository.findAppointments(pageable)

    fun getAppointmentDetails(id: Long) = appointmentRepository.findById(id).orElseThrow{ ObjectNotFoundException("Appointment is not found") }

    @Transactional
    fun saveAppointment(request: AppointmentRequest) {
        var appointment = getAppointmentDetails(request.appId)
        var company = companyRepository.findById(request.companyId).orElse(null)
        appointment.date = request.date
        appointment.time = request.time
        appointment.company = company
        appointmentRepository.save(appointment)
    }

    @Transactional
    fun confirmAppointment(id: Long) {
        var appointment = getAppointmentDetails(id)
        if (appointment.cancelled) WrongDataException("Appointment is already cancelled")
        appointment.confirmed = true
        appointmentRepository.save(appointment)
    }

    @Transactional
    fun addNoteToAppointment(request: AppointmentNoteRequest) {
        var appointment = getAppointmentDetails(request.id)
        appointment.note = request.note
        appointmentRepository.save(appointment)
    }

    @Transactional
    fun cancelAppointment(id: Long) {
        var appointment = getAppointmentDetails(id)
        if (appointment.confirmed) throw WrongDataException("Appointment is already confirmed")
        appointment.cancelled = true
        appointmentRepository.save(appointment)
    }

    @Transactional
    fun deleteAppointment(id: Long) {
        var appointment = getAppointmentDetails(id)
        appointmentRepository.delete(appointment)
    }
}