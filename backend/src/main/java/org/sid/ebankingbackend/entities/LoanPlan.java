package org.sid.ebankingbackend.entities;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class LoanPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long plan_id;

    private Integer months;
    private Float interest_rate;
    private Float penalty_rate;
    @OneToMany(mappedBy = "loanPlan",fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<LoanEntity> loanEntities;
    

    // getters and setters
}