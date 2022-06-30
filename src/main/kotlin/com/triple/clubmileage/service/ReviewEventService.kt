package com.triple.clubmileage.service

import com.triple.clubmileage.domain.Action
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
            type = eventDto.type,
            action = eventDto.action,
            content = eventDto.content,
            attackedImages = eventDto.attachedPhotoIds,
            userId = eventDto.userId,
            placeId = eventDto.placeId,

        )
        reviewEventRepository.save(reviewEvent)
    }

    fun findByReviewId(reviewId: String): ReviewEvent? {
        return reviewEventRepository.findByReviewIdOrderByModifiedDateDesc(reviewId)
    }

    fun findByCurrentModifiedReviewEvent(userId: String, placeId: String): ReviewEvent? {
        return reviewEventRepository.findByCurrentModifiedReviewEvent(userId, placeId)
    }

    fun isFirstPlaceReview(placeId: String) : Boolean {
        val actionMap = reviewEventRepository.isFirstPlaceReview(placeId)
        if (actionMap[Action.ADD] == actionMap[Action.DELETE].also { (it ?: 0) + 1 }) {
            return true
        }
        return false
    }
}