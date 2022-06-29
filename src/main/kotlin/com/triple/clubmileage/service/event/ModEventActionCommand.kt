package com.triple.clubmileage.service.event

import com.triple.clubmileage.domain.ReviewEvent
import com.triple.clubmileage.service.ActionService
import com.triple.clubmileage.service.dto.MileageEventDto
import com.triple.clubmileage.service.dto.MileageInfo

class ModEventActionCommand(
    private val actionService: ActionService,
    private var reviewEvent: ReviewEvent,
    private var mileageEventDto: MileageEventDto,
) : EventActionCommand {
    override fun execute(): MileageInfo {
        return actionService.mod(reviewEvent, mileageEventDto)
    }

}