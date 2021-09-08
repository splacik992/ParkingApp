package com.envelo.ParkingApp.repository;

import com.envelo.ParkingApp.model.entity.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ParkingRepository extends JpaRepository<Parking, Long> {

    @Query(value = "SELECT * FROM parking where id =:parkingId", nativeQuery = true)
    Parking findParkingById(@Param("parkingId") long id);

}
