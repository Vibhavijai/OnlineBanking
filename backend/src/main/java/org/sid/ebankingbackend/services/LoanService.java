package org.sid.ebankingbackend.services;
import org.sid.ebankingbackend.repositories.LoanRepository;
import org.sid.ebankingbackend.entities.Customer;
import org.sid.ebankingbackend.entities.LoanEntity;
import org.sid.ebankingbackend.entities.Payment;
import org.sid.ebankingbackend.mappers.BankAccountMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import org.sid.ebankingbackend.dtos.LoanEntityDTO;
import org.sid.ebankingbackend.dtos.PaymentDTO;
import org.sid.ebankingbackend.enums.LoanStatus;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;
    private BankAccountMapperImpl dtoMapper;

    public List<LoanEntityDTO> getAllLoans() {
        List<LoanEntity> loans = loanRepository.findAll();
        return loans.stream()
                .map(dtoMapper::fromLoanEntity)
                .collect(Collectors.toList());
    }//////////////////////////done
    /*
    public List<LoanEntityDTO> filterLoans(Long loan_id,Long plan_id, Long type_id, LoanStatus status, Double min_amount, Double max_amount) {
        List<LoanEntity> loans = loanRepository.findByAttributes(loan_id,plan_id,type_id,status,min_amount, max_amount);
        return loans.stream().map(dtoMapper::fromLoanEntity).collect(Collectors.toList());
    }//////////////////////////done

    public LoanEntityDTO updateLoan(Long id, LoanEntityDTO loanDTO) {
        Optional<LoanEntity> optionalLoanEntity = loanRepository.findById(id);
        if (optionalLoanEntity.isPresent()) {
            LoanEntity loanEntity = optionalLoanEntity.get();
           // loanEntity.setLoanType(dtoMapper.fromLoanTypeDTO(loanDTO.getLoanTypeDTO()));
            loanEntity.setPending_amt(loanDTO.getPending_amt());
            loanEntity.setStatus(loanDTO.getStatus());
            // Update other fields as necessary
            return dtoMapper.fromLoanEntity(loanRepository.save(loanEntity));
        } else {
            throw new EntityNotFoundException("Loan not found for id: " + id);
        }
    }///////////////////////////done

    public List<LoanEntityDTO> getLoanbyCustomerId(Long customer_id) {
        List<LoanEntity> loans = loanRepository.findByCustomerId(customer_id);
        return loans.stream().map(dtoMapper::fromLoanEntity).collect(Collectors.toList());
    }//////////////////////////done

    public LoanEntityDTO saveLoan(LoanEntityDTO loanDTO) {
        LoanEntity loan=dtoMapper.fromLoanEntityDTO(loanDTO);
        return dtoMapper.fromLoanEntity(loanRepository.save(loan));
    }//////////////////////////done

    public void deleteLoan(Long id) {
        loanRepository.deleteById(id);
    }//////////////////////////done
    */
}