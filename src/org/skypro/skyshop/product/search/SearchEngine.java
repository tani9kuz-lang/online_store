package org.skypro.skyshop.product.search;

import java.util.*;

public class SearchEngine {
    private Set<Searchable>  searchables = new HashSet<>();

    public SearchEngine(int size) {
        this.searchables = new HashSet<>(size);
    }

    public Set<Searchable> search(String searchInput) {
        Set<Searchable> result = new TreeSet<>((s1, s2)->{
            // получаем длину названия и сравниваем
            int lengthCompare  = Integer.compare(s2.searchTerm().length(), s1.searchTerm().length());
            if (lengthCompare == 0){
                return s1.searchTerm().compareTo(s2.searchTerm());
            }
            return lengthCompare;
        });
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
