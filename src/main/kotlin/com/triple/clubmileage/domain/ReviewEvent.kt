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

    @ElementCollection
    var attackedImages: List<String> = arrayListOf(),

    var userId: String,
    var reviewId: String,
    var placeId: String,

    @CreatedDate
    @Column(updatable = false)
    var createdDate: LocalDateTime? = null,
    @LastModifiedDate
    var modifiedDate: LocalDateTime? = null,
)