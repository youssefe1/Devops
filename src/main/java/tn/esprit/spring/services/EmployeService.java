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
	
	private static final Logger l = LogManager.getLogger(EmployeService.class); 
	
	@Autowired
	EmployeRepository empRepo;

	@Override
	public Employe addEmploye(Employe e) {
		
		Employe emp = new Employe();
		try {
			l.info("In addEmployee : ");
			emp = empRepo.save(e);
			l.debug("employee : " + emp);
			l.info("Out of addEmployee() : ");
			
		}catch (Exception ex){
			l.error("Error in addEmployee() : " + ex);
		}
		
		 
		return emp;
	}

	@Override
	public List<Employe> getAllEmploye() {
       
		List<Employe> employees = null;
		
		try {
			
			l.info("In gettingAllEmployees : ");
			employees = (List<Employe>) empRepo.findAll();  
			for (Employe emp : employees) {
				l.debug("employees +++ : " + emp);
			} 
			l.info("Out of getAllEmployees() : ");
		}catch (Exception e) {
			l.error("Error in gettnigAllEmployees() : " + e);
		}
		
		return employees; 
		
	}

	@Override
	public Employe updateEmploye(Employe e) {
		
		Employe emp = new Employe();
		try {
			l.info("In updateEmployee : ");
			 emp = empRepo.save(e);
			l.debug("employee : " + emp);
			l.info("Out of updateEmployee() : ");
			
		}catch (Exception ex){
			l.error("Error in updateEmployee() : " + ex);
		}
		
		 
		return emp;
		
	}

	@Override
	public void deleteEmployeById(String id) {
		
		try {
			l.info("In deleteEmployee : ");
			empRepo.deleteById(Integer.parseInt(id));
			l.info("Out of deleteEmployee() : ");
			
		}catch (Exception ex){
			l.error("Error in deleteEmployee() : " + ex);
		}
		
		
	}

	@Override
	public Employe getEmployebyId(String id) {
		l.info("in  getEmploye id = " + id);
		Employe e =  empRepo.findById(Integer.parseInt(id)).orElse(null); 
		l.info("emp returned : " + e);
		l.info("out  getEmploye id = " + id);
		return e; 
	}

}
