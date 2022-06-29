package com.triple.clubmileage.service.dto

import com.triple.clubmileage.domain.Action
import com.triple.clubmileage.domain.Type

data class EventDto (
    var type: Type,
    var action: Action,
    var reviewId: String,
    var content: String,
    var attachedPhotoIds: List<String>? = null,
    var userId: String,
    var placeId: String,
) 