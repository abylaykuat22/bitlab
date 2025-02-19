package com.example.g130migrationpractice.mapper;

import com.example.g130migrationpractice.dto.CountryRequest;
import com.example.g130migrationpractice.dto.CountryResponse;
import com.example.g130migrationpractice.entity.Country;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true))
public interface CountryMapper {

    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    Country toEntity(CountryRequest dto);
    CountryResponse toDto(Country entity);
}
