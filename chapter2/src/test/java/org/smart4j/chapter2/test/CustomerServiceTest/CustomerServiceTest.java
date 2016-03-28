package org.smart4j.chapter2.test.CustomerServiceTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.smart4j.chapter2.model.Customer;
import org.smart4j.chapter2.service.CustomerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhonghua on 15/10/26.
 */
public class CustomerServiceTest {

    private final CustomerService customerService;

    public CustomerServiceTest() {
        customerService = new CustomerService();
    }

    @Before
    public void init() {
        // TODO 初始化数据库
    }

    @Test
    public void getCustomerListTest() throws Exception {

        List<Customer> customerList = customerService.getCustomerList("");
        System.out.println(customerList.get(0).toString());
        Assert.assertEquals(2, customerList.size());
    }

//    @Test
//    public void getCustomer() throws Exception {
//
//        long id = 1;
//        Customer customer = customerService.getCustomer(id);
//        Assert.assertNotNull(customer);
//    }
//
//    @Test
//    public void createCustomerTest() throws Exception {
//
//        Map<String, Object> fieldMap = new HashMap<String, Object>();
//        fieldMap.put("name", "customer100");
//        fieldMap.put("contact", "John");
//        fieldMap.put("telephone", "13333333333");
//
//        boolean result = customerService.createCustomer(fieldMap);
//        Assert.assertTrue(result);
//    }
//
//    @Test
//    public void updateCustomerTest() throws Exception {
//
//        long id = 1;
//        Map<String, Object> fieldMap = new HashMap<String, Object>();
//        fieldMap.put("contact", "Eric");
//
//        boolean result = customerService.updateCustomer(id, fieldMap);
//        Assert.assertTrue(result);
//    }
//
//    @Test
//    public void deleteCustomerTest() throws Exception {
//
//        long id = 1;
//        boolean result = customerService.deleteCustmer(id);
//        Assert.assertTrue(result);
//    }
}