package org.sid.ebankingbackend.repositories;
import java.util.Date;
import java.util.List;

import org.sid.ebankingbackend.entities.Customer;
import org.sid.ebankingbackend.entities.LoanEntity;
import org.sid.ebankingbackend.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    /* 
    @Query("select l from LoanEntity l where l.customer_id like :kw")
    List<LoanEntity> findByCustomerId(@Param("kw") Long customerId);*/
    @Query("SELECT p FROM Payment p WHERE ((p.paid_amt >= :min_amount AND p.paid_amt<= :max_amount) ) AND ( (p.pay_date BETWEEN :start_date AND :end_date) ) AND (:loan_id IS NULL OR p.loan.loan_id = :loan_id)")
    List<Payment> findByAttributes(
            @Param("min_amount") Double min_amount,
            @Param("max_amount") Double max_amount,
            @Param("start_date") Date start_date,
            @Param("end_date") Date end_date,
            @Param("loan_id") Long loan_id);

   /*  @Query("SELECT p FROM Payment p JOIN p.loan l WHERE l.customer.id = :customer_id")
    List<Payment> findByCustomerId(@Param("customer_id") Long customer_id);*/
}