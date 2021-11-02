package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.*;

public interface IEmployeService {
	
	public Employe addEmploye(Employe e);
	public List<Employe> getAllEmploye();
	public Employe updateEmploye(Employe e);
	public void deleteEmployeById(String id);
	public Employe getEmployebyId(String i);

}
