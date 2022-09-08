package dao;
import java.util.List;
import entities.Produit;
public class TestDao { 
public static void main(String[] args) {
ProduitDaoImpl pdao= new ProduitDaoImpl(); 
Produit prod= pdao.save(new Produit("mobile legends",00, "mobile game", "mobile game",""));
System.out.println(prod);
List<Produit> prods =pdao.produitsParMC("HP");
for (Produit p : prods) 
System.out.println(p);
}
}