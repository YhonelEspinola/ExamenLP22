package com.cibertec.service;

import com.cibertec.interfaceService.IempleadoService;
import com.cibertec.repository.EmpleadoRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Empleado;

@Service
public class EmpleadoService implements IempleadoService{

	@Autowired
	private EmpleadoRepository empleadorepository;
	
	
	@Override
	public List<Empleado> listar() {
		return (List<Empleado>)empleadorepository.findAll();
	}

	@Override
	public Optional<Empleado> listarId(Long id) {
		
		return empleadorepository.findById(id);
	}

	@Override
	public int save(Empleado e) {
		int res=0;
		Empleado empleado=empleadorepository.save(e);
		if(!empleado.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(long id) {
		empleadorepository.deleteById(id);
		
	}

	

}
