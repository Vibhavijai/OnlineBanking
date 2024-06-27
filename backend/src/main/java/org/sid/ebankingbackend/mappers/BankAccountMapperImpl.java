package org.sid.ebankingbackend.mappers;

import org.sid.ebankingbackend.dtos.AccountOperationDTO;
import org.sid.ebankingbackend.dtos.CurrentBankAccountDTO;
import org.sid.ebankingbackend.dtos.CustomerDTO;
import org.sid.ebankingbackend.dtos.SavingBankAccountDTO;
import org.sid.ebankingbackend.dtos.LoanEntityDTO;
import org.sid.ebankingbackend.dtos.LoanPlanDTO;
import org.sid.ebankingbackend.dtos.LoanTypeDTO;
import org.sid.ebankingbackend.dtos.PaymentDTO;

import org.sid.ebankingbackend.entities.AccountOperation;
import org.sid.ebankingbackend.entities.CurrentAccount;
import org.sid.ebankingbackend.entities.Customer;
import org.sid.ebankingbackend.entities.SavingAccount;
import org.sid.ebankingbackend.entities.LoanEntity;
import org.sid.ebankingbackend.entities.LoanPlan;
import org.sid.ebankingbackend.entities.LoanType;
import org.sid.ebankingbackend.entities.Payment;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
@Service
public class BankAccountMapperImpl{   
    
    public LoanTypeDTO fromLoanType(LoanType loantype){
        LoanTypeDTO loanTypeDTO=new LoanTypeDTO();
        //handle code
        return loanTypeDTO;
    }
    public LoanPlanDTO fromLoanPlan(LoanPlan loanplan){
        LoanPlanDTO loanPlanDTO=new LoanPlanDTO();
        //handle code
        return loanPlanDTO;
    }
    public LoanEntityDTO fromLoanEntity(LoanEntity loan){
        LoanEntityDTO loanEntityDTO=new LoanEntityDTO();
        BeanUtils.copyProperties(loan,loanEntityDTO);
        loanEntityDTO.setLoanTypeDTO(fromLoanType(loan.getLoanType()));
        loanEntityDTO.setLoanPlanDTO(fromLoanPlan(loan.getLoanPlan()));
        loanEntityDTO.setCustomerDTO(fromCustomer(loan.getCustomer()));
        return loanEntityDTO;
    }  
    public LoanType fromLoanTypeDTO(LoanTypeDTO loanTypeDTO) {
        LoanType loanType = new LoanType();
        BeanUtils.copyProperties(loanTypeDTO, loanType);
        // Handle any additional properties or relationships if necessary
        return loanType;
    }

    public LoanPlan fromLoanPlanDTO(LoanPlanDTO loanPlanDTO) {
        LoanPlan loanPlan = new LoanPlan();
        BeanUtils.copyProperties(loanPlanDTO, loanPlan);
        // Handle any additional properties or relationships if necessary
        return loanPlan;
    }

    public LoanEntity fromLoanEntityDTO(LoanEntityDTO loanEntityDTO) {
        LoanEntity loanEntity = new LoanEntity();
        BeanUtils.copyProperties(loanEntityDTO, loanEntity);
        loanEntity.setLoanType(fromLoanTypeDTO(loanEntityDTO.getLoanTypeDTO()));
        loanEntity.setLoanPlan(fromLoanPlanDTO(loanEntityDTO.getLoanPlanDTO()));
        loanEntity.setCustomer(fromCustomerDTO(loanEntityDTO.getCustomerDTO()));
        return loanEntity;

    }
    public Payment fromPaymentDTO(PaymentDTO paymentDTO) {
        Payment payment = new Payment();
        BeanUtils.copyProperties(paymentDTO, payment);
        payment.setLoan(fromLoanEntityDTO(paymentDTO.getLoanDTO()));
        return payment;

    }
    public PaymentDTO fromPayment(Payment payment) {
        PaymentDTO paymentDTO = new PaymentDTO();
        BeanUtils.copyProperties(payment, paymentDTO);
        paymentDTO.setLoanDTO(fromLoanEntity(payment.getLoan()));
        return paymentDTO;

    }



    public CustomerDTO fromCustomer(Customer customer){
        CustomerDTO customerDTO=new CustomerDTO();
        BeanUtils.copyProperties(customer,customerDTO);
        return  customerDTO;
    }
    public Customer fromCustomerDTO(CustomerDTO customerDTO){
        Customer customer=new Customer();
        BeanUtils.copyProperties(customerDTO,customer);
        return  customer;
    }

    public SavingBankAccountDTO fromSavingBankAccount(SavingAccount savingAccount){
        SavingBankAccountDTO savingBankAccountDTO=new SavingBankAccountDTO();
        BeanUtils.copyProperties(savingAccount,savingBankAccountDTO);
        savingBankAccountDTO.setCustomerDTO(fromCustomer(savingAccount.getCustomer()));
        savingBankAccountDTO.setType(savingAccount.getClass().getSimpleName());
        return savingBankAccountDTO;
    }

    public SavingAccount fromSavingBankAccountDTO(SavingBankAccountDTO savingBankAccountDTO){
        SavingAccount savingAccount=new SavingAccount();
        BeanUtils.copyProperties(savingBankAccountDTO,savingAccount);
        savingAccount.setCustomer(fromCustomerDTO(savingBankAccountDTO.getCustomerDTO()));
        return savingAccount;
    }

    public CurrentBankAccountDTO fromCurrentBankAccount(CurrentAccount currentAccount){
        CurrentBankAccountDTO currentBankAccountDTO=new CurrentBankAccountDTO();
        BeanUtils.copyProperties(currentAccount,currentBankAccountDTO);
        currentBankAccountDTO.setCustomerDTO(fromCustomer(currentAccount.getCustomer()));
        currentBankAccountDTO.setType(currentAccount.getClass().getSimpleName());
        return currentBankAccountDTO;
    }

    public CurrentAccount fromCurrentBankAccountDTO(CurrentBankAccountDTO currentBankAccountDTO){
        CurrentAccount currentAccount=new CurrentAccount();
        BeanUtils.copyProperties(currentBankAccountDTO,currentAccount);
        currentAccount.setCustomer(fromCustomerDTO(currentBankAccountDTO.getCustomerDTO()));
        return currentAccount;
    }

    public AccountOperationDTO fromAccountOperation(AccountOperation accountOperation){
        AccountOperationDTO accountOperationDTO=new AccountOperationDTO();
        BeanUtils.copyProperties(accountOperation,accountOperationDTO);
        return accountOperationDTO;
    }

}
