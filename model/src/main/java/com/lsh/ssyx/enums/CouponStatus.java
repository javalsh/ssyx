package com.lsh.ssyx.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @author shaohua.liu
 * Create at 2023/7/4
 */

/**
 * @author shaohua.liu
 * Create at 2023/7/4
 */
public enum CouponStatus {
    NOT_USED(1,"未使用"),
    USED(2,"已使用");

    @EnumValue
    private Integer code ;
    private String comment ;

    CouponStatus(Integer code, String comment ){
        this.code=code;
        this.comment=comment;
    }
}