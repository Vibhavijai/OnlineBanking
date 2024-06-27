package org.sid.ebankingbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.sid.ebankingbackend.entities.BankAccount;
import org.sid.ebankingbackend.dtos.LoanEntityDTO;
import org.sid.ebankingbackend.enums.OperationType;

import javax.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Data
public class PaymentDTO {
    private Long pay_id;
    private LoanEntityDTO loanDTO;
    private BigDecimal paid_amt;
    private BigDecimal overdue_amt;
    private Date pay_date;
}

