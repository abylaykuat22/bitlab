package kz.bitlab.g139rest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import kz.bitlab.g139rest.entity.Car;
import kz.bitlab.g139rest.service.CarService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
@Tag(name = "API для работы с автомобилями", description = "CRUD операции для cars")
public class CarController {

    private final CarService carService;

    @GetMapping
    @Operation(
            summary = "Возвращает список всех машин",
            description = "Запрос возвращает полный список машин из базы данных. "
                    + "Если происходит ошибка на стороне сервера, возвращается статус 500."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Список машин успешно получен",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Car.class))
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Ошибка на стороне сервера",
                    content = @Content
            )
    })
    public ResponseEntity<List<Car>> getCars() {
        try {
            List<Car> cars = carService.getCars();
            return new ResponseEntity<>(cars, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Возвращает машину по ID"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Машина успешно найдена",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Car.class)
                    )
            ),
            @ApiResponse(
                responseCode = "400",
                description = "Неверный ID"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Ошибка на стороне сервера",
                    content = @Content
            )
    })
    public ResponseEntity<Car> getCar(@PathVariable Long id) {
        try {
            Car car = carService.getCarById(id);
            return new ResponseEntity<>(car, HttpStatus.OK);
        } catch (BadRequestException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    @Operation(summary = "Добавляет новую машину в базу данных")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Машина успешно добавлена",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Car.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Ошибка на стороне сервера",
                    content = @Content
            )
    })
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        try {
            Car newCar = carService.addCar(car);
            return new ResponseEntity<>(newCar, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при добавлении записи");
        }
    }

    @PutMapping
    @Operation(summary = "Редактирует данные машины")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Машина успешно обновлена",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Car.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Ошибка уникальности данных"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Ошибка на стороне сервера",
                    content = @Content
            )
    })
    public ResponseEntity<Car> updateCar(@RequestBody Car car) {
        try {
            Car updatedCar = carService.editCar(car);
            return new ResponseEntity<>(updatedCar, HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удаляет машину по ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Машина успешно удалена"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Неверный ID"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Ошибка на стороне сервера",
                    content = @Content
            )
    })
    public ResponseEntity<?> deleteCar(@PathVariable Long id) {
        try {
            carService.deleteCarById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (BadRequestException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
