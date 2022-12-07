package org.example;

public class Car implements Comparable {
    private int price;
    private int year;
    private int horsePower;

    public Car(int price, int year, int horsePower) {
        this.price = price;
        this.year = year;
        this.horsePower = horsePower;
    }

    public int getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setPrice(int price) {
        if (price <= 0)
            return;
        this.price = price;
    }

    public void setYear(int year) {
        if (year < 1900 || year > 2022)
            return;
        this.year = year;
    }

    public void setHorsePower(int horsePower) {
        if (horsePower < 100 || horsePower > 1000)
            return;
        this.horsePower = horsePower;
    }

    public int compareTo(int price, int year, int horsePower) {
        if (price == this.getPrice()) {
            if (year == this.getYear()) {
                return this.getHorsePower() - horsePower;
            } else {
                return year - this.getYear();
            }
        } else {
            return price - this.getPrice();
        }
    }
}

