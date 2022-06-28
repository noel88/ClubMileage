package com.triple.clubmileage.domain

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class AuditLog(
    @Id
    var id: String,
    var userId: String,

    //TODO: 포인트 증감 이력을 어떻게 표현할 것인가?

)