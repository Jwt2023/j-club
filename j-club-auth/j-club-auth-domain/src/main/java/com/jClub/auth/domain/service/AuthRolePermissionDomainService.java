package com.jClub.auth.domain.service;

import com.jClub.auth.domain.entity.AuthPermissionBO;
import com.jClub.auth.domain.entity.AuthRolePermissionBO;

/**
 * 角色领域service
 * 
 * @author: ChickenWing
 * @date: 2023/11/1
 */
public interface AuthRolePermissionDomainService {

    Boolean add(AuthRolePermissionBO authRolePermissionBO);

}
