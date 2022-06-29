package com.triple.clubmileage.controller

import com.triple.clubmileage.service.MileageService
import com.triple.clubmileage.service.dto.EventDto
import com.triple.clubmileage.service.dto.MileageDto
import com.triple.clubmileage.service.dto.MileageEventDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class MileageController(
    private val mileageService: MileageService
) {

    @GetMapping("/mileage/{userId}")
    fun getMileage(@PathVariable userId: String): ResponseEntity<MileageDto> {
        mileageService.getTotalMileage(userId)

        return ResponseEntity(mileageService.getTotalMileage(userId), HttpStatus.OK)
    }

    @PostMapping("/events/mileage")
    fun setMileage(@RequestBody mileageEventDto: MileageEventDto): ResponseEntity<String> {
        mileageService.event(mileageEventDto)
        return ResponseEntity("Event", HttpStatus.OK)
    }

}