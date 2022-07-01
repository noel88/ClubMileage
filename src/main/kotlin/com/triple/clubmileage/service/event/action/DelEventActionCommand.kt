package com.triple.clubmileage.service.event.action

import com.triple.clubmileage.service.ActionService
import com.triple.clubmileage.service.dto.MileageEventDto
import com.triple.clubmileage.service.dto.MileageInfo

class DelEventActionCommand(
    private val actionService: ActionService,
    private val mileageEventDto: MileageEventDto,
) : EventActionCommand {
    override fun execute(): MileageInfo? {
        return actionService.del(mileageEventDto)
    }

}