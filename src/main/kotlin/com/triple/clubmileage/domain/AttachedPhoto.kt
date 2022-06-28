package com.triple.clubmileage.domain

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class AttachedPhoto(
    @Id
    var id: String,
)