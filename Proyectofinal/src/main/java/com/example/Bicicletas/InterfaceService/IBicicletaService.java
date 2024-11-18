package com.example.Bicicletas.InterfaceService;

import com.example.Bicicletas.Model.Bicicleta;
import java.util.List;
import java.util.Optional;


public interface IBicicletaService {

    List<Bicicleta> listar();
    Optional<Bicicleta> obtenerPorId(Long id);
    Bicicleta guardar (Bicicleta bicicleta);
    void eliminar(Long id);

}
