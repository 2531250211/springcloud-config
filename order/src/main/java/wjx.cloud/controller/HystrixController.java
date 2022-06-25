package wjx.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import wjx.cloud.server.MyOpenFeign;

import javax.annotation.Resource;

@RestController
@DefaultProperties(defaultFallback = "save2")
public class HystrixController {
    @Resource
    private MyOpenFeign myOpenFeign;
    @GetMapping("/hystrix1")
    public String success(){
        return myOpenFeign.fall1();
    }
    @GetMapping("/hystrix2")
    @HystrixCommand/*(fallbackMethod = "save",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "500")
    })*/
    public String fail(){
        return myOpenFeign.fall2();
    }
    @GetMapping("/hystrix3")
    public String fail1(){
        return myOpenFeign.fall2();
    }
    public String save(){
        return "当前业务繁忙请稍后再试！！！！！";
    }
    public String save2(){
        return "当前业务繁忙请稍后再试???";
    }
}
