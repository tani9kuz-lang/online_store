package org.skypro.skyshop.product;

public interface Searchable {

    String searchTerm();

    String getOfTypeContent();


    default String getStringRepresentation() {
        return "Имя объекта: " + searchTerm() + " Тип объекта: " + getOfTypeContent();
    }

}
