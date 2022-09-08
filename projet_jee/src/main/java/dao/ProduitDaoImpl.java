package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import metier.SingletonConnection;
import entities.Produit;
public class ProduitDaoImpl implements IProduitDao { 
@Override
public Produit save(Produit p) {
Connection conn=SingletonConnection.getConnection();
try { 
PreparedStatement ps= conn.prepareStatement("INSERT INTO produits(nom,prix,categorie,description) VALUES(?,?,?,?)");
ps.setString(1, p.getNom());
ps.setDouble(2, p.getPrix());
ps.setString(3, p.getCategorie());
ps.setString(4, p.getDescription());
ps.executeUpdate();
PreparedStatement ps2= conn.prepareStatement("SELECT MAX(id) as MAX_ID FROM produits");
ResultSet rs =ps2.executeQuery();
if (rs.next()) {
p.setId(rs.getLong("MAX_ID"));
} 
ps.close();
ps2.close();
} catch (SQLException e) {
e.printStackTrace();
} 
return p;
} 
@Override
public List<Produit> produitsParMC(String mc) {
List<Produit> prods= new ArrayList<Produit>(); 
Connection conn=SingletonConnection.getConnection();
try { 
PreparedStatement ps= conn.prepareStatement("select * from produits where nom LIKE ?");
ps.setString(1, "%"+mc+"%");
ResultSet rs = ps.executeQuery();
while (rs.next()) { 
Produit p = new Produit();
p.setId(rs.getLong("id"));
p.setNom(rs.getString("nom")); 
p.setPrix(rs.getDouble("prix"));
p.setCategorie(rs.getString("categorie"));
p.setDescription(rs.getString("prix"));
prods.add(p);
} 
} catch (SQLException e) {
e.printStackTrace();
} 
return prods; 
} 
@Override
public Produit getProduit(Long id) {
	Connection conn=SingletonConnection.getConnection();
	 Produit p = new Produit(); 
	try { 
	PreparedStatement ps= conn.prepareStatement("select * from produits where id = ?");
	ps.setLong(1, id);
	ResultSet rs = ps.executeQuery();
	if (rs.next()) {
	p.setId(rs.getLong("id"));
	p.setNom(rs.getString("nom"));
	p.setPrix(rs.getDouble("PRIX"));
	p.setCategorie(rs.getString("categorie"));
	p.setDescription(rs.getString("description"));
	
	} 
	} catch (SQLException e) {
	e.printStackTrace();
	}
	return p;
}
@Override
public Produit updateProduit(Produit p) {
	Connection conn=SingletonConnection.getConnection();
	try { 
	PreparedStatement ps= conn.prepareStatement("UPDATE PRODUITS SET NOM=?,PRIX=?,CATEGORIE=?,DESCRIPTION=? WHERE ID=?");
	ps.setString(1, p.getNom());
	ps.setDouble(2, p.getPrix());
	ps.setLong(3, p.getId());
	ps.setString(4, p.getCategorie());
	ps.setString(5, p.getDescription());
	ps.executeUpdate();
	ps.close();
	} catch (SQLException e) {
	e.printStackTrace();
	} 
	return p;
} 
@Override
public void deleteProduit(Long id) {
	Connection conn=SingletonConnection.getConnection();
	try { 
	PreparedStatement ps= conn.prepareStatement("DELETE FROM PRODUITS WHERE ID = ?");
	ps.setLong(1, id);
	ps.executeUpdate();
	ps.close();
	} catch (SQLException e) {
	e.printStackTrace();
	} 
} 
} 
