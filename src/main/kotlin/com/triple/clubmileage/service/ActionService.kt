package com.triple.clubmileage.service

import com.triple.clubmileage.domain.MileageType
import com.triple.clubmileage.domain.ReviewEvent
import com.triple.clubmileage.repository.MileageRepository
import com.triple.clubmileage.service.dto.EventDto
import com.triple.clubmileage.service.dto.MileageEventDto
import com.triple.clubmileage.service.dto.MileageInfo
import org.springframework.stereotype.Service

@Service
class ActionService(
    private val reviewEventService: ReviewEventService,
    private val mileageRepository: MileageRepository
) {
    fun add(reviewEvent: ReviewEvent): MileageInfo {
        var mileage = 1

        if (reviewEvent.attackedImages?.isNotEmpty() == true) {
            mileage++
        }

        if (reviewEventService.countByPlaceId(reviewEvent.placeId) == 1) {
            mileage++
        }

        return MileageInfo(type = MileageType.ADD, mileage = mileage)
    }

    fun mod(reviewEvent: ReviewEvent, currentModifiedReviewEvent: ReviewEvent?) : MileageInfo? {
        var mileage = 0

        return when {
            reviewEvent.attackedImages == null -> {
                return MileageInfo(type = MileageType.SUBTRACT, mileage = --mileage)
            }
            !reviewEvent.attackedImages!!.containsAll(currentModifiedReviewEvent!!.attackedImages!!)  -> {
                return MileageInfo(type = MileageType.SUBTRACT, mileage = --mileage)
            }
            reviewEvent.attackedImages!!.containsAll(currentModifiedReviewEvent!!.attackedImages!!) -> {
                return null
            }
            else -> {
                return MileageInfo(type = MileageType.ADD, mileage = ++mileage)
            }
        }
    }

    fun del(mileageEventDto: MileageEventDto): MileageInfo {
        val point = mileageRepository.findByPlaceUserMileage(mileageEventDto.userId, mileageEventDto.placeId)
        return MileageInfo(type = MileageType.SUBTRACT, mileage = (point ?: 0) * -1)
    }
}
