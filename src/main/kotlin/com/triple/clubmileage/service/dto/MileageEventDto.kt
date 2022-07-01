package com.triple.clubmileage.service.dto

import com.triple.clubmileage.domain.Action

data class MileageEventDto (
    var reviewId: String,
    var action: Action,
    var userId: String,
    var placeId: String,
)