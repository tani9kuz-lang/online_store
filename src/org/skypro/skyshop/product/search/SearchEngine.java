package org.skypro.skyshop.product.search;

public class SearchEngine {
    private Searchable[] searchables;

    public SearchEngine(int size) {
        this.searchables = new Searchable[size];
    }

    public Searchable[] search(String searchInput) {
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

    public void add(Searchable newSearchable) {
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] == null) {
                searchables[i] = newSearchable;
                break;
            }
        }
    }

    public Searchable findBestMatch(String searchInput) throws BestResultNotFound {
        if (searchInput.isBlank()) {
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
