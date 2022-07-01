package com.triple.clubmileage.service.event.mileage

import com.triple.clubmileage.domain.ReviewEvent

abstract class MileageGrant {
    abstract fun grant(reviewEvent: ReviewEvent): Int
}