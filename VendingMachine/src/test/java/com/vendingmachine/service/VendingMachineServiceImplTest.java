package com.vendingmachine.service;


import com.vendingmachine.service.VendingMachineServiceImpl;
import com.vendingmachine.service.VendingMachineItemInventoryException;
import com.vendingmachine.service.VendingMachineService;
import com.vendingmachine.service.VendingMachineInsufficientFundsException;
import com.vendingmachine.dao.AuditDao;
import com.vendingmachine.dao.AuditDaoImpl;
import com.vendingmachine.dao.VendingMachineDao;
import com.vendingmachine.dao.VendingMachineDaoImpl;
import com.vendingmachine.dao.VendingMachineException;
import com.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;


public class VendingMachineServiceImplTest 
{
    
    public static VendingMachineService service;
    
    public VendingMachineServiceImplTest() 
    {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        service = context.getBean("serviceLayer", VendingMachineService.class);
    }
    
    @BeforeAll
    public static void setUpClass() throws VendingMachineException
    {
        //implement
        service = new VendingMachineServiceImpl();
    }
    
    @AfterAll
    public static void tearDownClass() 
    {
    }
    
    @BeforeEach
    public void setUp() throws VendingMachineException 
    {
    	
    }
    
    @AfterEach
    public void tearDown() 
    {
    	
    }

    @Test
    public void testGetItem() throws Exception 
    {
        Item testClone = new Item("KettleChips");
            testClone.setCost(new BigDecimal("2.99").setScale(2, RoundingMode.FLOOR));
            testClone.setNumInventoryItems(10);

        Item shouldBeKettleChips = service.getItem("KettleChips");
        assertEquals(testClone, shouldBeKettleChips,"Item should be KettleChips." );

        Item shouldBeNull = service.getItem("fanta");
        assertNull(shouldBeNull, "Getting 'fanta' should be null");
    }

    @Test
    public void testListAllItems() throws Exception 
    {
        assertEquals(1, service.listAllItems().size(), "items");
    }

    @Test
    public void testChangeInventoryCount()
    {
        Item testItem = new Item("KettleChips",  new BigDecimal(2.99).setScale(2,RoundingMode.FLOOR), 100);
        try
        {
            service.changeInventoryCount(testItem, 100);
            assertNotNull(testItem, "Item should not be null");
            assertEquals(100, testItem.getNumInventoryItems(), "Inventory item should be 100");
        }
        catch(VendingMachineException e)
        {
            fail("it doesnt go wrong");
        }
        try
        {
            service.changeInventoryCount(testItem, -100);
        }
        catch(VendingMachineException e)
        {
            System.out.println("the value should not be negative");
        }
    }

    @Test
    public void testSellItem()
    {
        
    }
    
}
