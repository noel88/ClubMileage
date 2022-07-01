package com.triple.clubmileage.service.event.action

import com.triple.clubmileage.domain.ReviewEvent
import com.triple.clubmileage.service.ActionService
import com.triple.clubmileage.service.dto.MileageInfo

class ModEventActionCommand(
    private val actionService: ActionService,
    private var reviewEvent: ReviewEvent,
    private var currentModifiedReviewEvent: ReviewEvent?
) : EventActionCommand {
    override fun execute(): MileageInfo? {
        return actionService.mod(reviewEvent, currentModifiedReviewEvent)
    }

}