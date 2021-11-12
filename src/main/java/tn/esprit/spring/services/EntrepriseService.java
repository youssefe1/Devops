package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.IEntrepriseRepository;

@Service
public class EntrepriseService implements IEntrepriseService{
	
	@Autowired
	IEntrepriseRepository entrepriseRepository;
	
	@Autowired
	DepartementRepository departementRepoistory;
	
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
	
	
	
	
	public int ajouterDepartement(Departement departement) {
		departementRepoistory.save(departement);
		return departement.getId();
	}
	
	@Override
	public List<Departement> getAllDepartements() {
		return (List<Departement>) departementRepoistory.findAll();
	}
	
	@Override
	public void deleteDepartementById(String id) {
		departementRepoistory.deleteById(Integer.parseInt(id));
	}
	
	public void deleteAllDepartementJPQL() {
		//empRepo.deleteAllContratJPQL();
	}
	
	public Departement getDepartementByID(String id) {
		return departementRepoistory.findById(Integer.parseInt(id)).orElse(null); 
	}
	
	@Transactional
	public void affecterDepartementAEntreprise(int departementId, long entrepriseId) {
		
		Departement departementManagedEntity = departementRepoistory.findById(departementId).get();
		Entreprise entrepriseManagedEntity = entrepriseRepository.findById(entrepriseId).get();

		departementManagedEntity.setEntreprise(entrepriseManagedEntity);
		departementRepoistory.save(departementManagedEntity);
		
	}	

}
