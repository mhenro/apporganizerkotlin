package org.mhenro.AppOrganizer.model.entity

import java.io.Serializable
import javax.persistence.*

@Entity
class Company (
        @Id
        @SequenceGenerator(name = "seq", initialValue = 1, allocationSize = 100)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
        var id: Long = 0,
        var name: String = "",
        var url: String = "",

        @Embedded
        var address: Address? = null,

        @Embedded
        var contactPerson: ContactPerson? = null
) : Serializable