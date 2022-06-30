package com.triple.clubmileage.repository

import com.querydsl.core.types.Order
import com.querydsl.core.types.OrderSpecifier
import com.querydsl.jpa.impl.JPAQueryFactory
import com.triple.clubmileage.domain.Action
import com.triple.clubmileage.domain.QReviewEvent.reviewEvent
import com.triple.clubmileage.domain.ReviewEvent

class ReviewEventRepositorySupportImpl (
    private val query: JPAQueryFactory,
) : CustomQuerydslRepositorySupport(ReviewEvent::class.java), ReviewEventRepositorySupport {
    override fun findByCurrentModifiedReviewEvent(userId: String, placeId: String): ReviewEvent? {
        val currentModifiedReviewEvent = query
            .selectFrom(reviewEvent)
            .where(
                reviewEvent.userId.eq(userId),
                reviewEvent.placeId.eq(placeId)
            )
            .orderBy(OrderSpecifier(Order.DESC, reviewEvent.modifiedDate))
            .fetch()

        if (currentModifiedReviewEvent.size > 1) {
            return currentModifiedReviewEvent[1]
        }

        return null
    }

    override fun findByReviewIdOrderByModifiedDateDesc(reviewId: String): ReviewEvent? {
        return query
            .selectFrom(reviewEvent)
            .where(reviewEvent.reviewId.eq(reviewId))
            .orderBy(OrderSpecifier(Order.DESC, reviewEvent.modifiedDate))
            .fetchFirst()
    }

    override fun isFirstPlaceReview(placeId: String): Boolean {
        val events = query
            .selectFrom(reviewEvent)
            .where(reviewEvent.placeId.eq(placeId))
            .fetch()

        if (events.count { it.action == Action.ADD } == events.count { it.action == Action.DELETE } + 1) {
            return true
        }

        return false
    }

}