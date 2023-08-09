package com.fnservices.service;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "pricingConfiguration")

public class pricingConfiguration {

//    configurationID: -1,
//    configType: 1,
//    configTypeName: "DAP",
//    priceForConfiguration: 1,
//    rateForConfiguration: 1,
//    configurationForKM: 1.0,
//    configurationForTime: 1.0,
//    dayOfTheWeek: 1,
//    configEnabled: true



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "configurationID")
    private  Integer configurationID;

    @Column(name = "configType")
    private  Integer configType;

    //Possible value 1-DBP, 2 -DAP, 3 -TMF, 4 - WC
    @Column(name = "configTypeName")
    private  String configTypeName;

    @Column(name = "priceForConfiguration")
    private  double priceForConfiguration;

    @Column(name = "rateForConfiguration")
    private  double rateForConfiguration;

    @Column(name = "configurationForKM")
    private double configurationForKM;

    @Column(name = "configurationForTime")
    private double configurationForTime;

    @Column(name = "dayOfTheWeek")
    private Integer dayOfTheWeek;

    @Column(name = "configEnabled")
    private Boolean  configEnabled;
}
