package com.arete.software.springcloudfeigndemo.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@FeignClient("demoservice")
public interface DemoServiceApi {

    @RequestMapping(method = GET, value = "/customer")
    String getCustomer();
}
