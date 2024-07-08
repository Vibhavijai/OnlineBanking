package org.sid.ebankingbackend.dtos;


import lombok.Data;
/*import lombok.NoArgsConstructor;
import org.sid.ebankingbackend.entities.BankAccount;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import javax.persistence.*;
import java.util.List;*/

@Data
public class CustomerDTO {
    private Long id;
    private String name;
    private String email;
    private String acc;
    private long balance;
    private String type;
    private double initialBalance;
    private String pswd;

}
