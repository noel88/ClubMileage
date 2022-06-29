package com.triple.clubmileage.controller

import com.triple.clubmileage.service.ReviewEventService
import com.triple.clubmileage.service.dto.EventDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class EventController(
    private val reviewEventService: ReviewEventService
) {

    @PostMapping("/event")
    fun reviewEvent(@RequestBody eventDto: EventDto): ResponseEntity<String> {
        reviewEventService.setEvent(eventDto)
        return ResponseEntity("Event", HttpStatus.OK)
    }

}