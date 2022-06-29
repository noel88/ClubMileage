package com.triple.clubmileage.service.event

import com.triple.clubmileage.service.dto.MileageInfo

interface EventActionCommand {
    fun execute(): MileageInfo?
}