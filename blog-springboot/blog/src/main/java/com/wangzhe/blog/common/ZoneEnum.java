package com.wangzhe.blog.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author WangZhe
 * @version 1.0
 * @className ZoneEnum
 * @description
 * @date 2022/8/4 17:38
 */

@Getter
@AllArgsConstructor
public enum ZoneEnum {

    /**
     * 上海
     */
    SHANGHAI("Asia/Shanghai", "中国上海");

    /**
     * 时区
     */
    private final String zone;

    /**
     * 描述
     */
    private final String desc;

}
