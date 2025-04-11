package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {

    private List<Searchable> searchables;

    private static final int MAX_SEARCH_RESULTS = 5;
    private static final int DEFAULT_SIZE = 50;
    private static final int NOT_FOUND = -1;

    public SearchEngine(int size) {
        this.searchables = new ArrayList<>(size);
    }

    public SearchEngine() {
        this.searchables = new ArrayList<>();
    }

    public List<Searchable> search(String query) {
        List<Searchable> results = new ArrayList<>();
        String lowerQuery = query.toLowerCase();

        for (Searchable searchable : searchables) {
            if (searchable.getSearchTerm().toLowerCase().contains(lowerQuery)) {
                results.add(searchable);
            }
        }
        return results;
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

//    private int getFreeIndex() {
//        for (int i = 0; i < searchables.length; i++) {
//            if (searchables[i] == null) {
//                return i;
//            }
//        }
//        return NOT_FOUND;
//    }

    public Searchable findMostRelevant(String search) throws BestResultNotFound {

        Searchable mostRelevant = null;
        int maxCount = 0;

        for (Searchable searchable : searchables) {

            if (searchable == null) {
                continue;
            }

            String searchTerm = searchable.getSearchTerm();
            int count = countOccurrences(searchTerm, search);

            if (count > maxCount) {
                maxCount = count;
                mostRelevant = searchable;
            }
        }

        if (mostRelevant == null) {
            throw new BestResultNotFound("Нет подходящих вариантов: " + search);
        }

        return mostRelevant;
    }

    private int countOccurrences(String text, String search) {
        int count = 0;
        int index = 0;

        while ((index = text.indexOf(search, index)) != -1) {
            count++;
            index += search.length();
        }

        return count;
    }


    }
