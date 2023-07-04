package com.lsh.ssyx.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @author shaohua.liu
 * Create at 2023/7/4
 */
@Getter
public enum SkuType {
    COMMON(0,"普通"),
    SECKILL(1,"秒杀" );

    @EnumValue
    private Integer code ;
    private String comment ;

    SkuType(Integer code, String comment ){
        this.code=code;
        this.comment=comment;
    }
}