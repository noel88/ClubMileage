package com.triple.clubmileage.service.event.mileage

import com.triple.clubmileage.domain.ReviewEvent
import com.triple.clubmileage.service.ReviewEventService

class ReviewFirstPlace(
    private val reviewEventService: ReviewEventService,
): MileageGrant() {

    var mileage = 0

    override fun grant(reviewEvent: ReviewEvent): Int {
        if (reviewEventService.isFirstPlaceReview(reviewEvent.placeId)) {
            return mileage++
        }
        return mileage
    }
}