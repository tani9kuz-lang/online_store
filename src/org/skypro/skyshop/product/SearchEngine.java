package org.skypro.skyshop.product;

import java.security.Provider;

public class SearchEngine {
    private Searchable[] searchables;

    public SearchEngine(int size) {
        this.searchables = new Searchable[size];
    }

    public Searchable[] search (String searchInput) {
        Searchable[] result = new Searchable[5];
        int i = 0;
        for (Searchable element : searchables) {
            if (element != null) {
                if (element.searchTerm().contains(searchInput)) {
                    result[i] = element;
                    i++;

                }
                if (i > 5) {
                    break;
                }
            }
        }
        return result;

    }

    public  void add(Searchable newSearchable){
        for (int i =0; i < searchables.length; i++){
            if (searchables[i] == null){
                searchables[i] = newSearchable;
                break;
            }
        }
    }
}
