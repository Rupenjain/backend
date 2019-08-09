package com.cg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cg.daos.WalletDAO;

import com.cg.entities.Wallet;
import com.cg.entities.Wallet;
import com.cg.exceptions.ApplicationException;

@Service
public class WalletService {

    @Autowired private WalletDAO dao;
    @Transactional(readOnly=true)
    public Wallet byCode(Integer aid) {
    	Optional<Wallet> wallet = dao.findById(aid);
    	if(wallet.isPresent()) {
            return wallet.get();
        }
        else
            throw new RuntimeException("Account not found!");
    }
    
    
    public List<Wallet> getAll(){
        
        return dao.findAll(); 
    }
    
    
    
    public void create(Wallet wallet) {
       
            dao.save(wallet);
        }
    
    
    public void update(Integer aid, Wallet wallet) {
    	Wallet temp = byCode(aid);
        dao.delete(temp);
        dao.save(wallet);

                 
    }

    /*
    public void update(Wallet wallet) {
        Wallet temp = dao.findByMobile(wallet.getMobile());
        if(temp!=null)
        {
            dao.update(wallet);
        }else
            throw new ApplicationException("Country "+wallet.getMobile()+" didn't exists!");
    }*/
    
    public void deleteByCode(Wallet c) {//deleting method for data in table
    	dao.delete(c);
    }
    
    public String deposit(Wallet ob, double amount) {
		if(amount>0)
		{
			double new_bal=ob.getBalance()+amount;
			ob.setBalance(new_bal);
			update(ob.getAid(),ob);
			return "Account updated Sucessfully";
		}
		else
		{
			return "Account can't be updated";
		}
	}
    
    public String withdraw(Wallet ob, double amount) {
		if(amount>999)
		{
			double new_bal=ob.getBalance()-amount;
			ob.setBalance(new_bal);
			update(ob.getAid(),ob);
			return "Account updated Sucessfully";
		}
		else
		{
			return "Account can't be updated";
		}
	}
    
    @Transactional(propagation = Propagation.REQUIRED)
	public String transfer(Wallet from, Wallet to, double amount) {
    	if(amount<0)
    	{ 
    		System.out.println("enter suitable amount");
    		
    	}
    	else {
    		double bal=from.getBalance();
    		double bal2=to.getBalance();
    		if(amount<(bal-1000.00))
    		{
    			bal=bal-amount;
    			from.setBalance(bal);
    			bal2=bal2+amount;
    			to.setBalance(bal2);
    			
    			
    		}
    		else
    		{
    			System.out.println("cannot transfer");
    			
    		}
    		
    				
    	}
    	return "Transfer successful";
		
		
		
	}
    
    
}