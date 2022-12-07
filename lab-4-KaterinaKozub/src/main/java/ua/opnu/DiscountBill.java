package ua.opnu;

import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.GroceryBill;
import ua.opnu.java.inheritance.bill.Item;

public class DiscountBill extends GroceryBill {
    private boolean regularCustomer;
    private double totalDiscount;
    private int discountedItemsAmount;
    private double totalPrice;

    public DiscountBill(Employee clerk, boolean regularCustomer) {
        super(clerk);
        this.regularCustomer = regularCustomer;
    }

    @Override
    public void add(Item i) {
        super.add(i);
        if (this.regularCustomer && i.getDiscount() > 0) {
            this.totalDiscount += i.getDiscount();
            discountedItemsAmount += 1;
        }
        totalPrice += i.getPrice();
    }

    @Override
    public double getTotal() {
        double totalPrice;
        if (regularCustomer) {
            totalPrice = super.getTotal() - this.totalDiscount;
        } else {
            totalPrice = super.getTotal();
        }
        return totalPrice;
    }

    public int getDiscountCount() {
        return discountedItemsAmount;
    }

    public double getDiscountAmount() {
        return this.totalDiscount;
    }

    public double getDiscountPercent() {
        return (this.getDiscountAmount() / super.getTotal()) * 100;
    }
}
