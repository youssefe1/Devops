package tn.esprit.spring;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.IEmployeService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeServiceImplTest {
	@Autowired
	IEmployeService es;
	

	@Test
	public void testAddEmploye() {

	Employe e = new Employe("haitham","kossentini","haitham.kossentini@esprit.tn",true,Role.ADMINISTRATEUR);
	es.ajouterEmploye(e);
	
		}
	@Test
	public void testListEmployes() {
	List<Employe> employes = es.getAllEmployes();
	assertThat(employes).size().isGreaterThan(0);
	}
	@Test
	public void testFindEmployeByName() {
		int employes= es.getNombreEmployeJPQL();
	assertThat(employes).isEqualTo(4);
	}


}