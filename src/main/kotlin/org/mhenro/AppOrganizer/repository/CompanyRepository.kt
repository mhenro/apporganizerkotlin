package org.mhenro.AppOrganizer.repository

import org.mhenro.AppOrganizer.model.entity.Company
import org.springframework.data.jpa.repository.JpaRepository

interface CompanyRepository : JpaRepository<Company, Long> {
}