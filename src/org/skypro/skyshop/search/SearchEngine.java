package org.skypro.skyshop.search;

public class SearchEngine {

    private Searchable[] searchables;

    private static final int MAX_SEARCH_RESULTS = 5;
    private static final int DEFAULT_SIZE = 50;
    private static final int NOT_FOUND = -1;

    public SearchEngine(int size) {
        this.searchables = new Searchable[size];
    }

    public SearchEngine() {
        this.searchables = new Searchable[DEFAULT_SIZE];
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[MAX_SEARCH_RESULTS];

        int count = 0;
        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.getSearchTerm().contains(query)) {
                results[count++] = searchable;
                if (count >= MAX_SEARCH_RESULTS) {
                    break;
                }
            }
        }
        return results;
    }

    public void add(Searchable searchable) {
        int freeIndex = getFreeIndex();
        if (freeIndex == NOT_FOUND) {
            System.out.println("Невозможно добавить элемент для поиска");
            return;
        }
        searchables[freeIndex] = searchable;
    }

    private int getFreeIndex(){
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] == null) {
                return i;
            }
        }
        return NOT_FOUND;
    }


}
