package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.IEntrepriseRepository;

@Service
public class EntrepriseService implements IEntrepriseService{
	
	@Autowired
	IEntrepriseRepository entrepriseRepository;
	
	private static final Logger l = LogManager.getLogger(EntrepriseService.class);


	@Override
	public List<Entreprise> retrieveAllEntreprise() {
		
		List<Entreprise> entreprises = null; 
		try {
	
			l.info("In retrieveAllEntreprise() : ");
			entreprises = (List<Entreprise>) entrepriseRepository.findAll();  
			for (Entreprise entreprise : entreprises) {
				l.debug("entreprise +++ : " + entreprise);
			} 
			l.info("Out of retrieveAllEntreprise() : ");
		}catch (Exception e) {
			l.error("Error in retrieveAllEntreprise() : " + e);
		}

		
		return entreprises;
	}

	@Override
	public Entreprise ajouterEntreprise(Entreprise e) {
		Entreprise es = new Entreprise();
		try{
		l.info("In ajouterEntreprise() : ");
		es = entrepriseRepository.save(e);
		l.debug("entreprise : " + es);
		l.info("Out ajouterEntreprise() : ");
		}catch (Exception ex){
			l.error("Error in ajouterEntreprise() : " +ex);
		}
		return es;
	}

	@Override
	public void deleteEntreprise(long id) {
		try{
			l.info("In deleteEntreprise() :" );
			entrepriseRepository.deleteById(id);
			l.info("Out deleteEntreprise() :");
			
		}catch (Exception e){
			l.error("Error in deleteEntreprise() : " +e);
		}		
	}

	@Override
	public Entreprise updateEntreprise(Entreprise e) {
		Entreprise es = new Entreprise();
		try{
		l.info("In ajouterEntreprise() : ");
		es = entrepriseRepository.save(e);
		l.debug("entreprise : " + es);
		}catch (Exception ex){
			l.error("Error in ajouterEntreprise() : " +ex);
		}
		return es;
	}


	@Override
	public Entreprise getEntrepriseById(long id) {
		l.info("in  retrieveEntreprise id = " + id);
		Entreprise c =  entrepriseRepository.findById(id).orElse(null); 
		l.info("entreprise returned : " + c);
		return c; 
	}

}
