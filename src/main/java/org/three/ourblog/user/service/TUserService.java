package org.three.ourblog.user.service;

import org.three.ourblog.user.pojo.TUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shuize
 * @since 2020-06-17
 */
public interface TUserService extends IService<TUser> {

    boolean verifyUser(TUser user);
}
