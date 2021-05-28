package fr.eni.papeterie.dal.jdbc;

public class DAOFactory {
    public static ArticleDAO getArticleDAO(){
        ArticleDAO articleDAO = new ArticleDAOjdbcImpl();
        return articleDAO;
    }
}
