package org.skypro.skyshop.product;

import org.skypro.skyshop.product.search.Searchable;

public class Article implements Searchable {
    private final String titleArticle;
    private final String textArticle;


    public Article(String titleArticle, String textArticle) {
        this.titleArticle = titleArticle;
        this.textArticle = textArticle;
    }

    @Override
    public String toString() {
        return titleArticle + "\n"+ textArticle;
    }

    @Override
    public String searchTerm() {
        return toString();
    }

    @Override
    public String getOfTypeContent() {
        return "ARTICLE";
    }
}


