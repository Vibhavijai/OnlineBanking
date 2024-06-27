package org.sid.ebankingbackend.web;

import org.sid.ebankingbackend.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.sid.ebankingbackend.dtos.PaymentDTO;

import java.util.List;
import java.util.Date;

@RestController
@CrossOrigin("*")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/pays/all")
    public List<PaymentDTO> getAllPayments() {
        return paymentService.getAllPayments();
    }//////////////////////////done

     @GetMapping("/pays/filterpays")
    public ResponseEntity<List<PaymentDTO>> searchPayments(
        @RequestParam(required = false) Double min_amount,
            @RequestParam(required = false) Double max_amount,
            @RequestParam(required = false) Date start_date,
            @RequestParam(required = false) Date end_date,
            @RequestParam(required = false) Long loan_id
        ) {
         List<PaymentDTO> payDTO = paymentService.filterPayments(loan_id,start_date,end_date,min_amount, max_amount);
        if (payDTO != null) {
            return ResponseEntity.ok(payDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
/* 
     @GetMapping("/pays/{customer_id}")
    public ResponseEntity<List<LoanEntityDTO>> searchLoanbyCustomerId(@PathVariable Long customer_id) {
        List<LoanEntityDTO> loanDTO = loanService.getLoanbyCustomerId(customer_id);
        if (loanDTO != null) {
            return ResponseEntity.ok(loanDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }//////////////////////////done

    @PutMapping("/pays/update/{pay_id}")
    public LoanEntityDTO updateLoan(@PathVariable Long loan_id,@RequestBody LoanEntityDTO loanDTO) {
        loanDTO.setLoan_id(loan_id);
        return loanService.updateLoan(loan_id,loanDTO);
    }//////////////////////////done

    @PostMapping("/pays/newloan")
    public ResponseEntity<LoanEntityDTO> createLoan(@RequestBody LoanEntityDTO loanDTO) {
        LoanEntityDTO savedloanDTO=loanService.saveLoan(loanDTO);
        if (savedloanDTO != null) {
            return ResponseEntity.ok(savedloanDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
        
    }//////////////////////////done

    

    @DeleteMapping("/pays/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable("id") Long loan_id) {
        loanService.deleteLoan(loan_id);
        return ResponseEntity.noContent().build();
    }//////////////////////////done
    */
}