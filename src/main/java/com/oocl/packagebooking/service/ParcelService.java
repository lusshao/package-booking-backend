package com.oocl.packagebooking.service;

import com.oocl.packagebooking.model.Parcel;
import com.oocl.packagebooking.repository.ParcelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParcelService {

    @Autowired
    ParcelRepository parcelRepository;

    public List<Parcel> findAll() {
        return parcelRepository.findAll();
    }

    public List<Parcel> getParcelByParcelStatus(int status) {
        return parcelRepository.findAllByParcelStatus(status);
    }
}
