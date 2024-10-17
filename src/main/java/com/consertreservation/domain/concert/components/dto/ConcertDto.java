package com.consertreservation.domain.concert.components.dto;

import com.consertreservation.domain.concert.model.Concert;

public record ConcertDto(
        Long id,
        String title
) {

    public static ConcertDto from(Concert concert) {
        return new ConcertDto(concert.getId(), concert.getTitle());
    }
}
