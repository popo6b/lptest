package com.itxs.consumer.fegin.fallback;

import com.itxs.common.utils.R;
import com.itxs.consumer.fegin.ClassFeign;

/**
 * @author it小帅
 * @version 1.0
 * @datetime 2021/3/16 16:33
 */
public class ClassFeginFallBack implements ClassFeign {
    @Override
    public R getClassAllTeacher(String classId) {
        return R.error("熔断保护");
    }
}
