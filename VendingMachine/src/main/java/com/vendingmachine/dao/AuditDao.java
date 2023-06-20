
package com.vendingmachine.dao;

import com.vendingmachine.dao.VendingMachineException;


public interface AuditDao 
{
    public void writeAuditEntry(String entry) throws VendingMachineException;
}
