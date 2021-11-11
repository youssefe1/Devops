package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.EmployeRepository;

@Service
public class EmployeService implements IEmployeService {
	
	
	
	@Autowired
	EmployeRepository empRepo;
	@Autowired
	ContratRepository ContratRepository;

	@Override
	public Employe addEmploye(Employe e) {
		
		Employe emp;

		
			emp = empRepo.save(e);
	
		 
		return emp;
	}

	@Override
	public List<Employe> getAllEmploye() {
       
		List<Employe> employees = null;
		
			employees = (List<Employe>) empRepo.findAll();  
		
		return employees; 
		
	}

	@Override
	public Employe updateEmploye(Employe e) {
		
		Employe emp;
			
			 emp = empRepo.save(e);
	 
		return emp;
		
	}

	@Override
	public void deleteEmployeById(String id) {
			
			empRepo.deleteById(Integer.parseInt(id));
	
		
	}

	@Override
	public Employe getEmployebyId(String id) {
		 
		
		return empRepo.findById(Integer.parseInt(id)).orElse(null); 
	}

	@Override
	
	public List<Contrat> getAllContrats() {
		return (List<Contrat>) ContratRepository.findAll();
	}

	public void deleteAllContratJPQL() {
		//empRepo.deleteAllContratJPQL();
	}
	@Transactional
	public void affecterContratAEmploye(int contratId, int employeId) {
		Contrat contratManagedEntity = ContratRepository.findById(contratId).get();
		Employe employeManagedEntity = empRepo.findById(employeId).get();

		contratManagedEntity.setEmploye(employeManagedEntity);
		ContratRepository.save(contratManagedEntity);
		
	}
	public int ajouterContrat(Contrat contrat) {
		ContratRepository.save(contrat);
		return contrat.getReference();
	}
	@Override
	public void deleteContratById(String id) {
			
		ContratRepository.deleteById(Integer.parseInt(id));
	
		
	}

	@Override
	public Object getEmployePrenomById(int i) {
		Employe employeManagedEntity = empRepo.findById(i).get();
		return employeManagedEntity.getPrenom();
	}
	
	public Contrat getContratByID(String id) {
		 
		return ContratRepository.findById(Integer.parseInt(id)).orElse(null); 
		
		
	}
}
