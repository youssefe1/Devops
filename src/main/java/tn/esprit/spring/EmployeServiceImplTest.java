package tn.esprit.spring;
import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.ParseException;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.services.IEmployeService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeServiceImplTest {
	@Autowired
	IEmployeService es;
	
	private static final Logger l =
	LogManager.getLogger(EmployeServiceImplTest.class);

	@Test
	public void testAddEmploye() throws ParseException {

	Employe e = new Employe("haitham","kossentini","haitham.kossentini@esprit.tn",true,Role.ADMINISTRATEUR);
	assertTrue(e.getRole().equals(Role.ADMINISTRATEUR));
	es.ajouterEmploye(e);
	
		}
	@Test
	public void testListEmployes() {
	List<Employe> employes = (List<Employe>) es.getAllEmployes();
	assertThat(employes).size().isGreaterThan(0);
	}
	@Test
	public void testFindEmployeByName() {
		int employes= es.getNombreEmployeJPQL();
	assertThat(employes).isEqualTo(4);
	}


}