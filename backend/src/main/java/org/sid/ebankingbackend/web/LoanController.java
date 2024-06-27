package org.sid.ebankingbackend.web;

import org.sid.ebankingbackend.entities.LoanEntity;
import org.sid.ebankingbackend.enums.LoanStatus;
import org.sid.ebankingbackend.services.BankAccountService;
import org.sid.ebankingbackend.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.sid.ebankingbackend.dtos.LoanEntityDTO;
import java.util.List;

@RestController
@CrossOrigin("*")
public class LoanController {

    
    private LoanService loanService;
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }
    @GetMapping("/loans/all")
    public List<LoanEntityDTO> getAllLoans() {
        return loanService.getAllLoans();
    }//////////////////////////done
/* 
     @GetMapping("/loans/filterloans")
    public ResponseEntity<List<LoanEntityDTO>> searchLoan(
        @RequestParam(required = false) Long loan_id,
        @RequestParam(required = false) Long plan_id,
        @RequestParam(required = false) Long type_id,
        @RequestParam(required = false) LoanStatus status ,
        @RequestParam(required = false) Double min_amount,
        @RequestParam(required = false) Double max_amount
        ) {
         List<LoanEntityDTO> loanDTO = loanService.filterLoans(loan_id,plan_id,type_id,status,min_amount, max_amount);
        if (loanDTO != null) {
            return ResponseEntity.ok(loanDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

     @GetMapping("/loans/{customer_id}")
    public ResponseEntity<List<LoanEntityDTO>> searchLoanbyCustomerId(@PathVariable Long customer_id) {
        List<LoanEntityDTO> loanDTO = loanService.getLoanbyCustomerId(customer_id);
        if (loanDTO != null) {
            return ResponseEntity.ok(loanDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }//////////////////////////done

    @PutMapping("/loans/update/{loan_id}")
    public LoanEntityDTO updateLoan(@PathVariable Long loan_id,@RequestBody LoanEntityDTO loanDTO) {
        loanDTO.setLoan_id(loan_id);
        return loanService.updateLoan(loan_id,loanDTO);
    }//////////////////////////done

    @PostMapping("/loans/newloan")
    public ResponseEntity<LoanEntityDTO> createLoan(@RequestBody LoanEntityDTO loanDTO) {
        LoanEntityDTO savedloanDTO=loanService.saveLoan(loanDTO);
        if (savedloanDTO != null) {
            return ResponseEntity.ok(savedloanDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
        
    }//////////////////////////done

    

    @DeleteMapping("/loans/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable("id") Long loan_id) {
        loanService.deleteLoan(loan_id);
        return ResponseEntity.noContent().build();
    }//////////////////////////done
    */
}