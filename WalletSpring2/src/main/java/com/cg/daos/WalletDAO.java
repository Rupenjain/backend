package com.cg.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entities.Wallet;


public interface WalletDAO extends JpaRepository<Wallet, Integer>{
	
}
