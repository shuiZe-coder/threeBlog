package org.three.ourblog.type.service;

import org.three.ourblog.type.pojo.TType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shuize
 * @since 2020-06-18
 */
public interface TTypeService extends IService<TType> {

    List<TType> getByLimit(long current, long limit);
}
