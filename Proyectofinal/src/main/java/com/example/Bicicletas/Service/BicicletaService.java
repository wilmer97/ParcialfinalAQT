package com.example.Bicicletas.Service;

import com.example.Bicicletas.InterfaceService.IBicicletaService;
import com.example.Bicicletas.Model.Bicicleta;
import com.example.Bicicletas.Repository.RBicicleta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BicicletaService implements IBicicletaService {

    @Autowired
    private RBicicleta rBicicleta;

    @Override
    public List<Bicicleta> listar(){

        return rBicicleta.findAll();
    }

    @Override
    public Optional<Bicicleta> obtenerPorId(Long id){

        return rBicicleta.findById(id);
    }

    @Override
    public Bicicleta guardar(Bicicleta bicicleta){

        return rBicicleta.save(bicicleta);
    }

    @Override
    public void eliminar(Long id){

        rBicicleta.deleteById(id);
    }
}
