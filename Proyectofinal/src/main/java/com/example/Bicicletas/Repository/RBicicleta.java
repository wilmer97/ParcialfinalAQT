package com.example.Bicicletas.Repository;

import com.example.Bicicletas.Model.Bicicleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RBicicleta extends JpaRepository<Bicicleta, Long> {
    List<Bicicleta> findByColor(String color);
}
