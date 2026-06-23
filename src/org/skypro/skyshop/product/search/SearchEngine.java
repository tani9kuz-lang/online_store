package org.skypro.skyshop.product.search;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private List<Searchable> searchables;


    public SearchEngine(int size) {
        this.searchables = new ArrayList<>(size);
    }

    public List<Searchable> search(String searchInput) {
        List<Searchable> result = new ArrayList<>();
        if (searchInput == null || searchInput.isBlank()) {
            return result;
        }

        for (Searchable element : searchables) {
            if (element != null && element.searchTerm().contains(searchInput)) {
                result.add(element);
            }
        }

        return result;


    }

    public void add(Searchable newSearchable) {
        if (newSearchable != null) {
            searchables.add(newSearchable);
        }
    }

    public Searchable findBestMatch(String searchInput) throws BestResultNotFound {
        if (searchInput == null || searchInput.isBlank()) {
            throw new BestResultNotFound("По вашему запросу '" + searchInput + "' ничего не найдено");
        }
        Searchable searchable = null;
        int maxCount = 0;
        for (Searchable s : searchables) {
            int count = 0;
            int index = 0;
            int indexString = s.searchTerm().indexOf(searchInput, index);
            while (indexString != -1) {
                count++;
                index = indexString + searchInput.length();
                indexString = s.searchTerm().indexOf(searchInput, index);
            }
            if (count > maxCount) {
                maxCount = count;
                searchable = s;
            }
        }
        return searchable;
    }

}
