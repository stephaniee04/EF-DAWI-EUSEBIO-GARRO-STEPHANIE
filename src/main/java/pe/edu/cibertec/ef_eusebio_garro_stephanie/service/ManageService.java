package pe.edu.cibertec.ef_eusebio_garro_stephanie.service;

import pe.edu.cibertec.ef_eusebio_garro_stephanie.dto.CarDetailDto;
import pe.edu.cibertec.ef_eusebio_garro_stephanie.dto.CarDto;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ManageService {
    List<CarDto> getAllCars() throws Exception;

    Optional<CarDto> getAllCarsById(int carId) throws Exception;

    Optional<CarDetailDto> getCarById(int id) throws Exception;

    boolean updateCar(CarDto carDto) throws Exception;

    boolean deleteCarById(int id) throws Exception;

    boolean addCar(CarDetailDto carDetailDto) throws Exception;
}
