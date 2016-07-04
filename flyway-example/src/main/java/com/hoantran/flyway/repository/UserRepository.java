package com.hoantran.flyway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hoantran.flyway.entity.UserEntity;

/**
 * The ProgramNewRepository.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
