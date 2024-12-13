package pe.edu.cibertec.ef_eusebio_garro_stephanie.response;

import pe.edu.cibertec.ef_eusebio_garro_stephanie.dto.CarDetailDto;

public record FindCarByIdResponse(String code,
                                  String error,
                                  CarDetailDto car) {
}
