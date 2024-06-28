package org.sid.ebankingbackend.repositories;
import java.util.Date;
import java.util.List;

import org.sid.ebankingbackend.entities.Customer;
import org.sid.ebankingbackend.entities.LoanPlan;
import org.sid.ebankingbackend.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;


@Repository
public interface LoanPlanRepository extends JpaRepository<LoanPlan, Long> {

    /*@Query("select c from Customer c where c.name like :kw")
    List<Customer> searchCustomer(@Param("kw") String keyword);*/
    
/* 
    @Query("select l from LoanEntity l where l.customer.id like :kw")
    List<LoanEntity> findByCustomerId(@Param("kw") Long customerId);

    @Query("SELECT l FROM LoanEntity l WHERE (:loan_id IS NULL OR l.loan_id=:loan_id) AND (:plan_id IS NULL OR l.loanPlan.plan_id=:plan_id ) AND (:type_id IS NULL OR (l.loanType.type_id=:type_id) ) AND (:status IS NULL OR l.status = :status) AND ((l.loan_amt <= :max_amount AND l.loan_amt >= :min_amount ))")
    List<LoanEntity> findByAttributes(
            @Param("loan_id") Long loan_id,
            @Param("plan_id") Long plan_id,
            @Param("type_id") Long type_id,
            @Param("status") LoanStatus status,
            @Param("min_amount") Double min_amount,
            @Param("max_amount") Double max_amount
            );
*/
}