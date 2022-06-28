package com.triple.clubmileage.domain

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
data class Mileage(
    @Id
    var id: String,
    var point: Int
)