package com.itxs.consumer.fegin;

import com.itxs.common.utils.R;
import com.itxs.consumer.fegin.fallback.ClassFeginFallBack;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author it小帅
 * @version 1.0
 * @datetime 2021/3/16 16:30
 */
@FeignClient(value = "service-lpterm", fallback= ClassFeginFallBack.class)
public interface ClassFeign {

    @GetMapping(value = "product/class/get-teachers/{classId}")
    R getClassAllTeacher(@PathVariable("classId") String classId);
}
