package com.demo.bankapp.controller;

import javax.security.auth.login.AccountNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bankapp.dto.AccountDetails;
import com.demo.bankapp.model.Accounts;
import com.demo.bankapp.service.AccountService;
import com.demo.bankapp.service.Impl.BankingServiceImpl;

@RestController
@Controller
@Configuration
public class AccountController {
@Autowired
	private AccountService accountService;
@Autowired
    private BankingServiceImpl bankingService;
	
	@PostMapping("/add/{acctNum}")
	public ResponseEntity<Accounts> saveAccounts(@RequestBody @Valid AccountDetails accountDetails){
		return new ResponseEntity<>(accountService.saveAccounts(accountDetails),HttpStatus.CREATED);
	}
	
	@GetMapping("{/acctNum}")
	public ResponseEntity<Accounts> getAccouts(@PathVariable Long acctNum) throws AccountNotFoundException{
		return ResponseEntity.ok(accountService.getAccounts(acctNum));
	}
	
	@GetMapping(path = "/{acctNum}")
	/*@ApiOperation(value = "Get account details", notes = "Find account details by account number")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error") })*/

	public ResponseEntity<Object> getByAcctNum(@PathVariable Long acctNum) {

		return bankingService.findByAcctNum(acctNum);
	}
	
	

}
