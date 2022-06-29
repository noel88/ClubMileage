package com.triple.clubmileage.service.dto

import com.triple.clubmileage.domain.MileageType

data class MileageInfo (
    var type: MileageType,
    var mileage: Int,
)