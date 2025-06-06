package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

public class Article implements Searchable {
    private String title;
    private String text;

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return title + "\n" + text;
    }

    @Override
    public String getSearchTerm() {
        return toString();
    }

    @Override
    public String getSearchContentType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return "";
    }
}
