package com.example.demo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.model.Item;
import com.example.demo.service.ItemService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ItemServiceTest {

	//TODO: SpringBoot:Practical 4 - Unit Testing continue
	//Complete the TODO below
	
    private ItemService itemService;

    @BeforeEach
    void setUp() {
        itemService = new ItemService();
    }

    @Test
    void testCreateItem() { // create auto generated id
        Item item = itemService.createItem("Test Value");
        assertNotNull(item);
        assertEquals("Test Value", item.value());
        assertTrue(item.id() > 0);
    }

    @Test
    void testCreateItemWithProvidedId_Success() { // create with specified id
        Optional<Item> optionalItem = itemService.createItemWithProvidedId(100L, "Manual ID Item");
        assertTrue(optionalItem.isPresent());
     // TODO: complete the optionalItem.get().id() is equal to 100L above
        assertEquals(100L, optionalItem.get().id());
    }

    @Test
    void testGetItemById() { // retrieve existing item
        Item created = itemService.createItem("Lookup");
        Optional<Item> fetched = itemService.getItemById(created.id());
     // TODO: complete the assert result above
        assertTrue(fetched.isPresent());
        assertEquals("Lookup", fetched.get().value());
    }

    @Test
    void testGetAllItems() { // retrieve all item
        itemService.createItem("One");
        itemService.createItem("Two");
        List<Item> items = itemService.getAllItems();
        assertEquals(2, items.size());
    }

    @Test
    void testUpdateItem_Success() { // update all item
        Item created = itemService.createItem("Before");
        Optional<Item> updated = itemService.updateItem(created.id(), "After");
        assertTrue(updated.isPresent());
        assertEquals("After", updated.get().value());
    }

    @Test
    void testDeleteItem_Success() { // delete existing item
        Item created = itemService.createItem("Delete Me");
        boolean result = itemService.deleteItem(created.id());
        assertTrue(result);
        // TODO: complete the assert result above
    }

    @Test
    void testDeleteItem_NotFound() { // delete non existent item
        boolean result = itemService.deleteItem(12345L);
     // TODO: complete the assert result above
        assertFalse(result);
    }

}
