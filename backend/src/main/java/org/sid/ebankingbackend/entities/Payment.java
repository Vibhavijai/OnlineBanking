package org.sid.ebankingbackend.entities;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.Date;
import  org.sid.ebankingbackend.entities.LoanEntity;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pay_id;

    @ManyToOne
    @JoinColumn(name = "loan_id")
    private LoanEntity loan;
    private BigDecimal paid_amt;
    private BigDecimal overdue_amt;//penalty amount for overdue;
    private Date pay_date;
    private String pay_status;

    // getters and setters
}