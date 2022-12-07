package org.example;

public interface Comparable {
    int getPrice();

    int getYear();

    int getHorsePower();

    void setPrice(int price);

    void setYear(int year);

    void setHorsePower(int horsePower);

    int compareTo(int price, int year, int horsePower);
}
