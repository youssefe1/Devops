package tn.esprit.spring.service;

import java.text.ParseException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.services.IEntrepriseService;
import tn.esprit.spring.entities.Entreprise;



import org.junit.jupiter.api.MethodOrderer.Alphanumeric;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(Alphanumeric.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseServiceImplTest {


	@Autowired
	IEntrepriseService entreprise; 

	@Test
	public void D_4() {
		List<Entreprise> entreprises = entreprise.retrieveAllEntreprise(); 
		Assert.assertFalse(entreprises.isEmpty());
	}

	

	@Test
	public void A_1() throws ParseException {
		Entreprise e = new Entreprise("Empire", "Techno pole");
		Entreprise es = new Entreprise("Access", "lac2");
		
		Entreprise entrepriseAdded = entreprise.ajouterEntreprise(e); 
		
		Assert.assertNotNull(entreprise.getEntrepriseById(entrepriseAdded.getId()));
		System.out.println(entrepriseAdded.getId());
	}
	

	@Test
	public void C_3() throws ParseException   {
		Entreprise e = new Entreprise(2, "Monétique", "Centre Urbain Nord ");
	
		Entreprise entrepriseUpdated  = entreprise.updateEntreprise(e); 
		Assert.assertEquals(e.getRaisonSocial(), entrepriseUpdated.getRaisonSocial());
	}

	
	

	@Test
	public void B_2() {
		Entreprise entrepriseRetrieved = entreprise.getEntrepriseById(1); 
		Entreprise es = entreprise.getEntrepriseById(1);
		Assert.assertEquals(es.getRaisonSocial(), entrepriseRetrieved.getRaisonSocial());
	}
	

	
	
	
	@Test
	public void E_5() {
		entreprise.deleteEntreprise(1);
		Assert.assertNull(entreprise.getEntrepriseById(1));
	}
	
	 

}