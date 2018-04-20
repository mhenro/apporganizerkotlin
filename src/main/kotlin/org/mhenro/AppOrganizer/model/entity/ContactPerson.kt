package org.mhenro.AppOrganizer.model.entity

import java.io.Serializable
import javax.persistence.Embeddable

@Embeddable
class ContactPerson(
        var firstName: String = "",
        var lastName: String = "",
        var phone: String = "",
        var email: String = "",
        var salutation: String = ""
) : Serializable