package org.sid.ebankingbackend.dtos;
import lombok.Data;
/* 
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;


import javax.persistence.*;

*/

@Data
public class LoanTypeDTO {
    private Long type_id;

    private String loan_type;
    private String descr;
}

