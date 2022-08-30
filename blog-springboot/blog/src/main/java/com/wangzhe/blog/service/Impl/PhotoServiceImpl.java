package com.wangzhe.blog.service.Impl;

import com.wangzhe.blog.entity.Photo;
import com.wangzhe.blog.mapper.PhotoMapper;
import com.wangzhe.blog.service.PhotoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wz
 * @since 2022-27-30
 */
@Service
public class PhotoServiceImpl extends ServiceImpl<PhotoMapper, Photo> implements PhotoService {

}
