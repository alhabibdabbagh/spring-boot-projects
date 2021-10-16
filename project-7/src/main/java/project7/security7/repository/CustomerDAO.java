package project7.security7.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project7.security7.entity.Customer;
@Repository
public interface CustomerDAO extends CrudRepository<Customer,Long> {

    @Query("select case when count (c)> 0 then true else false end from Customer c where c.ssid =?1 ")
    //c.ssid = :ssid
    public boolean isExitSsid(long ssid);
   // public boolean isExitSsid(@Param("ssid1") long ssid);
    //public
}
