package com.consertreservation;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@ActiveProfiles("test")
@SpringBootTest(classes = ConcertReservationApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Sql({"/sql/schema.sql"})
public class TestConfig {
}
