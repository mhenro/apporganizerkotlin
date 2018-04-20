package org.mhenro.AppOrganizer

import org.mhenro.AppOrganizer.model.entity.Appointment
import org.mhenro.AppOrganizer.repository.AppointmentRepository
import org.springframework.boot.Banner
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class AppOrganizerApplication

fun main(args: Array<String>) {
    val app = SpringApplication(AppOrganizerApplication::class.java)
    app.setBannerMode(Banner.Mode.OFF)
    app.run(*args)
}
