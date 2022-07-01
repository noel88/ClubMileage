package com.triple.clubmileage.service.event.mileage

import com.triple.clubmileage.domain.ReviewEvent

class ReviewAddImages: MileageGrant() {

    var mileage = 0

    override fun grant(reviewEvent: ReviewEvent): Int {
        if (reviewEvent.attackedImages!!.isNotEmpty()) {
            mileage++
        }
        return mileage
    }
}