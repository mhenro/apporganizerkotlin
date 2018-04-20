package org.mhenro.AppOrganizer.api

import org.mhenro.AppOrganizer.model.createResponseEntity
import org.mhenro.AppOrganizer.service.ExportService
import org.mhenro.AppOrganizer.util.getErrorOrDefaultMessage
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.io.IOException
import javax.servlet.http.HttpServletResponse

@Controller
@CrossOrigin
class ExportController(val exportService: ExportService) {
    @RequestMapping(value = "/download", method = [RequestMethod.GET])
    fun download(response: HttpServletResponse) = exportService.download(response)

    /* ----------------------------------------exception handlers------------------------------------------------ */

    @ExceptionHandler(IOException::class)
    fun ioException(e: IOException): ResponseEntity<*> {
        return createResponseEntity(getErrorOrDefaultMessage(e, "Csv file downloading failed"), HttpStatus.INTERNAL_SERVER_ERROR)
    }
}