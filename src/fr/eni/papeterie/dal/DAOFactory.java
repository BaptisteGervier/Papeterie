package fr.eni.papeterie.dal;

import fr.eni.papeterie.dal.jdbc.ArticleDAO;
import fr.eni.papeterie.dal.jdbc.ArticleDAOjdbcImpl;

public class DAOFactory {
    public static ArticleDAO getArticleDAO(){
        ArticleDAO articleDAO = new ArticleDAOjdbcImpl();
        return articleDAO;
    }
}
