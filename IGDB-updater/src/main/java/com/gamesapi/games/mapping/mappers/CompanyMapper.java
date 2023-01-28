package com.gamesapi.games.mapping.mappers;

import com.gamesapi.contract.CompanyDto;
import com.gamesapi.games.mapping.IMapEntities;
import com.gamesapi.model.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper implements IMapEntities<CompanyDto, Company> {
    @Override
    public CompanyDto mapEntity(Company company){
        CompanyDto companyDto = new CompanyDto();
        companyDto.setSourceId(company.getSourceId());
        companyDto.setCountry(company.getCountry());
        companyDto.setDescription(company.getDescription());
        companyDto.setName(company.getName());
        companyDto.setUrl(company.getUrl());
        return companyDto;
    }

    @Override
    public Company mapDto(CompanyDto companyDto){
        Company company = new Company();
        return mapDto(companyDto, company);
    }
    @Override
    public Company mapDto(CompanyDto companyDto, Company company){
        company.setSourceId(companyDto.getSourceId());
        company.setCountry(companyDto.getCountry());
        company.setDescription(companyDto.getDescription());
        company.setName(companyDto.getName());
        company.setUrl(companyDto.getUrl());
        return company;
    }
}
