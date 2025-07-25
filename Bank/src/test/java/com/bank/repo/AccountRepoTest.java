package com.bank.repo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.ActiveProfiles;

import com.bank.entity.AccountEntity;
import com.bank.entity.ProductEntity;
import com.bank.entity.CustomerEntity;

import lombok.extern.slf4j.Slf4j;

// TODO: SpringBoot: Practical Bonus 1 - Unit Test for AccountRepo
// create unit test for create, delete and get account 
// use CustomerRepoTest as an example

@Slf4j
@SpringBootTest
@ActiveProfiles("test") // Uses application-test.properties for H2 setup

class AccountRepoTest {

	@Autowired
    private IAccountRepo accountRepo;

    @Autowired
    private ICustomerRepo customerRepo;

    @Autowired
    private IProductRepo productRepo;
    
    @AfterEach
    void cleanUp() {
    	accountRepo.deleteAll();  // add this method if not already present
        customerRepo.deleteAll();  // add this method if not already present
        productRepo.deleteAll();  // add this method if not already present
    }
    
    private CustomerEntity createCustomer() {
    	CustomerEntity customer = new CustomerEntity();
        customer.setIcNumber("IC123456");
        customer.setLastname("Doe");
        customer.setSurname("John");
        customer.setDescription("Test customer");
        customer.setCreationDate(LocalDateTime.now());
        return customerRepo.save(customer);  
    }
    private ProductEntity createProduct() {
    	ProductEntity product = new ProductEntity();
        product.setProductID(1L);
        product.setProductName("Test Product");
        product.setDescription("Test Description");
        return productRepo.save(product);  
    }
    @Test
    @Order(1)
    void testCreateAccount() {

        // Create AccountEntity and link Customer & Product
        AccountEntity account = new AccountEntity();
        account.setAccountNumber("123");
        account.setBalance(100.21);
        account.setCreationDate(LocalDateTime.now());
        account.setCustomerEntity(createCustomer());  
        account.setProductEntity(createProduct());     

        AccountEntity saved = accountRepo.save(account);

        assertNotNull(saved.getAccountID());
        assertEquals("123", saved.getAccountNumber());
    }

    @Test
    @Order(2)
    void testFindAccountById() {
        AccountEntity account = new AccountEntity();
        account.setAccountID(1L);
        account.setAccountNumber("123");
        account.setBalance(100.10);
        account.setCreationDate(LocalDateTime.now());
        account.setCustomerEntity(createCustomer());  
        account.setProductEntity(createProduct());    
        
        AccountEntity saved = accountRepo.save(account);

        Optional<AccountEntity> found = accountRepo.findById(saved.getAccountID());
        
        assertTrue(found.isPresent());
        assertEquals("123", found.get().getAccountNumber());
    }

    @Test
    @Order(3)
    void testDeleteAccount() {
    	
        AccountEntity account = new AccountEntity();
        
        account.setCustomerEntity(createCustomer());  
        account.setProductEntity(createProduct()); 
        
        account.setAccountID(1L);
        account.setAccountNumber("123");
        account.setBalance(100.20);
        account.setCreationDate(LocalDateTime.now());
           

        AccountEntity saved = accountRepo.save(account);
        Long id = saved.getAccountID();

        accountRepo.deleteById(id);

        Optional<AccountEntity> deleted = accountRepo.findById(id);
        assertFalse(deleted.isPresent());
    }
}