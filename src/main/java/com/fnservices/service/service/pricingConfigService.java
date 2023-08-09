package com.fnservices.service.service;


import com.fnservices.service.pricingConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fnservices.service.repository.pricingConfigurationRepository;

import java.util.List;
import java.util.Optional;


@Service
public class pricingConfigService {



    private final pricingConfigurationRepository pricingConfigRepository;


    @Autowired
    public pricingConfigService(pricingConfigurationRepository pricingConfigRepository) {
        this.pricingConfigRepository = pricingConfigRepository;
    }


    public List<pricingConfiguration> getAllConfig(){
        return pricingConfigRepository.findAll();
    }

    public Boolean delete(Integer configurationID){
        try{
            pricingConfigRepository.deleteById(configurationID);
        }catch (Exception e){
            return false;
        }

        return true;
    }

    public Boolean save(pricingConfiguration pricingConfiguration){
        try{
            pricingConfigRepository.save(pricingConfiguration);
        }catch (Exception e){
            return false;
        }

        return true;
    }


    public double getDBP(double kms, Integer dayOfTheWeek){
        Optional<pricingConfiguration> config = pricingConfigRepository.getDBP(kms,dayOfTheWeek);

        return config.isEmpty()?0:config.get().getPriceForConfiguration();
    }


    public double getDAP(double kms){
        Optional<pricingConfiguration> config = pricingConfigRepository.getDAP(kms);
        System.out.println(config.isEmpty()?"no DAPs":"DAP :"+config.get().getPriceForConfiguration());

        return config.isEmpty()?0:(kms-config.get().getConfigurationForKM())*config.get().getPriceForConfiguration();
    }

    public double getTMF(double rideDuration){
        Optional<pricingConfiguration> config = pricingConfigRepository.getTMF(rideDuration);
        System.out.println(config.isEmpty()?"no TMFs":"TMF :"+config.get().getRateForConfiguration());
        return config.isEmpty()?0:config.get().getRateForConfiguration();
    }
    public double getWC(double waitDuration){
        Optional<pricingConfiguration> config = pricingConfigRepository.getWC(waitDuration);
        System.out.println(config.isEmpty()?"no WCs":"WC :"+config.get().getPriceForConfiguration());
        return config.isEmpty()?0:(waitDuration-config.get().getConfigurationForTime())*config.get().getPriceForConfiguration();
    }
}
