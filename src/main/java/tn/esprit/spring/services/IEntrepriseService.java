package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;

public interface IEntrepriseService {

	public Entreprise ajouterEntreprise(Entreprise entreprise);
	Entreprise getEntrepriseById(long id);
	void deleteEntreprise(long id);
	Entreprise updateEntreprise(Entreprise entreprise);
	public List<Entreprise> retrieveAllEntreprise();
	public int ajouterDepartement(Departement departement);
	public List<Departement> getAllDepartements();
	public void deleteDepartementById(String id);
	public void deleteAllDepartementJPQL();
	public Departement getDepartementByID(String id);
	public void affecterDepartementAEntreprise(int departementId, long entrepriseId);

}
