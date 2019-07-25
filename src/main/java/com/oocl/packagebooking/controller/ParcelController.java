package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.model.Parcel;
import com.oocl.packagebooking.service.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParcelController {

    @Autowired
    ParcelService parcelService;

    @GetMapping("/parcel")
    public List<Parcel> getAllParcel() {
        return parcelService.findAll();
    }

    @GetMapping(path = "/parcel",params = "status")
    public List<Parcel> getParcelByParcelStatus(@RequestParam int status){
        return parcelService.getParcelByParcelStatus(status);
    }
}
