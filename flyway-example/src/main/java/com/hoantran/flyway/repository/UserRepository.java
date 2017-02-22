/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.hoantran.flyway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hoantran.flyway.entity.UserEntity;

/**
 * User repository.
 * 
 * @author hoan.tran
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
