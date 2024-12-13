package pe.edu.cibertec.ef_eusebio_garro_stephanie.response;

import pe.edu.cibertec.ef_eusebio_garro_stephanie.dto.CarDto;
import pe.edu.cibertec.ef_eusebio_garro_stephanie.entity.Car;

public record FindCarsResponse(String code,
                               String error,
                               Iterable<CarDto> cars) {
}
