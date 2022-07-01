package com.triple.clubmileage

import com.triple.clubmileage.domain.Action
import com.triple.clubmileage.domain.Type
import com.triple.clubmileage.service.ReviewEventService
import com.triple.clubmileage.service.dto.EventDto
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class SeedDataConfiguration(
    private val reviewEventService: ReviewEventService
) {

    @Bean
    fun run() {
        reviewEventService.setEvent(
            EventDto(
                type = Type.REVIEW,
                action = Action.DELETE,
                reviewId = "7dc637dd-26b0-4ca3-85f3-bb9ccf0dda13",
                content = "리뷰입니다.",
                attachedPhotoIds = arrayListOf("0f2a7184-b4fd-420e-8c3c-4dd2b6ab27e4"),
//                attachedPhotoIds = null,
                userId = "40bab014-dbae-4c66-81ef-eca097ea7cdf",
                placeId = "27d9c649-5969-413e-8a57-03f933486089"
            )
        )
    }
}