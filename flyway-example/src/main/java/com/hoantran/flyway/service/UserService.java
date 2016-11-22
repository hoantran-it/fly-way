/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.hoantran.flyway.service;

import java.util.List;

import com.hoantran.flyway.entity.UserEntity;

/**
 * User service.
 * 
 * @author hoan.tran
 */
public interface UserService {

    /**
     * Gets the all user.
     *
     * @return the all user
     */
    List<UserEntity> getAllUser();

}
