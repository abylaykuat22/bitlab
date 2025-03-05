package com.example.g130trello.mapper;

import com.example.g130trello.dto.CountryRequestDto;
import com.example.g130trello.dto.CountryResponseDto;
import com.example.g130trello.entity.Country;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true))
public interface CountryMapper {

    CountryMapper INSTANCE= Mappers.getMapper(CountryMapper.class);


    CountryResponseDto toDto(Country country);
    Country toEntity(CountryRequestDto dto);
    Country toEntityResponse(CountryResponseDto Dto);

}
