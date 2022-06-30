package com.triple.clubmileage.repository

import com.triple.clubmileage.domain.ReviewEvent
import org.springframework.data.jpa.repository.JpaRepository

interface ReviewEventRepository: JpaRepository<ReviewEvent, String>, ReviewEventRepositorySupport