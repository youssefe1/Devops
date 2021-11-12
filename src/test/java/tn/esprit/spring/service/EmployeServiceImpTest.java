package tn.esprit.spring.service;

import java.text.ParseException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.*;
import tn.esprit.spring.services.IEmployeService;
import org.junit.jupiter.api.MethodOrderer.Alphanumeric;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(Alphanumeric.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeServiceImpTest {
	
	@Autowired
	IEmployeService es;
	
	
	@Test
	public void A_1() throws ParseException {
		Employe e = new Employe("kossentini", "haitham", "kossentini.haitham@esprit.tn", "chelba", true, Role.INGENIEUR);
		Employe empCreated = es.addEmploye(e);
	    Assert.assertNotNull(es.getEmployebyId(String.valueOf(empCreated.getId())));
	}
	
	@Test
	public void B_2() {
		List<Employe> employees = es.getAllEmploye(); 
		Assert.assertFalse(employees.isEmpty());
	}
	
	

	@Test
	public void C_3() { 
		Employe employeeRetrieved = es.getEmployebyId("1");
		Assert.assertEquals(1, employeeRetrieved.getId());
				
	}
	
	
	@Test
	public void D_4() throws ParseException   {
		Employe e = new Employe(2,"kossentini", "haitham", "cr7@gmail.com", "chelba12", true, Role.INGENIEUR);
		Employe empUpdated  = es.updateEmploye(e);
		Assert.assertEquals(e.getEmail(), empUpdated.getEmail());

	}

	
	@Test
	public void E_5() {
		es.deleteEmployeById("1");
		Assert.assertNull(es.getEmployebyId("1"));
		
	}
	
	
	
	
}
