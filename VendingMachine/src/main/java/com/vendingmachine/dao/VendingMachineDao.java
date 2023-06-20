
package com.vendingmachine.dao;

import com.vendingmachine.dto.Item;
import java.util.List;


public interface VendingMachineDao 
{
    Item getItem(String name) throws VendingMachineException;
    List<Item> listAllItems() throws VendingMachineException;
    Item addItem(Item item) throws VendingMachineException;
    Item removeItem(Item item) throws VendingMachineException;
    Item changeInventoryCount(Item item, int newCount) throws VendingMachineException;
	Item addItem(String name, Item item) throws VendingMachineException;
}
