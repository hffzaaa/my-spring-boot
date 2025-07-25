package com.bank.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BranchDTO {
	
	//c. BranchDTO, BranchMapper and BranchMapperTest.java 
	//Ensure table and column created on DB
	//branchID - Index ID auto generated
	//branchName - length 100 - Not Nullable
	//branchPostCode - length 30 - Not Nullable
	//creationDate - Auto created when insert record - LocalDateTime 

    private Long branchID;
    private String branchName;
    private String branchPostCode;
    private LocalDateTime creationDate;

}
