package org.mhenro.AppOrganizer.service

import org.mhenro.AppOrganizer.repository.CompanyRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class CompanyService(val companyRepository: CompanyRepository) {
    fun getAllCompanies() = companyRepository.findAll()
}