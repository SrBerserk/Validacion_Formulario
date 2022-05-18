package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Estudiante;
//Los valores que me pide son: la entidad y el tipo de dato de su clave primaria

@Repository
public interface IEstudianteDAO extends JpaRepository<Estudiante, Long>{

}
