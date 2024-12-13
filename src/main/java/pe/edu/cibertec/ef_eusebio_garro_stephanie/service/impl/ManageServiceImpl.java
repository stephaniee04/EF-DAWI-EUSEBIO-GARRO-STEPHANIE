package pe.edu.cibertec.ef_eusebio_garro_stephanie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.ef_eusebio_garro_stephanie.dto.CarDetailDto;
import pe.edu.cibertec.ef_eusebio_garro_stephanie.dto.CarDto;
import pe.edu.cibertec.ef_eusebio_garro_stephanie.entity.Car;
import pe.edu.cibertec.ef_eusebio_garro_stephanie.repository.CarRepository;
import pe.edu.cibertec.ef_eusebio_garro_stephanie.service.ManageService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    CarRepository carRepository;


    @Override
    public List<CarDto> getAllCars() throws Exception {

        List<CarDto> cars = new ArrayList<>();
        Iterable<Car> iterable = carRepository.findAll();
        iterable.forEach(car -> {
            CarDto carDto = new CarDto(car.getCarId(),
                    car.getMake(),
                    car.getModel(),
                    car.getLicensePlate(),
                    car.getColor());
            cars.add(carDto);
        });
        return cars;
    }

    public Optional<CarDto> getAllCarsById(int id) throws Exception {

        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car -> new CarDto(car.getCarId(),
                car.getMake(),
                car.getModel(),
                car.getLicensePlate(),
                car.getColor()));
    }


    @Override
    public Optional<CarDetailDto> getCarById(int id) throws Exception {
        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car -> new CarDetailDto(car.getCarId(),
                car.getMake(),
                car.getModel(),
                car.getLicensePlate(),
                car.getOwnerName(),
                car.getOwnerContact(),
                car.getColor()));
    }

    @Override
    public boolean updateCar(CarDto carDto) throws Exception {

        Optional<Car> optional = carRepository.findById(carDto.carId());
        return optional.map(car -> {
            car.setMake(carDto.make());
            car.setModel(carDto.model());
            car.setLicensePlate(carDto.licensePlate());
            car.setColor(carDto.color());
            carRepository.save(car);
            return true;
        }).orElse(false);
    }

    @Override
    public boolean deleteCarById(int id) throws Exception {

        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car -> {
            carRepository.delete(car);
            return true;
        }).orElse(false);
    }

    @Override
    public boolean addCar(CarDetailDto carDetailDto) throws Exception {
        Car car = new Car();
        car.setMake(carDetailDto.make());
        car.setModel(carDetailDto.model());
        car.setLicensePlate(carDetailDto.licensePlate());
        car.setColor(carDetailDto.color());
        car.setOwnerName(carDetailDto.ownerName());
        car.setOwnerContact(carDetailDto.ownerContact());

        carRepository.save(car);
        return true;
    }

}
