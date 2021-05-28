package fr.eni.papeterie.dal.jdbc;

import fr.eni.papeterie.bo.Article;

public interface ArticleDAO {
    void update(Article article);
    void insert(Article article);
    Article selectById(int id);
    void delete(int id);
}
