package com.triple.clubmileage.service

import com.triple.clubmileage.domain.MileageType
import com.triple.clubmileage.domain.ReviewEvent
import com.triple.clubmileage.service.dto.MileageEventDto
import com.triple.clubmileage.service.dto.MileageInfo
import org.springframework.stereotype.Service

@Service
class ActionService(
    private val reviewEventService: ReviewEventService
) {
    fun add(reviewEvent: ReviewEvent, mileageEventDto: MileageEventDto): MileageInfo {
        var mileage = 0

        if (reviewEvent.content.isNotEmpty()) {
            ++mileage
        }
        if (reviewEvent.attackedImages?.isNotEmpty() == true) {
            ++mileage
        }
        if (reviewEventService.countByPlaceId(mileageEventDto.placeId) > 0) {
            ++mileage
        }

        return MileageInfo(type = MileageType.ADD, mileage = mileage)
    }

    fun mod(reviewEvent: ReviewEvent, mileageEventDto: MileageEventDto) : MileageInfo{
        var mileage = 0
        val type = if (reviewEvent.attackedImages?.isNotEmpty() == true) {
            ++mileage
            MileageType.ADD
        } else {
            --mileage
            MileageType.SUBTRACT
        }
        return MileageInfo(type = type, mileage = mileage)
    }

    fun del(mileageEventDto: MileageEventDto): MileageInfo {
        return MileageInfo(type = MileageType.ADD, mileage = 0)
    }
}
