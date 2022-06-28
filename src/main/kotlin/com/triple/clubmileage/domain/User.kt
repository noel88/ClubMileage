package com.triple.clubmileage.domain

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name = "users")
data class User(
    @Id
    var id: String,

    @OneToOne
    var mileage: Mileage

)