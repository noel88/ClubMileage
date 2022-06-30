package com.triple.clubmileage.service

import com.triple.clubmileage.domain.MileageType
import com.triple.clubmileage.domain.ReviewEvent
import com.triple.clubmileage.repository.MileageRepository
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

        if (reviewEvent.attackedImages!!.isNotEmpty()) {
            mileage++
        }

        //NOTE:
        // - 이전 사용자가 A 장소에 리뷰를 쓰고 지우면, 새로운 사용자는 A 장소의 첫 리뷰가 된다.

        if (reviewEventService.isFirstPlaceReview(reviewEvent.placeId)) {
            mileage++
        }

        return MileageInfo(type = MileageType.ADD, mileage = mileage)
    }

    fun mod(reviewEvent: ReviewEvent, currentModifiedReviewEvent: ReviewEvent?) : MileageInfo? {
        var mileage = 0

        //NOTE:
        // - 이전 리뷰에서 이미지를 삽입하지 않고, 수정시 삽입하는 경우 +1
        // - 이전 리뷰에서 이미지를 2장 삽입하고, 수정시 이미지를 교체하는 경우 0
        // - 이전 리뷰에서 이미지를 삽입하고, 수정시 이미지를 삭제하는 경우 -1

        return when {
            reviewEvent.attackedImages!!.isEmpty() -> {
                MileageInfo(type = MileageType.SUBTRACT, mileage = --mileage)
            }
            currentModifiedReviewEvent?.attackedImages!!.isEmpty() -> {
                MileageInfo(type = MileageType.ADD, mileage = ++mileage)
            }
            else -> {
                null
            }
        }
    }

    fun del(mileageEventDto: MileageEventDto): MileageInfo {
        val point = mileageRepository.findByPlaceUserMileage(mileageEventDto.userId, mileageEventDto.placeId)
        return MileageInfo(type = MileageType.SUBTRACT, mileage = (point ?: 0) * -1)
    }
}
