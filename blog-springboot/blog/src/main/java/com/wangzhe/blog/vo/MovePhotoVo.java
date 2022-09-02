package com.wangzhe.blog.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.context.annotation.Primary;

import java.util.List;

/**
 * @author WangZhe
 * @version 1.0
 * @className MovePhotoVo
 * @description 后台移动照片入参实体
 * @date 2022/8/31 11:04
 */

@Data
@ApiModel("后台移动照片入参实体")
public class MovePhotoVo {

    private List<Integer> photoIdList;

    private Integer albumId;

}
