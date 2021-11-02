package tn.esprit.spring.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.EmployeRepository;

@Service
public class EmployeService implements IEmployeService {
	
	
	
	@Autowired
	EmployeRepository empRepo;

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

}
