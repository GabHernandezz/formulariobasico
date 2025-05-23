package com.formulariogabriela.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.formulariogabriela.app.entidades.FormularioEntities;

public interface FormularioRepository extends JpaRepository<FormularioEntities, Long> {
}
