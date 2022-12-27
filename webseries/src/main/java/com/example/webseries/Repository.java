
package com.example.webseries;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Repository extends JpaRepository<Webentity, String>{

    @Query(value = "SELECT * FROM webseries", nativeQuery = true)
    List<Webentity> display(String Id);

    @Query(value = "SELECT * FROM webseries WHERE Id=?1", nativeQuery = true)
    List<Webentity> GetById(String Id);

    @Query(value = "DELETE * FROM webseries WHERE Id=?1", nativeQuery = true)
    List<Webentity> DelById(String Id);

    @Query(value = "UPDATE * FROM webseries WHERE Id=?1", nativeQuery = true)
    List<Webentity> Update(String Id);
}