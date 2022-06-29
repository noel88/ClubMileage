package com.triple.clubmileage.repository

import com.triple.clubmileage.domain.ReviewEvent

interface ReviewEventRepositorySupport {

    fun findByCurrentModifiedReviewEvent(userId: String, placeId: String) : ReviewEvent?
    fun findByReviewIdOrderByModifiedDateDesc(reviewId: String) : ReviewEvent?
}