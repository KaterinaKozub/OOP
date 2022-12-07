package ua.opnu;

import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.GroceryBill;
import ua.opnu.java.inheritance.bill.Item;

public class DiscountBill2 {
    private boolean regularCustomer;
    private GroceryBill discountBill;
    private double totalDiscount;
    private int discountedItemsAmount;
    private  double totalPrice;

    public DiscountBill2(Employee clerk, boolean regularCustomer) {
        discountBill = new GroceryBill(clerk);
        this.regularCustomer = regularCustomer;
    }
    public void add(Item i) {
        discountBill.add(i);
        if (this.regularCustomer && i.getDiscount() > 0) {
            this.totalDiscount += i.getDiscount();
            discountedItemsAmount += 1;
        }
        totalPrice += i.getPrice();
    }

    public double getTotal() {
        return regularCustomer ? discountBill.getTotal() - this.totalDiscount : discountBill.getTotal();
    }

    public int getDiscountCount() {
        return discountedItemsAmount;
    }
    public double getDiscountAmount() {
        return this.totalDiscount;
    }
    public double getDiscountPercent() {
        return (this.getDiscountAmount() / totalPrice) * 100;
    }
    public Employee getClerk() {
        return discountBill.getClerk();
    }
}
