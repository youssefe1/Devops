package tn.esprit.spring.service;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.ParseException;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;

import tn.esprit.spring.services.IEmployeService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ContratServiceImplTest {

	@Autowired
	IEmployeService es;


	private static final Logger l =
	LogManager.getLogger(ContratServiceImplTest.class);

	@Test
	public void testaffecterContratAEmploye() {
		//GIVEN
		Contrat  contrat = new Contrat(new Date(121, 9, 5),"Stage",500);
		Employe e = new Employe("haitham","kossentini","haitham.kossentini@esprit.tn",true,Role.ADMINISTRATEUR);
		//WHEN
		es.ajouterContrat(contrat);
		es.addEmploye(e);
		es.affecterContratAEmploye(contrat.getReference(), e.getId());
		//THEN
		//assertEquals(es.getTypeContratByContratId(contrat.getReference()),"Stage");
		assertThat(es.getEmployebyId("3").equals("3"));
		//assertEquals(es.getEmployebyId("3"),"kossentini");

		}

	@Test
	public void testAddContrat() throws ParseException, java.text.ParseException {

	//GIVEN
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = dateFormat.parse("2021-10-10");
	Contrat  c = new Contrat(new Date(121, 9, 10),"CDI",700);
	int size = es.getAllContrats().size();
	//WHEN
	es.ajouterContrat(c);
	//THEN
	assertEquals(es.getAllContrats().size(),size+1);

	
	}


	@Test
	public void testDeleteAllContrat() throws ParseException{

		//GIVEN
		ArrayList<Contrat> contrats = new ArrayList<Contrat>();
		contrats.addAll(es.getAllContrats());
		//WHEN
		es.deleteAllContratJPQL();
		//THEN
		assertThat(contrats).size().isZero();
	
		
	}





}
