package com.oocl.packagebooking.repository;

import com.oocl.packagebooking.model.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParcelRepository extends JpaRepository<Parcel, Integer> {

    List<Parcel> findAllByParcelStatus(int status);
}
