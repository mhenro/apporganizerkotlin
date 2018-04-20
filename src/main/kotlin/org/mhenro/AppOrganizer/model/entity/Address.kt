package org.mhenro.AppOrganizer.model.entity

import java.io.Serializable
import javax.persistence.Embeddable

@Embeddable
class Address (
        var street: String = "",
        var houseNumber: Int = 0,
        var postalCode: String = "",
        var locality: String = ""
) : Serializable