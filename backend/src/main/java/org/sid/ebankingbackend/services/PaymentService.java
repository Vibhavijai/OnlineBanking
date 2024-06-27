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
    public List<PaymentDTO> filterPayments(Long loan_id, Date start_date, Date end_date, Double min_amount, Double max_amount) {
        List<Payment> payments = paymentRepository.findByAttributes(min_amount, max_amount, start_date, end_date, loan_id);
        return payments.stream().map(dtoMapper::fromPayment).collect(Collectors.toList());
    }//////////////////////////done

    public List<PaymentDTO> getPaymentbyCustomerId(Long customer_id) {
        List<Payment> payments = paymentRepository.findByCustomerId(customer_id);
        return payments.stream().map(dtoMapper::fromPayment).collect(Collectors.toList());
    }//////////////////////////done

    public PaymentDTO doPayment(PaymentDTO payDTO) {
        Payment payment=dtoMapper.fromPaymentDTO(payDTO);
        return dtoMapper.fromPayment(paymentRepository.save(payment));
    }//////////////////////////done

    public void deletePayment(Long pay_id) {
        loanRepository.deleteById(pay_id);
    }//////////////////////////done
}