package com.vendingmachine.ui;

import com.vendingmachine.dto.Coins;
import com.vendingmachine.dto.Item;
import com.vendingmachine.ui.UserIOImpl;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;


public class VendingMachineView 
{
    private UserIO io;

    public VendingMachineView() 
    {
        io=new UserIOImpl();
    }

    
    public VendingMachineView(UserIO io) 
    {
        this.io = io;
    }
    
    
    public void  printMenu() 
    {
        mainMenuBanner();
        io.print("1. Add Money");
        io.print("2. Buy Item");
        io.print("3. Quit");
    }
    
    public int getMenuSelection() 
    {
        return io.readInt("Please select an option: ");
    }
    
    public int getItemSelection()
    {
        return io.readInt("Please select an item");
    }
    
    
    public BigDecimal displayAndGetFunds()
    {
        addMoneyBanner();
        BigDecimal funds = io.readBigDecimal("Enter funds to add ($0 - $100): ", new BigDecimal(0), new BigDecimal(100));
        io.print("Funds added");
        io.readString("Please hit enter to continue.");
        return funds;
    }
    
    
    public void displayBalance(BigDecimal bal)
    {
        io.print("Current balance:"+bal.setScale(2, RoundingMode.DOWN));
    }
    
    public void displayErrorMessage(String message)
    {
        io.print(message + '\n');
        io.readString("Please hit enter to continue.");
    }
    
   
    public ArrayList<String> printAllItems(List<Item> itemList)
    {
        allItemsBanner();
        int j=1;
        ArrayList<String> list=new ArrayList<>();
        list.add(0,"null");
        
        for(Item i:itemList)
        {
            io.print(j+". "+i.toString());
            list.add(j, i.getName());
            j++;
        }
        return list;
    }
    
    public void printChanges(LinkedHashMap<Coins,Integer> map)
    {
        for(Coins c:map.keySet())
        {
            io.print(c.name()+"("+c.getValue()+"): "+map.get(c)+"\n");
        }
    }
    
     public void displayUnknownCommand() 
     {
        io.print("Invalid input. Please input 0, 1 or 2" + "\n");
     }
    

    
    public void mainMenuBanner()
    {
        io.print("======Main Menu========");
    }
    
    public void addMoneyBanner()
    {
        io.print("====ADD FUNDS====");
    }
    
    public void allItemsBanner()
    {
        io.print("=======Vending Machine Items==========");        
    }
    
    public void purchaseSucceeded()
    {
        io.print("Purchase Succeeded!");
    }
    
   
    public void displayQuitMessage()
    {
        io.print("Goodbye" + "\n");
    }
}
