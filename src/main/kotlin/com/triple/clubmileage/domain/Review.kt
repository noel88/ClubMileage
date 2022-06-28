package com.triple.clubmileage.domain

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity
data class Review(
    @Id
    var id: String,
    var content: String,

    @OneToMany(cascade = [CascadeType.ALL])
    var attackedImages: MutableList<AttachedPhoto>?,

    @OneToMany
    var Users: MutableList<User>?,
    @ManyToOne
    var place: Place

)