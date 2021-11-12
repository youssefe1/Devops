package tn.esprit.spring.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.IEntrepriseService;

@RunWith(SpringRunner.class)
@SpringBootTest

public class DepartementServiceImplTest{

	@Autowired
	IEntrepriseService es;
    
	private static final Logger l = LogManager.getLogger(DepartementServiceImplTest.class);
	
	/*@Test
	public void testnewDep() throws ParseException, java.text.ParseException {
		
		Departement dep = new Departement("informatique");
		
		int size = es.getAllDepartementsNamesByEntreprise(2).size();
		es.ajouterDepartement(dep);
		assertEquals(es.getAllDepartementsNamesByEntreprise(2).size(),size+1);
		}*/
	
	/*@Test
	public void testnewDep() throws ParseException {
		Departement d = new Departement("info");		
		Departement departementAdded = es.ajouterDepartement(d); 
		
		Assert.assertNotNull(es.getAllDepartementsNamesByEntreprise(departementAdded.getId()));
		System.out.println(departementAdded.getId());
	}*/
	
	

	/*@Test
	public void testaffecterdepAEntreprise() {
		
		Departement dep = new Departement("elec");
		es.ajouterDepartement(dep);
		//Entreprise ent =  new Entreprise("M",null);
		es.affecterDepartementAEntreprise(dep.getId(), 2);
		
		assertThat(es.getEntrepriseById(2).equals(2));

		//assertEquals(es.getEntrepriseById(1),dep.getEntreprise());

		}*/
	/*
	@Test
	public void testdelete() {
		es.deleteDepartementById(1);
		Assert.assertNull(es.getAllDepartementsNamesByEntreprise(1));
	}*/
/*
	@Test
	public void testaffecterdepAemp() {
		
		Departement dep = new Departement("F");
		es.ajouterDepartement(dep);
		//Employe emp = new Employe();
		ess.affecterEmployeADepartement(1, dep.getId());
		
		assertEquals(ess.getEmployePrenomById(18),"kossentini");

		}
		*/
	
	
	@Test
	public void testaffecterDepartementAEntreprise() {
		//GIVEN
		Departement  departement = new Departement("gl");
		Entreprise e = new Entreprise("sofrecom","lac");
		//WHEN
		es.ajouterDepartement(departement);
		es.ajouterEntreprise(e);
		es.affecterDepartementAEntreprise(departement.getId(), e.getId());
		//THEN
		assertThat(es.getEntrepriseById(2).equals(2));

		}

	@Test
	public void testAddDep() throws ParseException, java.text.ParseException {
	//GIVEN
	Departement  d = new Departement("bi");
	int size = es.getAllDepartements().size();
	//WHEN
	es.ajouterDepartement(d);
	//THEN
	assertEquals(es.getAllDepartements().size(),size+1);
	}

	@Test
	public void testDeleteAlldep() throws ParseException{
		//GIVEN
		ArrayList<Departement> deps = new ArrayList<Departement>();
		deps.addAll(es.getAllDepartements());
		//WHEN
		es.deleteAllDepartementJPQL();
		//THEN
		assertThat(deps).size().isZero();
	}

}