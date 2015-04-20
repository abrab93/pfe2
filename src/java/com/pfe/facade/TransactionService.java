/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.facade;

import com.pfe.model.Transaction;
import java.util.List;

/**
 *
 * @author abdelmouhgit
 */
public interface TransactionService {
    
    public void save(Transaction transaction);
    public Transaction findById(int id);
    public List<Transaction> findAll();
}
