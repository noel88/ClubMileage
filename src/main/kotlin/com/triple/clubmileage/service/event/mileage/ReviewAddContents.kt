package com.triple.clubmileage.service.event.mileage

import com.triple.clubmileage.domain.ReviewEvent

class ReviewAddContents: MileageGrant() {

    var mileage = 0

    override fun grant(reviewEvent: ReviewEvent): Int {
       return 1
    }
}