package org.sid.ebankingbackend.services;
import org.sid.ebankingbackend.repositories.LoanRepository;
import org.sid.ebankingbackend.repositories.PaymentRepository;
import org.sid.ebankingbackend.entities.Customer;
import org.sid.ebankingbackend.entities.LoanEntity;
import org.sid.ebankingbackend.entities.Payment;
import org.sid.ebankingbackend.mappers.BankAccountMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import org.sid.ebankingbackend.dtos.LoanEntityDTO;
import org.sid.ebankingbackend.dtos.PaymentDTO;

import java.util.List;
import java.util.Date;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

@Service
public class PaymentService {

    @Autowired
    private LoanRepository loanRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    private BankAccountMapperImpl dtoMapper;

    public List<PaymentDTO> getAllPayments() {
        List<Payment> payments = paymentRepository.findAll();
        return payments.stream()
                .map(dtoMapper::fromPayment)
                .collect(Collectors.toList());
    }//////////////////////////done
    public List<Payment> filterPayments(Long loan_id, Date start_date, Date end_date, Double min_amount, Double max_amount) {
        List<Payment> payments = paymentRepository.findByAttributes(min_amount, max_amount, start_date, end_date, loan_id);
        return payments;
    }//////////////////////////done

    public List<Payment> filterPayments(Long loan_id) {//for retrieval from customer view
        Date start_date=new Date(0);
        Date end_date=new Date();
        List<Payment> payments = paymentRepository.findByAttributes(0.0, Double.MAX_VALUE, start_date, end_date, loan_id);
        return payments;
    }//////////////////////////done

    
    public Payment updatePaymentStatus(Long pay_id,String pay_status) {
        Optional<Payment> payment = paymentRepository.findById(pay_id);
        if (payment.isPresent()) {
            Payment pay = payment.get();
            pay.setPay_status(pay_status);
            return paymentRepository.save(pay);
        } else {
            return null;
            //throw new EntityNotFoundException("Loan not found for id: " + id);
        }
        
    }

    public Payment doPayment(Payment payment) {
        
        return paymentRepository.save(payment);
    }//////////////////////////done

    public void deletePayment(Long pay_id) {
        loanRepository.deleteById(pay_id);
    }//////////////////////////done
}