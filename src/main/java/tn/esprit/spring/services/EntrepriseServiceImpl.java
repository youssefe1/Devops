package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {

	@Autowired
    EntrepriseRepository entrepriseRepoistory;
	@Autowired
	DepartementRepository deptRepoistory;
	
	public int ajouterEntreprise(Entreprise entreprise) {
		entrepriseRepoistory.save(entreprise);
		return entreprise.getId();
	}

	public int ajouterDepartement(Departement dep) {
		deptRepoistory.save(dep);
		return dep.getId();
	}
	
	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		//Le bout Master de cette relation N:1 est departement  
				//donc il faut rajouter l'entreprise a departement 
				// ==> c'est l'objet departement(le master) qui va mettre a jour l'association
				//Rappel : la classe qui contient mappedBy represente le bout Slave
				//Rappel : Dans une relation oneToMany le mappedBy doit etre du cote one.
				Optional<Entreprise> entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId);
				Optional<Departement> depManagedEntity = deptRepoistory.findById(depId);
				if(entrepriseManagedEntity.isPresent() && depManagedEntity.isPresent()){
					Entreprise e = entrepriseManagedEntity.get();
					Departement d = depManagedEntity.get();
				d.setEntreprise(e);
				deptRepoistory.save(d);}
		
	}
	
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		Optional<Entreprise> entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId);
		List<String> depNames = new ArrayList<>();

		if(entrepriseManagedEntity.isPresent() ){
			Entreprise e = entrepriseManagedEntity.get();
		for(Departement dep : e.getDepartements()){
			depNames.add(dep.getName());
		}
		}
		return depNames;
	}

	@Transactional
	public void deleteEntrepriseById(int entrepriseId) {
		Optional<Entreprise> entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId);
		if(entrepriseManagedEntity.isPresent() ){
			 Entreprise e = entrepriseManagedEntity.get();
		entrepriseRepoistory.delete(e);	}
	}

	@Transactional
	public void deleteDepartementById(int depId) {
		Optional<Departement> depManagedEntity = deptRepoistory.findById(depId);
		if(depManagedEntity.isPresent() ){
			 Departement d = depManagedEntity.get();
		deptRepoistory.delete(d);	}
	}


	public Entreprise getEntrepriseById(int entrepriseId) {
		Optional<Entreprise> entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId);
		Entreprise ee = null ;
		if(entrepriseManagedEntity.isPresent() ){
			 Entreprise e = entrepriseManagedEntity.get();
		return ee= e;	}
		return ee;
	}

	@Override
	public List<Entreprise> getAllEntreprises() {
		return (List<Entreprise>) entrepriseRepoistory.findAll();
		
	}

	@Override
	public List<String> getAllEntrepriseNamesJPQL() {
		return entrepriseRepoistory.entreprisename();
		
	}
	public int getNombreEntrepriseJPQL() {
		return entrepriseRepoistory.countent();
	}
	
}
