package com.consertreservation.domain.concert.infra;

import com.consertreservation.domain.concert.model.Concert;
import com.consertreservation.domain.concert.repository.ConcertStoreRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcertJPARepository extends JpaRepository<Concert, Long>, ConcertStoreRepository {
}
