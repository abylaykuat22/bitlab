package com.example.g130trello.controller;

import com.example.g130trello.dto.CountryRequestDto;
import com.example.g130trello.dto.CountryResponseDto;
import com.example.g130trello.exception.EntityNotFoundException;
import com.example.g130trello.exception.EntityUniqueException;
import com.example.g130trello.service.CountryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequiredArgsConstructor
@RequestMapping("/country")
@Tag(name = "CountryController",description = "Api для управления Странами")
public class CountryController {
private final CountryService countryService;


    @GetMapping
    @Operation(summary = "Получение список стран",description = "Возвращает список стран.")
    @ApiResponses(value={
            @ApiResponse(responseCode ="400",description ="Страны не найдены" ),
            @ApiResponse(responseCode = "200",description = "Страны получены успешно",content={
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,schema = @Schema(implementation = CountryResponseDto.class))
            })
    })
    public ResponseEntity<List<CountryResponseDto>> getStudents() {
        try {
            ResponseEntity<List<CountryResponseDto>> tResponseEntity = new ResponseEntity<>(countryService.getCountries(), HttpStatus.OK);
            return tResponseEntity;
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }



    @GetMapping("/{id}")
    @Operation(summary = "Получение страну по ID",description = "Возвращает страну по ID.")
    @ApiResponses(value={
            @ApiResponse(responseCode ="400",description ="Страна не найдена" ),
            @ApiResponse(responseCode = "200",description = "Страна получена успешно",content={
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,schema = @Schema(implementation = CountryResponseDto.class))
            })
    })
    public ResponseEntity<CountryResponseDto> getStudentById(@PathVariable Long id) {
        try {
            ResponseEntity<CountryResponseDto> tResponseEntity = new ResponseEntity<>(countryService.getCountryById(id), HttpStatus.OK);
            return tResponseEntity;
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping
    @Operation(summary = "Добавление страну",description = "Добавляет страну.")
    @ApiResponses(value={
            @ApiResponse(responseCode ="400",description ="Уже есть такой" ),
            @ApiResponse(responseCode = "201",description = "Страна создана успешно",content={
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,schema = @Schema(implementation = CountryRequestDto.class))
            })
    })
    public ResponseEntity<Void> createCountry(CountryRequestDto countryRequestDto) {
        try {
            countryService.createCountry(countryRequestDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (EntityUniqueException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping
    @Operation(summary = "Изменение страну",description = "Изменяет страну.")
    @ApiResponses(value={
            @ApiResponse(responseCode ="400",description ="Страна не найдена чтобы его изменит" ),
            @ApiResponse(responseCode = "200",description = "Страна изменена успешно",content={
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,schema = @Schema(implementation = CountryResponseDto.class))
            })
    })
    public ResponseEntity<CountryResponseDto> updateCountry(CountryResponseDto countryResponseDto) {
        try {
            ResponseEntity<CountryResponseDto> responseDtoResponseEntity= new ResponseEntity<>( countryService.updateCountry(countryResponseDto),HttpStatus.OK);
            return responseDtoResponseEntity;
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @DeleteMapping
    @Operation(summary = "Удаление страну",description = "Удаляет страну.")
    @ApiResponses(value={
            @ApiResponse(responseCode ="400",description ="Страна не найдена" ),
            @ApiResponse(responseCode = "200",description = "Страна удалена успешно",content={
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,schema = @Schema(implementation = CountryResponseDto.class))
            })
    })
    public ResponseEntity<Void> deleteCountry(Long id) {
        try {
            countryService.deleteCountry(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
