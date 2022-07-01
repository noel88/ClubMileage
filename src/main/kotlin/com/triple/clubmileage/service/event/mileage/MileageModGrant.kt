package com.triple.clubmileage.service.event.mileage

import com.triple.clubmileage.domain.ReviewEvent
import com.triple.clubmileage.service.dto.MileageInfo

abstract class MileageModGrant {
    abstract fun grant(reviewEvent: ReviewEvent, currentReview: ReviewEvent?): MileageInfo?
}