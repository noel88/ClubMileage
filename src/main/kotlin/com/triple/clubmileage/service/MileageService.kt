package com.triple.clubmileage.service

import com.triple.clubmileage.domain.Action
import com.triple.clubmileage.domain.Mileage
import com.triple.clubmileage.repository.MileageRepository
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

        val reviewEvent = reviewEventService.findById(mileageEventDto.reviewId)

        val types = mutableMapOf(
            Action.ADD to AddEventActionCommand(actionService, reviewEvent!!, mileageEventDto),
            Action.MOD to ModEventActionCommand(actionService, reviewEvent, mileageEventDto),
            Action.DELETE to DelEventActionCommand(actionService, mileageEventDto),
        )

        val mileageInfo = types[Action.ADD]?.execute()

        mileageRepository.save(
            Mileage(
                id = UUID.randomUUID().toString(),
                mileageType = mileageInfo!!.type,
                mileage = mileageInfo.mileage,
                userId = mileageEventDto.userId,
                reviewEvent = reviewEventService.findById(mileageEventDto.reviewId)
            )
        )
    }

}