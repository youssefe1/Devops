package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;

import tn.esprit.spring.entities.*;

public interface IEmployeService {
	
	public Employe addEmploye(Employe e);
	public List<Employe> getAllEmploye();
	public Employe updateEmploye(Employe e);
	public void deleteEmployeById(String id);
	public Employe getEmployebyId(String i);
	public int ajouterContrat(Contrat contrat);
	public void affecterContratAEmploye(int reference, int i);
	public Object getEmployePrenomById(int i);
	public List<Contrat> getAllContrats();
	public void deleteAllContratJPQL();
	public Contrat getContratByID(String id);
	void deleteContratById(String id);
	

}
