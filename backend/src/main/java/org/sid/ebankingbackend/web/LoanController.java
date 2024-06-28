package org.sid.ebankingbackend.web;

import org.sid.ebankingbackend.entities.LoanEntity;
import org.sid.ebankingbackend.entities.LoanPlan;
import org.sid.ebankingbackend.entities.LoanType;

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
    public List<LoanEntity> getAllLoans() {
        return loanService.getAllLoans();
    }//////////////////////////done

    @GetMapping("/loantypes")
    public List<LoanType> getAllLoanTypes() {
        return loanService.getAllLoanTypes();
    }//////////////////////////done
    @GetMapping("/loanplans")
    public List<LoanPlan> getAllLoanPlans() {
        return loanService.getAllLoanPlans();
    }//////////////////////////done
 
    @GetMapping("/loantypes/newtype")
    public LoanType setNewLoanType(@RequestBody LoanType loanType) {
        return loanService.setNewLoanType(loanType);
    }//////////////////////////done
    @GetMapping("/loanplans/newplan")
    public LoanPlan setNewLoanPlan(@RequestBody LoanPlan loanPlan) {
        return loanService.setNewLoanPlan(loanPlan);
    }//////////////////////////done
    
     @GetMapping("/loans/filterloans")
    public ResponseEntity<List<LoanEntity>> searchLoan(
        @RequestParam(required = false) Long loan_id,
        @RequestParam(required = false) Long plan_id,
        @RequestParam(required = false) Long type_id,
        @RequestParam(required = false) String status ,
        @RequestParam(required = true) Integer min_amount,
        @RequestParam(required = true) Integer max_amount
        ) {
         List<LoanEntity> loanDTO = loanService.filterLoans(loan_id,plan_id,type_id,status,min_amount, max_amount);
        if (loanDTO != null) {
            return ResponseEntity.ok(loanDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

     @GetMapping("/loans/{customer_id}")
    public ResponseEntity<List<LoanEntity>> searchLoanbyCustomerId(@PathVariable Long customer_id) {
        List<LoanEntity> loanDTO = loanService.getLoanbyCustomerId(customer_id);
        if (loanDTO != null) {
            return ResponseEntity.ok(loanDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }//////////////////////////done
 
    @PutMapping("/loans/update/{loan_id}/{pending_amt}/{status}")
    public LoanEntity updateLoan(@PathVariable Long loan_id,@PathVariable Double pending_amt, @PathVariable String status) {
        return loanService.updateLoan(loan_id,pending_amt,status);
    }//////////////////////////done
 
    @PostMapping("/loans/newloan")
    public ResponseEntity<LoanEntity> createLoan(@RequestBody LoanEntity loanDTO) {
        LoanEntity savedloanDTO=loanService.saveLoan(loanDTO);
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
    
}