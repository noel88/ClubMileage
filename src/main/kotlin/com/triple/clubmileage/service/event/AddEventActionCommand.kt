package com.triple.clubmileage.service.event

import com.triple.clubmileage.domain.ReviewEvent
import com.triple.clubmileage.service.ActionService
import com.triple.clubmileage.service.dto.MileageEventDto
import com.triple.clubmileage.service.dto.MileageInfo

class AddEventActionCommand(
    private val actionService: ActionService,
    private var reviewEvent: ReviewEvent

    ) : EventActionCommand {
    override fun execute(): MileageInfo? {
        return actionService.add(reviewEvent)
    }

}