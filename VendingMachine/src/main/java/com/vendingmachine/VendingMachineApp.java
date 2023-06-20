
package com.vendingmachine;

import com.vendingmachine.controller.VendingMachineController;
import com.vendingmachine.dao.*;
import com.vendingmachine.service.VendingMachineInsufficientFundsException;
import com.vendingmachine.service.VendingMachineItemInventoryException;
import com.vendingmachine.service.VendingMachineService;
import com.vendingmachine.service.VendingMachineServiceImpl;
import com.vendingmachine.ui.UserIO;
import com.vendingmachine.ui.UserIOImpl;
import com.vendingmachine.ui.VendingMachineView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class VendingMachineApp 
{
    public static void main(String[] args) throws VendingMachineException
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        VendingMachineController controller = ctx.getBean("controller", VendingMachineController.class);
        controller.run();
    }
}
