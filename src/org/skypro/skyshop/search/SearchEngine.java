package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.*;

public class SearchEngine {

    private Collection<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new ArrayList<>();
    }

    public Map<String, Searchable> search(String query) {
        Map<String, Searchable> result = new TreeMap<>(); // используем TreeMap для автоматической сортировки

        for (Searchable searchable : searchables) { // проходим по каждому объекту
            if (searchable.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                result.put(searchable.getName(), searchable); // добавляем подходящий объект в карту
            }
        }

        return result;
    }


    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

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
