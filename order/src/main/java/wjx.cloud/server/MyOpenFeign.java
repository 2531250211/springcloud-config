package wjx.cloud.server;

import entity.PaymentCommon;
import entity.PaymentEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import self_defineRibbon.MyRibbon;
import wjx.cloud.server.impl.MyOpenFeignImpl;


@FeignClient(value = "payment",configuration = MyRibbon.class)
public interface MyOpenFeign {
    @GetMapping("/payment/query/{id}")
    public PaymentCommon<PaymentEntity> query(@PathVariable("id") Long id);
    @GetMapping("/payment/fallBack2")
    public String fall2();
    @GetMapping("/payment/fallBack1")
    public String fall1();
}
