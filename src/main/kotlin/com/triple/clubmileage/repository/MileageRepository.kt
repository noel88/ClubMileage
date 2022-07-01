package com.triple.clubmileage.repository

import com.triple.clubmileage.domain.Mileage
import org.springframework.data.jpa.repository.JpaRepository

interface MileageRepository: JpaRepository<Mileage, String>, MileageRepositorySupport