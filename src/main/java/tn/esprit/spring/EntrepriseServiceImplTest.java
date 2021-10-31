package tn.esprit.spring;




import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.IEntrepriseService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseServiceImplTest {
	@Autowired
	IEntrepriseService es;
	

	@Test
	public void testAddEntreprise() {
	Entreprise e  = new Entreprise("WEMANAGE","ETUDIANT");
	es.ajouterEntreprise(e);
	}
	
	@Test
	public void testListEntreprise() {
//	List<Entreprise> entreprise = es.getAllEntreprises();
	
//	assertThat(entreprise).size().isGreaterThan(0);
	}
	
	@Test
	public void testFindEntrepriseByName() {
//		int entreprise= es.getNombreEntrepriseJPQL();
//	assertThat(entreprise).isEqualTo(4);
	}


}