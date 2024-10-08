package tebogomkhize.projects.atmsimulation.account.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import tebogomkhize.projects.atmsimulation.account.model.dto.AccountDTO;
import tebogomkhize.projects.atmsimulation.account.model.dto.ResponseDTO;
import tebogomkhize.projects.atmsimulation.account.service.AccountService;


@RestController
@RequestMapping("api/v1/atmsim")
public class AccountController {
    private AccountService accService;

    @Autowired
    public AccountController(AccountService accService) {
        this.accService = accService;
    }

    @PostMapping("/account")
    public ResponseDTO createAccount(@RequestBody AccountDTO newAcc) {
        return this.accService.createAccount(
            newAcc.getFirstName(), newAcc.getLastName(),
            newAcc.getAge(), newAcc.getEmail());
    }

    @GetMapping("/account/{accountNum}/balance")
    public ResponseDTO getAccBal(@PathVariable String accountNum) {
        return this.accService.getAccBal(accountNum);
    }

    @PutMapping("/account/{accountNum}/deposit/{amount}")
    public ResponseDTO depositMoney(
        @PathVariable String accountNum, @PathVariable float amount) {

        return this.accService.depositMoney(accountNum, amount);
    }

    @PutMapping("/account/{accountNum}/withdraw/{amount}")
    public ResponseDTO withdrawMoney(
        @PathVariable String accountNum, @PathVariable float amount) {

        return this.accService.withdrawMoney(accountNum, amount);
    }

    @PutMapping("/account/{accountNum}/transfer/{transferAcc}/{amount}")
    public ResponseDTO transferMoney(
        @PathVariable String accountNum, @PathVariable String transferAcc,
            @PathVariable float amount) {

        return this.accService.transferMoney(accountNum, transferAcc, amount);
    }

}