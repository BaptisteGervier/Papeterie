package fr.eni.papeterie.dal.jdbc;


import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;

import java.sql.*;

public class ArticleDAOjdbcImpl implements ArticleDAO{
    private final String URL = Settings.getPropriete("url");
    private final String SELECT_BY_ID = "SELECT * FROM Articles WHERE idArticle=?";
    private final String SQL_DELETE = "DELETE FROM Articles WHERE idArticle=?";
    private final String SQL_UPDATE = "UPDATE Articles set " +
            "reference=?,marque=?,designation=?,prixUnitaire=?,qteStock=?,grammage=?,couleur=?" +
            "WHERE idArticle=?";
    private final String SQL_INSERT = "INSERT INTO Articles" +
            "(reference, marque,designation,prixUnitaire,qteStock,grammage,couleur,type" +
            "VALUES(?,?,?,?,?,?,?,?);";

    @Override
    public void update(Article article) {
        try {
            Connection connection = JdbcTools.recupConnection();
            PreparedStatement etat = connection.prepareStatement(this.SQL_UPDATE);
            etat.setString(1, article.getReference());
            etat.setString(2, article.getMarque());
            etat.setString(3, article.getDesignation());
            etat.setFloat(4, article.getPrixUnitaire());
            etat.setInt(5, article.getQteStock());
            etat.setInt(8, article.getIdArticle());
            if (article instanceof Stylo) {
                etat.setString(7, ((Stylo) article).getCouleur());
            }
            if (article instanceof Ramette) {
                etat.setInt(6, ((Ramette) article).getGrammage());
            }
            etat.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Override
    public void insert(Article article){
    try (
            Connection connection = JdbcTools.recupConnection();
         PreparedStatement etat = connection.prepareStatement(this.SQL_INSERT)
    ) {
        etat.setString(1, article.getReference());
        etat.setString(2, article.getMarque());
        etat.setString(3, article.getDesignation());
        etat.setFloat(4, article.getPrixUnitaire());
        etat.setInt(5, article.getQteStock());
        if (article instanceof Ramette){
            etat.setInt(6, ((Ramette) article).getGrammage());
        }
        if (article instanceof Stylo){
            etat.setString(7, ((Stylo) article).getCouleur());
        }
        etat.executeUpdate();
        ResultSet rs = etat.getGeneratedKeys(); //je récupère l'id auto généré par la méthode insert
        if (rs.next()){
            int id = rs.getInt(1);
            article.setIdArticle(id); //et je le met dans l'article en utilisant le setter
            //article.setIdArticle(rs.getInt(1));
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}
    @Override
    public Article selectById(int id){
        Article article = null;
        try (
            Connection connection = JdbcTools.recupConnection();
            Statement etat = connection.createStatement()
        ){
            String sql = "SELECT idArticle, reference, marque, designation, prixUnitaire, qteStock, grammage, couleur" +
                    "type FROM Articles WHERE idArticle = " + id + ";";
            ResultSet rs = etat.executeQuery(sql);

            if (rs.next()){
                if (rs.getString("type").trim().equalsIgnoreCase("RAMETTE")){
                    article = new Ramette(
                            rs.getInt("idArticle"),
                            rs.getString("marque"),
                            rs.getString("reference"),
                            rs.getString("designation"),
                            rs.getFloat("prixUnitaire"),
                            rs.getInt("qteStock"),
                            rs.getInt("grammage")
                    );
                }
                if (rs.getString("type").trim().equalsIgnoreCase("STYLO")){
                    article = new Stylo(
                            rs.getInt("idArticle"),
                            rs.getString("marque"),
                            rs.getString("reference"),
                            rs.getString("designation"),
                            rs.getFloat("prixUnitaire"),
                            rs.getInt("qteStock"),
                            rs.getString("couleur")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return article;
    }
    @Override
    public void delete(int id){
        try (Connection connection = JdbcTools.recupConnection()){
                PreparedStatement reqPreparee = connection.prepareStatement(this.SQL_DELETE);
                reqPreparee.setInt(1, id);
                reqPreparee.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
