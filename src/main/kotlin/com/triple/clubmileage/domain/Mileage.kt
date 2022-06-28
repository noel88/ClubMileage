package com.triple.clubmileage.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@EntityListeners(AuditingEntityListener::class)
@Table(indexes = [Index(name = "i_user", columnList = "userId")])
data class Mileage(
    @Id
    var id: String,

    @Enumerated(value = EnumType.STRING)
    var mileageType: MileageType,
    var mileage: Int = 0,
    var userId: String,

    @CreatedDate
    @Column(updatable = false)
    var createdDate: LocalDateTime? = null,
    @LastModifiedDate
    var modifiedDate: LocalDateTime? = null,

    @OneToOne
    var reviewEvent: ReviewEvent? = null
)