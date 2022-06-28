package com.triple.clubmileage.domain

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
data class Place(
    @Id
    var id: String,

    @OneToMany(mappedBy = "place")
    var review: MutableList<Review>?
)