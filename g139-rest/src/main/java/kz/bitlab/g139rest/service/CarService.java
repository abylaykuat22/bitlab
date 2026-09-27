package kz.bitlab.g139rest.service;

import kz.bitlab.g139rest.entity.Car;
import kz.bitlab.g139rest.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public List<Car> getCars() {
        return carRepository.findAll();
    }

    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    public Car editCar(Car car) {
        return carRepository.save(car);
    }

    public void deleteCarById(Long id) throws BadRequestException {
//        // проверить есть ли такая запись
//        getCarById(id);
        if (!carRepository.existsById(id)) {
            throw new BadRequestException("Car not found");
        }

        carRepository.deleteById(id);
    }

    public Car getCarById(Long id) throws BadRequestException {
        return carRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Машина не найдена"));
    }
}
