package org.sid.ebankingbackend.entities;

import javax.persistence.*;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*import java.util.List;
import org.sid.ebankingbackend.enums.LoanStatus;
import org.sid.ebankingbackend.enums.OperationType;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonProperty;*/

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class LoanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loan_id;

    @ManyToOne
    private Customer customer;
    @ManyToOne
    private BankAccount account;
    private double loan_amt;
    private Date startDate;
    private Date endDate;
    @ManyToOne
    private LoanPlan loanPlan;
    @ManyToOne
    private LoanType loanType;
    private double pending_amt;
    
    private String status;

    // getters and setters
}