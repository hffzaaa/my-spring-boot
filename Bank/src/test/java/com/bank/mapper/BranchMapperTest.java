package com.bank.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bank.entity.BranchEntity;
import com.bank.model.BranchDTO;

@SpringBootTest
class BranchMapperTest {

    @Autowired
    private BranchMapper branchMapper;

    @Test
    void testEntityToDtoAndBack() {
       
        // BranchEntity
        BranchEntity branch = new BranchEntity();
//        branch.setBranchID(1L);
        branch.setBranchName("Main Branch");
        branch.setBranchPostCode("12345");
        branch.setCreationDate(LocalDateTime.now());

        // Mapping to DTO
        BranchDTO dto = branchMapper.toDto(branch);

        // Convert to DTO
        assertNotNull(dto);
        assertEquals(branch.getBranchID(), dto.getBranchID());
        assertEquals(dto.getBranchName(), dto.getBranchName());
        assertEquals(dto.getBranchPostCode(), dto.getBranchPostCode());
        
        //Convert back to entity
        BranchEntity entity = branchMapper.toEntity(dto);
        assertNotNull(entity);
        assertEquals(dto.getBranchID(), entity.getBranchID());
        assertEquals(dto.getBranchName(), entity.getBranchName());
        assertEquals(dto.getBranchPostCode(), entity.getBranchPostCode());
    }
}
