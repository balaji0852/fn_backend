package com.fnservices.service;


import com.fnservices.service.service.pricingConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class invoiceGenerator {


    @Autowired
    public pricingConfigService pricingConfigService;

    @GetMapping(path = "api/v1/invoice/PriceCalculator")
    public Double billCalculator(@RequestParam double kms,
                                 @RequestParam double hours,
                                 @RequestParam Integer dayOfWeek,
                                 @RequestParam double WeightingHours){
        System.out.println("_______________________________________________");
        double DBP,DAP,WC,TMF;
        DAP = pricingConfigService.getDAP(kms);
        DBP = pricingConfigService.getDBP(kms,dayOfWeek);
        WC = pricingConfigService.getWC(WeightingHours);
        TMF = pricingConfigService.getTMF(hours);
        System.out.println("DBP charges : "+DBP);
        System.out.println("DAP charges : "+DAP);
        System.out.println("TMF charges : "+TMF);
        System.out.println("WC charges : "+WC);
//        $Price = (DBP + (Dn * DAP)) + (Tn * TMF) + WC$)
        double price = DBP+DAP+(hours*TMF)+WC;
        return DBP==0?0:price;
    }
}
