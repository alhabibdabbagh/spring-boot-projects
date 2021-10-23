package project7.security7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project7.security7.entity.Wallet;
import project7.security7.enumuration.Currency;

/**
 * @author Habib
 * @on 10/17/21 - 11:39 AM
 */
@Repository
public interface WalletRepository extends JpaRepository<Wallet,Long> {

    @Query("select case when  count(w) > 0 then true else false end from Wallet w where w.currency=?1 and w.customer.id=?2")
     boolean isExitCurrencyForSameCustomer(Currency currency, long id);
}
