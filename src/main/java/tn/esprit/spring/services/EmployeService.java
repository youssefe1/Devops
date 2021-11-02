package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
		
		Employe emp = new Employe();
		try {
		
			emp = empRepo.save(e);
		
			
		}catch (Exception ex){
			
		}
		
		 
		return emp;
	}

	@Override
	public List<Employe> getAllEmploye() {
       
		List<Employe> employees = null;
		
		try {
			
			
			employees = (List<Employe>) empRepo.findAll();  
			for (Employe emp : employees) {
				
			} 
			
		}catch (Exception e) {
			
		}
		
		return employees; 
		
	}

	@Override
	public Employe updateEmploye(Employe e) {
		
		Employe emp = new Employe();
		try {
			
			 emp = empRepo.save(e);
			
			
		}catch (Exception ex){
			
		}
		
		 
		return emp;
		
	}

	@Override
	public void deleteEmployeById(String id) {
		
		try {
			
			empRepo.deleteById(Integer.parseInt(id));
			
			
		}catch (Exception ex){
			
		}
		
		
	}

	@Override
	public Employe getEmployebyId(String id) {
		
		Employe e =  empRepo.findById(Integer.parseInt(id)).orElse(null); 
		
		return e; 
	}

}
