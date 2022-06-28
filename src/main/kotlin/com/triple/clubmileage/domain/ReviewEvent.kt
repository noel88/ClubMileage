package com.triple.clubmileage.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@EntityListeners(AuditingEntityListener::class)
data class ReviewEvent(
    @Id
    var id: String,
    var content: String,

    @OneToMany(cascade = [CascadeType.ALL])
    var attackedImages: MutableList<AttachedPhoto>?,

    var userId: String,
    var placeId: String,
    var mileage: Int,

    @CreatedDate
    @Column(updatable = false)
    var createdDate: LocalDateTime? = null,
    @LastModifiedDate
    var modifiedDate: LocalDateTime? = null,
)