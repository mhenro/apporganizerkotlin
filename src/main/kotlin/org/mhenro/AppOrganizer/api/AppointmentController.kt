package org.mhenro.AppOrganizer.api

import org.mhenro.AppOrganizer.model.createResponseEntity
import org.mhenro.AppOrganizer.model.exception.ObjectNotFoundException
import org.mhenro.AppOrganizer.model.exception.WrongDataException
import org.mhenro.AppOrganizer.model.request.AppointmentNoteRequest
import org.mhenro.AppOrganizer.model.request.AppointmentRequest
import org.mhenro.AppOrganizer.service.AppointmentService
import org.mhenro.AppOrganizer.util.getErrorOrDefaultMessage
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
class AppointmentController(val appointmentService: AppointmentService) {

    @RequestMapping(value = ["appointments"], method = [RequestMethod.GET])
    fun getAppointments(pageable: Pageable) = appointmentService.getAppointments(pageable)

    @RequestMapping(value = ["appointments/{id}"], method = [RequestMethod.GET])
    fun getAppointmentDetails(@PathVariable id: Long) = createResponseEntity(appointmentService.getAppointmentDetails(id), HttpStatus.OK)

    @RequestMapping(value = ["appointments"], method = [RequestMethod.POST])
    fun saveAppointment(@RequestBody request: AppointmentRequest): ResponseEntity<*> {
        appointmentService.saveAppointment(request)
        return createResponseEntity("Appointment was saved successfully", HttpStatus.OK)
    }

    @RequestMapping(value = ["appointments/{id}/confirm"], method = [RequestMethod.GET])
    fun confirmAppointment(@PathVariable id: Long): ResponseEntity<*>  {
        appointmentService.confirmAppointment(id)
        return createResponseEntity("Appointment was confirmed successfully", HttpStatus.OK)
    }

    @RequestMapping(value = ["appointments/note"], method = [RequestMethod.POST])
    fun addNoteToAppointment(@RequestBody request: AppointmentNoteRequest): ResponseEntity<*>  {
        appointmentService.addNoteToAppointment(request)
        return createResponseEntity("The note was added successfully to the appointment", HttpStatus.OK)
    }

    @RequestMapping(value = ["appointments/{id}/cancel"], method = [RequestMethod.GET])
    fun cancelAppointment(@PathVariable id: Long): ResponseEntity<*> {
        appointmentService.cancelAppointment(id)
        return createResponseEntity("Appointment was cancelled successfully", HttpStatus.OK)
    }

    @RequestMapping(value = ["appointments/{id}"], method = [RequestMethod.DELETE])
    fun deleteAppointment(@PathVariable id: Long): ResponseEntity<*> {
        appointmentService.deleteAppointment(id)
        return createResponseEntity("Appointment was deleted successfully", HttpStatus.OK)
    }

    /* ----------------------------------------exception handlers------------------------------------------------ */

    @ExceptionHandler(ObjectNotFoundException::class)
    fun objectNotFound(e: ObjectNotFoundException): ResponseEntity<*> {
        return createResponseEntity(getErrorOrDefaultMessage(e, "Object is not found"), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(WrongDataException::class)
    fun wrongData(e: WrongDataException): ResponseEntity<*> {
        return createResponseEntity(getErrorOrDefaultMessage(e, "Bad request"), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(UnsupportedOperationException::class)
    fun unsupportedOperationException(e: UnsupportedOperationException): ResponseEntity<*> {
        return createResponseEntity(getErrorOrDefaultMessage(e, "Method is not supported"), HttpStatus.BAD_REQUEST)
    }
}