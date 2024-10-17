package com.consertreservation.domain.usertoken.infra;

import com.consertreservation.domain.usertoken.model.UserToken;
import com.consertreservation.domain.usertoken.respositories.UserTokenStoreRepository;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface UserTokenJPARepository extends JpaRepository<UserToken, UUID>, UserTokenStoreRepository {

}
