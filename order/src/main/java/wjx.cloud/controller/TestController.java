package wjx.cloud.controller;

import entity.OrderEntity;
import entity.PaymentCommon;
import entity.PaymentEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.client.RestTemplate;
import wjx.cloud.mapper.OrderDao;
import wjx.cloud.server.MyOpenFeign;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {
    public static final String URL="http://localhost:9092/";
    @Resource
    private OrderDao orderDao;
    @Resource
    private MyOpenFeign myOpenFeign;
    @Resource
    private RestTemplate restTemplate;
    @GetMapping("/order1/{id}")
    public PaymentCommon queryOrder(@PathVariable("id") Long id){

        return restTemplate.getForObject("http://payment/payment/query/"+id, PaymentCommon.class);
    }
    @GetMapping("/order2/{serial}")
    public PaymentCommon addOrder(@PathVariable("serial") String str){

        return restTemplate.getForObject("http://payment/payment/add/"+str, PaymentCommon.class);
    }
    @GetMapping("/order3/{id}")
    public PaymentCommon queryOrder2(@PathVariable("id") Long id){

        return myOpenFeign.query(id);
    }

}
