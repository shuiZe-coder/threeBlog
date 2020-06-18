package org.three.ourblog.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.three.ourblog.uitls.MD5Util;
import org.three.ourblog.user.pojo.TUser;
import org.three.ourblog.user.mapper.TUserMapper;
import org.three.ourblog.user.service.TUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shuize
 * @since 2020-06-17
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {
    @Override
    public boolean verifyUser(TUser user) {
        QueryWrapper<TUser> wrapper = new QueryWrapper<>();
        wrapper.eq("username", user.getUsername());
        wrapper.eq("password", MD5Util.encrypt(user.getPassword()));
        TUser one = this.getOne(wrapper);
        if (one != null){
            return true;
        }
        return false;
    }
}
