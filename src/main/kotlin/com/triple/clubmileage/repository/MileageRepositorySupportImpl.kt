package com.triple.clubmileage.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import com.triple.clubmileage.domain.Mileage
import com.triple.clubmileage.domain.QMileage.mileage

class MileageRepositorySupportImpl (
    private val query: JPAQueryFactory,
) : CustomQuerydslRepositorySupport(Mileage::class.java), MileageRepositorySupport {
    override fun findByTotalUserMileage(userId: String): Int? {
        return query
            .from(mileage)
            .where(mileage.userId.eq(userId))
            .select(
                mileage.point.sum()
            )
            .groupBy(mileage.userId)
            .fetchOne()
    }

    override fun findByPlaceUserMileage(userId: String, placeId: String): Int? {
        return query
            .from(mileage)
            .where(
                mileage.userId.eq(userId),
                mileage.placeId.eq(placeId)
            )
            .groupBy(mileage.placeId)
            .select(
                mileage.point.sum()
            )
            .fetchOne()
    }

}