package org.sid.ebankingbackend.services;
import org.sid.ebankingbackend.repositories.LoanRepository;
import org.sid.ebankingbackend.repositories.LoanTypeRepository;
import org.sid.ebankingbackend.repositories.LoanPlanRepository;

import org.sid.ebankingbackend.entities.LoanType;
import org.sid.ebankingbackend.entities.LoanEntity;
import org.sid.ebankingbackend.entities.LoanPlan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

import javax.persistence.EntityNotFoundException;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;
    @Autowired
    private LoanTypeRepository loanTypeRepository;
    @Autowired
    private LoanPlanRepository loanPlanRepository;


    public List<LoanEntity> getAllLoans() {
        List<LoanEntity> loans = loanRepository.findAll();
        return loans;
    }//////////////////////////done

    public List<LoanType> getAllLoanTypes() {
        List<LoanType> loantypes = loanTypeRepository.findAll();
        return loantypes;
    }//////////////////////////done
    public List<LoanPlan> getAllLoanPlans() {
        List<LoanPlan> loanplans = loanPlanRepository.findAll();
        return loanplans;
    }//////////////////////////done

    public LoanType setNewLoanType(LoanType loanType) {
        LoanType loantype = loanTypeRepository.save(loanType);
        return loantype;
    }//////////////////////////done
    public LoanPlan setNewLoanPlan(LoanPlan loanPlan) {
        LoanPlan loanplan = loanPlanRepository.save(loanPlan);
        return loanplan;
    }//////////////////////////done
    
    public List<LoanEntity> filterLoans(Long loan_id,Long plan_id, Long type_id, String status, Integer min_amount, Integer max_amount) {
        List<LoanEntity> loans = loanRepository.findByAttributes(loan_id,plan_id,type_id,status,min_amount, max_amount);
        return loans;
    }//////////////////////////done

    

    public LoanEntity updateLoan(Long id, Double pending_amt, String status) {
        Optional<LoanEntity> optionalLoanEntity = loanRepository.findById(id);
        if (optionalLoanEntity.isPresent()) {
            LoanEntity loanEntity = optionalLoanEntity.get();
           // loanEntity.setLoanType(dtoMapper.fromLoanTypeDTO(loanDTO.getLoanTypeDTO()));
            loanEntity.setPending_amt(pending_amt);
            loanEntity.setStatus(status);
            // Update other fields as necessary
            return loanRepository.save(loanEntity);
        } else {
            throw new EntityNotFoundException("Loan not found for id: " + id);
        }
    }///////////////////////////done
 
    public List<LoanEntity> getLoanbyCustomerId(Long customer_id) {
        List<LoanEntity> loans = loanRepository.findByCustomerId(customer_id);
        return loans;
    }//////////////////////////done

    public LoanEntity saveLoan(LoanEntity loanDTO) {
        
        return loanRepository.save(loanDTO);
    }//////////////////////////done

    public void deleteLoan(Long id) {
        
        loanRepository.deleteById(id);
        
    }//////////////////////////done
    
}