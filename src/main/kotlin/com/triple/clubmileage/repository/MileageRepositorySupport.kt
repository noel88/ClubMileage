package com.triple.clubmileage.repository

interface MileageRepositorySupport {

    fun findByTotalUserMileage(userId: String) : Int?
    fun findByPlaceUserMileage(userId: String, placeId: String) : Int?
}