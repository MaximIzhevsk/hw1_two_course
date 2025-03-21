package org.skypro.skyshop;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    private String name;


    public Product(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getSearchContentType() {
        return "PRODUCT";
    }
}
