package com.oocl.packagebooking.service;

import com.oocl.packagebooking.model.Parcel;
import com.oocl.packagebooking.repository.ParcelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Date;
import java.util.Optional;

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

    public Parcel addNewParcel(Parcel parcel) {
        parcel.setOrderTime(new Timestamp(new Date().getTime()));
        parcel.setParcelStatus(1);
        return parcelRepository.save(parcel);
    }

    public Parcel updateParcel(String parcelNumber, int status) {
        Parcel parcel = parcelRepository.findByParcelNumber(parcelNumber);
        parcel.setParcelStatus(status);
        return parcelRepository.save(parcel);
    }
}
