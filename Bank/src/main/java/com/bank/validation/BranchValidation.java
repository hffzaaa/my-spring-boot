package com.bank.validation;
import com.demo.exceptions.*;

public class BranchValidation {
	private BranchValidation() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
	
	public static void validateBranchName(String branchName) {
        if (branchName == null || branchName.isBlank()) {
            throw new DemoAppException("Branch name cannot be null or blank.");
        }
    }
}
