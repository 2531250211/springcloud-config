package wjx.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import entity.PaymentCommon;
import entity.PaymentEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import wjx.cloud.mapper.PaymentDao;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController

public class PaymentController {
    @Value("${server.port}")
    private String str;
    @Resource
    private PaymentDao paymentDao;

    /* @GetMapping("/payment/{serial}")
     public String add(@PathVariable("serial") String serial){
         PaymentEntity paymentEntity = new PaymentEntity();
         paymentEntity.setSerial(serial);
         paymentDao.addMsg(paymentEntity);
         return "添加成功";
     }*/
    @GetMapping("/payment/add/{serial}")
    public PaymentCommon add(@ModelAttribute("serial") PaymentEntity paymentEntity) {

        int i = paymentDao.addMsg(paymentEntity);
        if (i > 0) {
            return new PaymentCommon<>(200, "添加成功", i);
        } else {
            return new PaymentCommon<>(444, "添加失败", null);
        }
    }

    @GetMapping("/payment/query/{id}")
    public PaymentCommon<PaymentEntity> query(@PathVariable("id") Long id) {
        System.out.println("111");
        PaymentEntity paymentEntity = paymentDao.queryById(id);
        if (paymentEntity != null) {
            return new PaymentCommon<PaymentEntity>(200, "查询成功--" + str, paymentEntity);
        } else {
            return new PaymentCommon<PaymentEntity>(444, "查询结果为空--" + str, null);
        }
    }

    @GetMapping("/payment/fallBack1")
    public String fall1() {
        return "访问成功";
    }

    @GetMapping("/payment/fallBack2")
    /*@HystrixCommand(fallbackMethod = "save",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value ="700")
    })*/
    public String fall2() throws InterruptedException {
        int a=10/0;
        //TimeUnit.MILLISECONDS.sleep(1000);
        return "访问超时";
    }

    public String save(){
        return "当前业务繁忙请稍后再试！！！！！";
    }

}
