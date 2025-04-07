package org.mrstm.uberreviewservice.repositories;

import org.mrstm.uberreviewservice.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Long> {

    Optional<Driver> findByLicenseNumber(String licenseNumber);

    @Query(nativeQuery = true , value = "SELECT * FROM Driver where id = :id AND license_number = :licenseNumber")
    //for large number of tables creating various methods is not recommended.
    //hence raw queries or hibernate queries are preffered.
    Optional<Driver> rawFindByIdAndLicenseNumber(Long id, String licenseNumber);


    @Query("SELECT d from Driver as d where d.id = :id AND d.licenseNumber = :ln") //this is hibernate query if we dont provide nativequery then it becomes hibernate one
    //  we dont need to provide exact column names in hibernate query , which is required in raw query.
    Optional<Driver> hqlFindByIdAndLicense(Long id, String ln);

}
