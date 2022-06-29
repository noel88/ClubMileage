package com.triple.clubmileage.service

import com.triple.clubmileage.domain.ReviewEvent
import com.triple.clubmileage.repository.ReviewEventRepository
import com.triple.clubmileage.service.dto.EventDto
import org.springframework.stereotype.Service

@Service
class ReviewEventService(
    private val reviewEventRepository: ReviewEventRepository
) {

    fun setEvent(eventDto: EventDto) {
        val reviewEvent = ReviewEvent(
            reviewId = eventDto.reviewId,
            content = eventDto.content,
            attackedImages = eventDto.attachedPhotoIds,
            userId = eventDto.userId,
            placeId = eventDto.placeId,
        )
        reviewEventRepository.save(reviewEvent)
    }

    fun findById(id: String): ReviewEvent? {
        return reviewEventRepository.findById(id).orElse(null)
    }

    fun countByPlaceId(placeId: String) : Int {
        return reviewEventRepository.countByPlaceId(placeId)
    }

}