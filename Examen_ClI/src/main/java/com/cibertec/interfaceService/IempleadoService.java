package com.cibertec.interfaceService;

import java.util.List;

import java.util.Optional;

import com.cibertec.entity.Empleado;

public interface IempleadoService {

	public List<Empleado>listar();
	public Optional<Empleado>listarId(Long id);
	public int save(Empleado E);
	public void delete(long id);
	
}
