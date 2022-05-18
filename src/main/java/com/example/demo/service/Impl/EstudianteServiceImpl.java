package com.example.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IEstudianteDAO;
import com.example.demo.entity.Estudiante;
import com.example.demo.service.IEstudianteService;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteDAO estudianteDAO;
	
	
	@Override
	public void guardar(Estudiante estudiante) {
		estudianteDAO.save(estudiante);
	}


	@Override
	public List<Estudiante> listAllEstudients() {
		return estudianteDAO.findAll();
	}

}
