package org.mhenro.AppOrganizer.model.entity

import java.io.Serializable
import javax.persistence.*
import java.time.*

@Entity
class Appointment (
        @Id
        @SequenceGenerator(name = "seq", initialValue = 1, allocationSize = 100)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
        var id: Long = 0,
        var confirmed: Boolean = false,
        var cancelled: Boolean = false,
        var note: String = "",
        var date: LocalDate? = null,
        var time: LocalTime? = null,

        @ManyToOne
        @JoinColumn(name = "company_id")
        var company: Company? = null
) : Serializable