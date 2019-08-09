package com.cg.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cg.entities.Wallet;
import com.cg.inputFormats.DepositAndWithdraw;
import com.cg.inputFormats.TranserFundFormat;
import com.cg.entities.Wallet;
import com.cg.services.WalletService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired WalletService service;
    
  /*  @GetMapping(value="/mobileno/{mobileno}")	
    public Wallet findbymobile(@PathVariable Long mobile) {
        return service.byMobile(mobile);
    }
    
    
    
    @PostMapping(value="/newadd",consumes= {"application/json"})
    public String save(@RequestBody Wallet wallet) {
        service.create(wallet);
        return "Wallet added!";
    }
    
    @PutMapping(value="/update",consumes= {"application/json"})
    public String update(@RequestBody Wallet wallet) {
        service.update(wallet);
        return "Wallet updated";
    }        
    
   /* @DeleteMapping(value="/delete/{id}", consumes= {"application/json"})

    public String delete(@PathVariable int id) {

     Wallet wallet=service.bymobile(mobile);

     service.deleteById(mobile);



     return "Wallet deleted!";


}*/
    @GetMapping(value="/")	
    public List<Wallet> getAll() {
        return service.getAll();
    }
    
    @GetMapping(value="/aid/{aid}")	
    public Wallet findbycode(@PathVariable Integer aid) {
        return service.byCode(aid);
    }

    
    @PostMapping(value="/new",consumes= {"application/json"})
    public String save(@RequestBody Wallet wallet) {
        service.create(wallet);
        return "Account added!";
    }
    
    @PutMapping(value="/update/{aid}",consumes= {"application/json"})
    public String update(@PathVariable Integer aid,@RequestBody Wallet wallet) {
        service.update(aid,wallet);
        return "Account updated";
    }  
    
    @DeleteMapping(value="/delete/{aid}", consumes= {"application/json"})
    public String delete(@PathVariable Integer aid) {
    	Wallet wallet=service.byCode(aid);
    	service.deleteByCode(wallet);
    	
    	return "Account deleted";
    	
    }
    @PutMapping(value="/deposit/{aid}/{amount}",consumes= {"application/json"})
    public String deposit(@PathVariable int aid, @PathVariable("amount") double amount) {
		Wallet a=service.byCode(aid);
		return service.deposit(a, amount);
	}
    
    @PutMapping(value="/withdraw/{aid}/{amount}",consumes= {"application/json"})
    public String withdraw(@PathVariable int aid, @PathVariable("amount") double amount) {
		Wallet a=service.byCode(aid);
		
		return service.withdraw(a, amount);
	}
    
    @PutMapping(value="/transfer/{aid}/{aid2}/{amount}",consumes= {"application/json"})
public String transferMoney(@PathVariable int aid,@PathVariable int aid2, @PathVariable("amount") double amount) {
		
		
		//double amount = input.getAmount();
		
		Wallet from = service.byCode(aid);
		Wallet to = service.byCode(aid2);
		
		return service.transfer(from, to, amount);
	}
    
    
    
}
