package com.wangzhe.blog.service.Impl;

import com.wangzhe.blog.entity.Article;
import com.wangzhe.blog.mapper.ArticleMapper;
import com.wangzhe.blog.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客文章 服务实现类
 * </p>
 *
 * @author WZ
 * @since 2022-52-03
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

}
