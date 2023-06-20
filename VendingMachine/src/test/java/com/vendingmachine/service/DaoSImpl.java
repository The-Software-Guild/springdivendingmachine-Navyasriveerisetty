package com.vendingmachine.service;


import com.vendingmachine.dao.VendingMachineDao;
import com.vendingmachine.dao.VendingMachineException;
import com.vendingmachine.dto.Item;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class DaoSImpl implements VendingMachineDao 
{

    public Item onlyItem;

    public DaoSImpl() 
    {
        onlyItem = new Item("KettleChips");
        onlyItem.setCost(new BigDecimal("2.99").setScale(2, RoundingMode.FLOOR));
        onlyItem.setNumInventoryItems(10);
    }

    public DaoSImpl(Item testItem) 
    {
        this.onlyItem = testItem;
    }

    @Override
    public Item getItem(String name) throws VendingMachineException 
    {
        if (name.equals(onlyItem.getName()))
            return onlyItem;
        else
            return null;
    }

    @Override
    public List<Item> listAllItems() throws VendingMachineException 
    {
        List<Item> itemList = new ArrayList<>();
        itemList.add(onlyItem);
        return itemList;
    }

    @Override
    public Item addItem(Item item) throws VendingMachineException 
    {
        return null;
    }

    @Override
    public Item addItem(String name, Item item) throws VendingMachineException  
    {
        if (name.equals(onlyItem.getName())) 
        {
            return onlyItem;
        } 
        else 
        {
            return null;
        }
    }

    @Override
    public Item removeItem(Item item) throws VendingMachineException
    {
        if (item.getName().equals(onlyItem.getName()))
            return onlyItem;
        else
            return null;
    }

    @Override
    public Item changeInventoryCount(Item item, int newCount) throws VendingMachineException {
        if (item.getNumInventoryItems() + newCount >= 0) 
        {
            onlyItem.setNumInventoryItems(newCount);
            return onlyItem;
        } 
        else
            return null;
    }
}