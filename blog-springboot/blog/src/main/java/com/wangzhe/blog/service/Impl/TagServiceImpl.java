package com.wangzhe.blog.service.Impl;

import com.wangzhe.blog.entity.Tag;
import com.wangzhe.blog.mapper.TagMapper;
import com.wangzhe.blog.service.TagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 标签表 服务实现类
 * </p>
 *
 * @author wz
 * @since 2022-40-08
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

}
