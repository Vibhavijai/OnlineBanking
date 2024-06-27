package org.sid.ebankingbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;


import javax.persistence.*;



@Data
public class LoanPlanDTO {
    private Long plan_id;
    private Integer months;
    private Float interest_rate;
    private Float penalty_rate;
}

