package com.fnservices.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class pricingConfigController {

    @Autowired
    private com.fnservices.service.service.pricingConfigService pricingConfigService;

    @GetMapping(path = "/hello")
    public String getData(){


        return "hello";
    }


    @GetMapping(path = "/api/V1/PricingConfiguration")
    public List<pricingConfiguration> getAllConfig(){


        return pricingConfigService.getAllConfig();
    }

    @PostMapping(path = "api/v1/add/PricingConfiguration")
    public ResponseEntity<String> saveOrUpdate(@RequestBody pricingConfiguration pricingConfiguration){
        return pricingConfigService.save(pricingConfiguration)?ResponseEntity.ok("success"):ResponseEntity.badRequest().body("failed");
    }

    @DeleteMapping(path = "api/v1/delete/PricingConfiguration")
    public ResponseEntity<String> saveOrUpdate(@RequestParam Integer configurationID){
        return pricingConfigService.delete(configurationID)?ResponseEntity.ok("success"):ResponseEntity.badRequest().body("failed");
    }
}
