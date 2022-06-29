package com.triple.clubmileage.service

import com.triple.clubmileage.domain.Action
import com.triple.clubmileage.domain.Mileage
import com.triple.clubmileage.repository.MileageRepository
import com.triple.clubmileage.service.dto.MileageDto
import com.triple.clubmileage.service.dto.MileageEventDto
import com.triple.clubmileage.service.event.AddEventActionCommand
import com.triple.clubmileage.service.event.DelEventActionCommand
import com.triple.clubmileage.service.event.ModEventActionCommand
import org.springframework.stereotype.Service
import java.util.*

@Service
class MileageService(
    private val mileageRepository: MileageRepository,
    private val reviewEventService: ReviewEventService,
    private val actionService: ActionService
) {

    fun event(mileageEventDto: MileageEventDto) {

        val reviewEvent = reviewEventService.findByReviewId(mileageEventDto.reviewId)
        val currentModifiedReviewEvent = reviewEventService.findByCurrentModifiedReviewEvent(mileageEventDto.userId, mileageEventDto.placeId)

        val types = mutableMapOf(
            Action.ADD to AddEventActionCommand(actionService, reviewEvent!!),
            Action.MOD to ModEventActionCommand(actionService, reviewEvent, currentModifiedReviewEvent),
            Action.DELETE to DelEventActionCommand(actionService, mileageEventDto),
        )

        val mileageInfo = types[mileageEventDto.action]?.execute()

        mileageInfo?.let {
            mileageRepository.save(
                Mileage(
                    id = UUID.randomUUID().toString(),
                    mileageType = it.type,
                    point = it.mileage,
                    userId = mileageEventDto.userId,
                    placeId = mileageEventDto.placeId,
                    reviewEventId = mileageEventDto.reviewId
                )
            )
        }
    }

    fun getTotalMileage(userId: String): MileageDto {
        return MileageDto(
            userId = userId,
            mileage = mileageRepository.findByTotalUserMileage(userId) ?: 0
        )
    }


}