package com.triple.clubmileage.service.event.mileage

import com.triple.clubmileage.domain.MileageType
import com.triple.clubmileage.domain.ReviewEvent
import com.triple.clubmileage.service.dto.MileageInfo

class ReviewModImages: MileageModGrant() {

    var mileage = 0

    override fun grant(reviewEvent: ReviewEvent, currentReview: ReviewEvent?): MileageInfo? {
        return when {
            reviewEvent.attackedImages!!.isEmpty() -> {
                MileageInfo(type = MileageType.SUBTRACT, mileage = --mileage)
            }

            currentReview?.attackedImages!!.isEmpty() -> {
                MileageInfo(type = MileageType.ADD, mileage = ++mileage)
            }
            else -> {
                null
            }
        }
    }
}