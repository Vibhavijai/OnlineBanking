package org.sid.ebankingbackend.web;

import org.sid.ebankingbackend.services.PaymentService;
import org.sid.ebankingbackend.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.sid.ebankingbackend.dtos.PaymentDTO;
import org.sid.ebankingbackend.entities.LoanEntity;
import org.sid.ebankingbackend.entities.Payment;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

@RestController
@CrossOrigin("*")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private LoanService loanService;

    @GetMapping("/pays/all")
    public List<PaymentDTO> getAllPayments() {
        return paymentService.getAllPayments();
    }//////////////////////////done

     @GetMapping("/pays/filterpays")
    public ResponseEntity<List<Payment>> searchPayments(
        @RequestParam(required = true) Double min_amount,
            @RequestParam(required = true) Double max_amount,
            @RequestParam(required = true) Date start_date,
            @RequestParam(required = true) Date end_date,
            @RequestParam(required = false) Long loan_id
        ) {
         List<Payment> pay = paymentService.filterPayments(loan_id,start_date,end_date,min_amount, max_amount);
        if (pay != null) {
            return ResponseEntity.ok(pay);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
 
     @GetMapping("/pays/{customer_id}")
    public ResponseEntity<List<Payment>> searchPaymentbyCustomerId(@PathVariable Long customer_id,
            @RequestParam(required = false) Double min_amount,
            @RequestParam(required = false) Double max_amount,
            @RequestParam(required = false) Date start_date,
            @RequestParam(required = false) Date end_date
    ) {
        List<LoanEntity> loans=loanService.getLoanbyCustomerId(customer_id);
        List<Payment> pays=new ArrayList<>();
        for(LoanEntity l: loans){
            List<Payment> pay = paymentService.filterPayments(l.getLoan_id(),start_date,end_date,min_amount, max_amount);
            pays.addAll(pay);
        }
        if (pays != null) {
            return ResponseEntity.ok(pays);
        } else {
            return ResponseEntity.notFound().build();
        }
    }//////////////////////////done

    @PutMapping("/pays/update/{pay_id}/{pay_status}")
    public Payment updateLoan(@PathVariable Long pay_id,@PathVariable String pay_status) {
        return paymentService.updatePaymentStatus(pay_id,pay_status);
    }//////////////////////////done

    @PostMapping("/pays/newpay")
    public ResponseEntity<Payment> createLoan(@RequestBody Payment payment) {
        Payment savedPayment=paymentService.doPayment(payment);
        if (savedPayment != null) {
            return ResponseEntity.ok(savedPayment);
        } else {
            return ResponseEntity.notFound().build();
        }
        
    }//////////////////////////done

    

    @DeleteMapping("/pays/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable("id") Long pay_id) {
        loanService.deleteLoan(pay_id);
        return ResponseEntity.noContent().build();
    }//////////////////////////done
    
}