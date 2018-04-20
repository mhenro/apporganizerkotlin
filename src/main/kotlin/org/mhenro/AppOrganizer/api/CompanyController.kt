package org.mhenro.AppOrganizer.api

import org.mhenro.AppOrganizer.model.createResponseEntity
import org.mhenro.AppOrganizer.service.CompanyService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
class CompanyController(val companyService: CompanyService) {
    @RequestMapping(value = "companies", method = [RequestMethod.GET])
    fun getCompanies() = createResponseEntity(companyService.getAllCompanies(), HttpStatus.OK)
}