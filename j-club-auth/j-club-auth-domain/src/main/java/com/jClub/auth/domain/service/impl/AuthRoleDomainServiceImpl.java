package com.jClub.auth.domain.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import com.jClub.auth.common.enums.AuthUserStatusEnum;
import com.jClub.auth.common.enums.IsDeletedFlagEnum;
import com.jClub.auth.domain.convert.AuthRoleBOConverter;
import com.jClub.auth.domain.convert.AuthUserBOConverter;
import com.jClub.auth.domain.entity.AuthRoleBO;
import com.jClub.auth.domain.entity.AuthUserBO;
import com.jClub.auth.domain.service.AuthRoleDomainService;
import com.jClub.auth.domain.service.AuthUserDomainService;
import com.jClub.auth.infra.basic.entity.AuthRole;
import com.jClub.auth.infra.basic.entity.AuthUser;
import com.jClub.auth.infra.basic.service.AuthRoleService;
import com.jClub.auth.infra.basic.service.AuthUserService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class AuthRoleDomainServiceImpl implements AuthRoleDomainService {

    @Resource
    private AuthRoleService authRoleService;

    @Override
    public Boolean add(AuthRoleBO authRoleBO) {
        AuthRole authRole = AuthRoleBOConverter.INSTANCE.convertBOToEntity(authRoleBO);
        authRole.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        Integer count = authRoleService.insert(authRole);
        return count > 0;
    }

    @Override
    public Boolean update(AuthRoleBO authRoleBO) {
        AuthRole authRole = AuthRoleBOConverter.INSTANCE.convertBOToEntity(authRoleBO);
        Integer count = authRoleService.update(authRole);
        return count > 0;
    }

    @Override
    public Boolean delete(AuthRoleBO authRoleBO) {
        AuthRole authRole = new AuthRole();
        authRole.setId(authRoleBO.getId());
        authRole.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
        Integer count = authRoleService.update(authRole);
        return count > 0;
    }

}
