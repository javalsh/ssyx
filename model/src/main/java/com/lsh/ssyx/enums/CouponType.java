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
@Getter
public enum CouponType {
    FULL_REDUCTION(1,"满减"),
    CASH(2,"现金卷");

    @EnumValue
    private Integer code;
    private String comment ;

    CouponType(Integer code, String comment ){
        this.code=code;
        this.comment=comment;
    }
}