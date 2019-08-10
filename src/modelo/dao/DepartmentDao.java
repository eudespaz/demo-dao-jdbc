package modelo.dao;

import java.util.List;

import modelo.entidades.Departamento;

public interface DepartmentDao {
	
	void insert(Departamento departamento);
	void update(Departamento departamento);
	void delete(Integer id);
	Departamento find (Integer id);
	List<Departamento> lista();

}


