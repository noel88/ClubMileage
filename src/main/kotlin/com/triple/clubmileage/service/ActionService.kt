package com.triple.clubmileage.service

import com.triple.clubmileage.domain.MileageType
import com.triple.clubmileage.domain.ReviewEvent
import com.triple.clubmileage.repository.MileageRepository
import com.triple.clubmileage.service.dto.MileageEventDto
import com.triple.clubmileage.service.dto.MileageInfo
import com.triple.clubmileage.service.event.mileage.ReviewAddContents
import com.triple.clubmileage.service.event.mileage.ReviewAddImages
import com.triple.clubmileage.service.event.mileage.ReviewFirstPlace
import com.triple.clubmileage.service.event.mileage.ReviewModImages
import org.springframework.stereotype.Service

@Service
class ActionService(
    private val reviewEventService: ReviewEventService,
    private val mileageRepository: MileageRepository,
) {
    fun add(reviewEvent: ReviewEvent): MileageInfo {
        val mileage = ReviewAddContents().grant(reviewEvent) + ReviewAddImages().grant(reviewEvent) + ReviewFirstPlace(
            reviewEventService
        ).grant(reviewEvent)
        return MileageInfo(type = MileageType.ADD, mileage = mileage)
    }

    fun mod(reviewEvent: ReviewEvent, currentModifiedReviewEvent: ReviewEvent?): MileageInfo? {

        //NOTE:
        // - 이전 리뷰에서 이미지를 삽입하지 않고, 수정시 삽입하는 경우 +1
        // - 이전 리뷰에서 이미지를 2장 삽입하고, 수정시 이미지를 교체하는 경우 0
        // - 이전 리뷰에서 이미지를 삽입하고, 수정시 이미지를 삭제하는 경우 -1

        return ReviewModImages().grant(reviewEvent, currentModifiedReviewEvent)
    }

    fun del(mileageEventDto: MileageEventDto): MileageInfo {
        val point = mileageRepository.findByPlaceUserMileage(mileageEventDto.userId, mileageEventDto.placeId)
        return MileageInfo(type = MileageType.SUBTRACT, mileage = (point ?: 0) * -1)
    }
}
