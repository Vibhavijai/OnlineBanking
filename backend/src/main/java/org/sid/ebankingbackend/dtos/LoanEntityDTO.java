package org.sid.ebankingbackend.dtos;

import org.sid.ebankingbackend.enums.LoanStatus;

import java.math.BigDecimal;
import lombok.Data;
/* 
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.sid.ebankingbackend.entities.BankAccount;
import org.sid.ebankingbackend.entities.Customer;
import org.sid.ebankingbackend.dtos.LoanPlanDTO;
import org.sid.ebankingbackend.dtos.LoanTypeDTO;
import org.sid.ebankingbackend.dtos.CustomerDTO;
import lombok.AllArgsConstructor;

import org.sid.ebankingbackend.enums.OperationType;

import javax.persistence.*;

*/
import java.util.Date;

@Data
public class LoanEntityDTO {
    private Long loan_id;
    private CustomerDTO customerDTO;
    private BigDecimal loan_amt;
    private Date startDate;
    private Date endDate;
    private LoanPlanDTO loanPlanDTO;
    private LoanTypeDTO loanTypeDTO;
    private BigDecimal pending_amt;
    private LoanStatus status;

}

