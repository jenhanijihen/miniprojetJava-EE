<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Librairie des livres</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="header.jsp" %>
<p></p>
<div class="container">
<div class="card">
<div class="card-header">
Modification des livres
</div>
<div class="card-body">
<form action="update.do" method="post">
 <div class="form-group">
 <label class="control-label">ID livre :</label>
 <input type="text" name="id" class="form-control" value="${produit.id}"/>
 </div>
 <div class="form-group">
 <label class="control-label">Nom livre :</label>
 <input type="text" name="nom" class="form-control"value="${produit.nom}"/>
 </div>
 <div class="form-group">
 <label class="control-label">Prix :</label>
 <input type="text" name="prix" class="form-control" value="${produit.prix}"/>
 </div>
 <label class="control-label">Categorie :</label>
 <input type="text" name="categorie" class="form-control"value="${produit.categorie}"/>
 </div>
 <label class="control-label">Description :</label>
 <input type="text" name="description" class="form-control"value="${produit.description}"/>
 </div>
 <div>
 <button type="submit" class="btn btn-primary">Modifier</button>
 </div>
</form>
</div>
</div>
</div>
</body>
</html>