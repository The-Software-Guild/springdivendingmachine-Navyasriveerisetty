
package com.vendingmachine.service;

import com.vendingmachine.dao.VendingMachineException;
import com.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.List;


public interface VendingMachineService 
{
    Item getItem(String name) throws VendingMachineException,VendingMachineItemInventoryException;
    List<Item> listAllItems() throws VendingMachineException;
    Item addItem(Item item) throws VendingMachineException;
    Item removeItem(Item item) throws VendingMachineException;
    Item changeInventoryCount(Item item, int newCount) throws VendingMachineException;
    BigDecimal sellItem(BigDecimal totalFunds,Item item) throws VendingMachineException, VendingMachineItemInventoryException, VendingMachineInsufficientFundsException;
}
