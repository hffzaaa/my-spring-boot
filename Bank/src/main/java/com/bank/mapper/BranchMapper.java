package com.bank.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.bank.entity.BranchEntity;
//import com.bank.entity.AccountEntity;
//import com.bank.entity.ProductEntity;
import com.bank.model.BranchDTO;

@Mapper
public interface BranchMapper {
	
//	@Mapping(source = "accountEntity", target = "accountDTO")
//	@Mapping(source = "customerEntity", target = "customerDTO")
//	@Mapping(source = "productEntity", target = "productDTO")
	
	BranchDTO toDto(BranchEntity entity);
	
//	@Mapping(source = "accountDTO", target = "accountEntity")
//	@Mapping(source = "customerDTO", target = "customerEntity")
//	@Mapping(source = "productDTO", target = "productEntity")
	BranchEntity toEntity(BranchDTO dto);
	
    List<BranchDTO> toDtoList(List<BranchEntity> entityList);

    List<BranchEntity> toEntityList(List<BranchDTO> dtoList);
}