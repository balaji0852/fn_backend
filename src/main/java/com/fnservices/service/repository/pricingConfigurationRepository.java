package com.fnservices.service.repository;

import com.fnservices.service.pricingConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface pricingConfigurationRepository extends JpaRepository<pricingConfiguration,Integer> {



    @Query(nativeQuery = true,value = "" +
            "SELECT *\n" +
            "\t FROM public.pricing_configuration\n" +
            "\t WHERE configuration_forkm <= ?1 \n" +
            "\t AND day_of_the_week = ?2 \n" +
            "\t AND config_type=1 \n" +
            "\t AND config_enabled=true \n" +
            "\t ORDER BY configuration_forkm DESC\n" +
            "\t LIMIT 1")
    Optional<pricingConfiguration> getDBP(double configurationForKM, Integer dayOfTheWeek);

    @Query(nativeQuery = true,value = "" +
            "SELECT *\n" +
            "\t FROM public.pricing_configuration\n" +
            "\t WHERE configuration_forkm <= ?1 \n" +
            "\t AND config_type=2 \n" +
            "\t AND config_enabled=true \n" +
            "\t ORDER BY configuration_forkm ASC\n" +
            "\t LIMIT 1")
    Optional<pricingConfiguration> getDAP(double configurationForKM);


    @Query(nativeQuery = true,value =
            "SELECT *\n" +
            "\t FROM public.pricing_configuration\n" +
            "\t WHERE configuration_for_time <= ?1 \n" +
            "\t AND config_type=3 \n" +
            "\t AND config_enabled=true \n" +
            "\t ORDER BY configuration_forkm DESC\n" +
            "\t LIMIT 1")
    Optional<pricingConfiguration> getTMF(double configurationForTime);


    @Query(nativeQuery = true,value = "" +
            "SELECT *\n" +
            "\t FROM public.pricing_configuration\n" +
            "\t WHERE configuration_for_time <= ?1 \n" +
            "\t AND config_type=4 \n" +
            "\t AND config_enabled=true \n" +
            "\t ORDER BY configuration_forkm ASC\n" +
            "\t LIMIT 1")
    Optional<pricingConfiguration> getWC(double weightingHours);

}
