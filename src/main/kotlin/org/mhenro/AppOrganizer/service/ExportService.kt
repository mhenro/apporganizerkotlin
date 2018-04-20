package org.mhenro.AppOrganizer.service

import org.mhenro.AppOrganizer.repository.AppointmentRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.servlet.http.HttpServletResponse
import org.supercsv.io.CsvBeanWriter
import org.supercsv.prefs.CsvPreference

@Service
@Transactional(readOnly = true)
class ExportService(val appointmentRepository: AppointmentRepository) {
    private val csvFileName  = "appointments.csv"

    fun download(response: HttpServletResponse) {
        prepareResponse(response)
        val appointments = appointmentRepository.findAll()

        val writer = CsvBeanWriter(response.writer, CsvPreference.STANDARD_PREFERENCE)
        writer.use {
            val header = arrayOf("ID", "Confirmed", "Cancelled", "Note", "Date", "Time", "Company")
            writer.writeHeader(*header)
            for (app in appointments) {
                writer.write(app, *header)
            }
        }
    }

    fun prepareResponse(response: HttpServletResponse) {
        response.contentType = "text/csv"
        val headerKey = "Content-Disposition"
        val headerValue = "attachment; filename=\"$csvFileName\""
        response.setHeader(headerKey, headerValue)
    }
}