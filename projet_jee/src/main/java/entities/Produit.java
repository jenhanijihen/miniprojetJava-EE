package entities;
import java.io.Serializable;
@SuppressWarnings("serial")
public class Produit implements Serializable{ 
private Long id; 
private String nom; 
private double prix; 
private String categorie; 
private String description;
private String image;
public Produit() {
super();
} 
public Produit(String nom, double prix,String categorie, String description, String image) {
super();
this.nom=nom;
this.categorie=categorie;
this.description=description;
this.image=image;
this.setPrix(prix); 
}


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public double getPrix() {
	return prix;
}


public void setPrix(double prix) {
	this.prix = prix;
}


public String getCategorie() {
	return categorie;
}


public void setCategorie(String categorie) {
	this.categorie = categorie;
}


public String getDescription() {
	return description;
}


public void setDescription(String description) {
	this.description = description;
}


public String getNom() {
	return nom;
}


public void setNom(String nom) {
	this.nom = nom;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
} 

} 