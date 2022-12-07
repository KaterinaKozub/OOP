import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ua.opnu.DiscountBill;
import ua.opnu.DiscountBill2;
import ua.opnu.MinMaxAccount;
import ua.opnu.Point3D;
import ua.opnu.java.inheritance.account.Credit;
import ua.opnu.java.inheritance.account.Debit;
import ua.opnu.java.inheritance.account.Startup;
import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.Item;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Lab4Test {

    @Nested
    @DisplayName("Tests for the first task")
    class Task1Test {
        @Test
        @DisplayName("Test clerk for constructor 1")
        void test1() {
            DiscountBill bill = new DiscountBill(new Employee("clerk-1"), true);
            String expected = "clerk-1";
            assertEquals(expected, bill.getClerk().getName());
        }

        @Test
        @DisplayName("Test clerk for constructor 2")
        void test2() {
            DiscountBill bill = new DiscountBill(new Employee("clerk-2"), false);
            String expected = "clerk-2";
            assertEquals(expected, bill.getClerk().getName());
        }

        @Test
        @DisplayName("Test getTotal() 1")
        void test3() {
            boolean preferred = false;
            DiscountBill bill = new DiscountBill(new Employee("clerk-1"), preferred);
            bill.add(new Item("candy bar", 1.35, 0.25));

            double expected = 1.35;
            assertEquals(expected, bill.getTotal());
        }

        @Test
        @DisplayName("Test getTotal() 2")
        void test4() {
            boolean preferred = true;
            DiscountBill bill = new DiscountBill(new Employee("clerk-1"), preferred);
            bill.add(new Item("candy bar", 1.35, 0.25));

            double expected = 1.10;
            assertEquals(expected, bill.getTotal());
        }

        @Test
        @DisplayName("Test getTotal() 3")
        void test5() {
            boolean preferred = false;
            DiscountBill bill = new DiscountBill(new Employee("clerk-1"), preferred);
            bill.add(new Item("newspaper", 0.99, 0.0));

            double expected = 0.99;
            assertEquals(expected, bill.getTotal());
        }

        @Test
        @DisplayName("Test getTotal() 4")
        void test6() {
            boolean preferred = true;
            DiscountBill bill = new DiscountBill(new Employee("clerk-1"), preferred);
            bill.add(new Item("newspaper", 0.99, 0.0));

            double expected = 0.99;
            assertEquals(expected, bill.getTotal());
        }

        @Test
        @DisplayName("Test getTotal() 4")
        void test7() {
            boolean preferred = false;
            DiscountBill bill = new DiscountBill(new Employee("clerk-1"), preferred);
            bill.add(new Item("candy bar", 1.35, 0.25));
            bill.add(new Item("toy car", 3.25, 0.50));
            bill.add(new Item("apple", 0.30, 0.05));
            bill.add(new Item("orange", 0.30, 0.05));
            bill.add(new Item("newspaper", 0.99, 0.0));

            double expected = 6.19;
            assertEquals(expected, bill.getTotal());
        }

        @Test
        @DisplayName("Test getTotal() 5")
        void test8() {
            boolean preferred = true;
            DiscountBill bill = new DiscountBill(new Employee("clerk-1"), preferred);
            bill.add(new Item("candy bar", 1.35, 0.25));
            bill.add(new Item("toy car", 3.25, 0.50));
            bill.add(new Item("apple", 0.30, 0.05));
            bill.add(new Item("orange", 0.30, 0.05));
            bill.add(new Item("newspaper", 0.99, 0.0));

            double expected = 5.34;
            assertEquals(expected, bill.getTotal());
        }

        @Test
        @DisplayName("Test getDiscountCount() 1")
        void test9() {
            boolean preferred = false;
            DiscountBill bill = new DiscountBill(new Employee("clerk-1"), preferred);
            bill.add(new Item("antique table", 125.00, 35.50));

            int expected = 0;
            assertEquals(expected, bill.getDiscountCount());
        }

        @Test
        @DisplayName("Test getDiscountCount() 2")
        void test10() {
            boolean preferred = true;
            DiscountBill bill = new DiscountBill(new Employee("clerk-1"), preferred);
            bill.add(new Item("antique table", 125.00, 35.50));

            int expected = 1;
            assertEquals(expected, bill.getDiscountCount());
        }

        @Test
        @DisplayName("Test getDiscountCount() 3")
        void test11() {
            boolean preferred = false;
            DiscountBill bill = new DiscountBill(new Employee("clerk-1"), preferred);
            bill.add(new Item("gift card", 75.00, 0.0));

            int expected = 0;
            assertEquals(expected, bill.getDiscountCount());
        }

        @Test
        @DisplayName("Test getDiscountCount() 4")
        void test12() {
            boolean preferred = true;
            DiscountBill bill = new DiscountBill(new Employee("clerk-1"), preferred);
            bill.add(new Item("gift card", 75.00, 0.0)); // <-- no discount!

            int expected = 0;
            assertEquals(expected, bill.getDiscountCount());
        }

        @Test
        @DisplayName("Test getDiscountCount() 5")
        void test13() {
            boolean preferred = false;
            DiscountBill bill = new DiscountBill(new Employee("clerk-1"), preferred);
            bill.add(new Item("notebook", 3.00, 0.15));
            bill.add(new Item("lemonade", 1.50, 0.0));
            bill.add(new Item("bread", 2.25, 0.35));
            bill.add(new Item("gift card", 75.00, 0.0));
            bill.add(new Item("bagels", 1.30, 0.16));
            bill.add(new Item("antique table", 125.00, 35.50));

            int expected = 0;
            assertEquals(expected, bill.getDiscountCount());
        }

        @Test
        @DisplayName("Test getDiscountCount() 6")
        void test14() {
            boolean preferred = true;
            DiscountBill bill = new DiscountBill(new Employee("clerk-1"), preferred);
            bill.add(new Item("notebook", 3.00, 0.15));
            bill.add(new Item("lemonade", 1.50, 0.0)); // <-- no discount!
            bill.add(new Item("bread", 2.25, 0.35));
            bill.add(new Item("gift card", 75.00, 0.0)); // <-- no discount!
            bill.add(new Item("bagels", 1.30, 0.16));
            bill.add(new Item("antique table", 125.00, 35.50));

            int expected = 4;
            assertEquals(expected, bill.getDiscountCount());
        }

        @Test
        @DisplayName("Test getDiscountAmount() 1")
        void test15() {
            boolean preferred = false;
            DiscountBill bill = new DiscountBill(new Employee("clerk-1"), preferred);
            bill.add(new Item("popcorn", 1.02, 0.12));

            double expected = 0.0;
            assertEquals(expected, bill.getDiscountAmount());
        }

        @Test
        @DisplayName("Test getDiscountAmount() 2")
        void test16() {
            boolean preferred = true;
            DiscountBill bill = new DiscountBill(new Employee("clerk-1"), preferred);
            bill.add(new Item("popcorn", 1.02, 0.12));

            double expected = 0.12;
            assertEquals(expected, bill.getDiscountAmount());
        }

        @Test
        @DisplayName("Test getDiscountAmount() 3")
        void test17() {
            boolean preferred = false;
            DiscountBill bill = new DiscountBill(new Employee("clerk-1"), preferred);
            bill.add(new Item("juice", 1.50, 0.0));

            double expected = 0.0;
            assertEquals(expected, bill.getDiscountAmount());
        }

        @Test
        @DisplayName("Test getDiscountAmount() 4")
        void test18() {
            boolean preferred = true;
            DiscountBill bill = new DiscountBill(new Employee("clerk-1"), preferred);
            bill.add(new Item("juice", 1.50, 0.0));

            double expected = 0.0;
            assertEquals(expected, bill.getDiscountAmount());
        }

        @Test
        @DisplayName("Test getDiscountAmount() 5")
        void test19() {
            boolean preferred = false;
            DiscountBill bill = new DiscountBill(new Employee("clerk-1"), preferred);
            bill.add(new Item("popcorn", 1.02, 0.12));
            bill.add(new Item("marmalade", 3.25, 0.15));
            bill.add(new Item("wristwatch", 67.90, 18.20));
            bill.add(new Item("juice", 1.50, 0.0));

            double expected = 0.0;
            assertEquals(expected, bill.getDiscountAmount());
        }

        @Test
        @DisplayName("Test getDiscountAmount() 6")
        void test20() {
            boolean preferred = true;
            DiscountBill bill = new DiscountBill(new Employee("clerk-1"), preferred);
            bill.add(new Item("popcorn", 1.02, 0.12));
            bill.add(new Item("marmalade", 3.25, 0.15));
            bill.add(new Item("wristwatch", 67.90, 18.20));
            bill.add(new Item("juice", 1.50, 0.0));

            double expected = 18.47;
            assertEquals(expected, bill.getDiscountAmount());
        }

        @Test
        @DisplayName("Test getDiscountPercent() 1")
        void test21() {
            boolean preferred = false;
            DiscountBill bill = new DiscountBill(new Employee("clerk-1"), preferred);
            bill.add(new Item("rice", 3.00, 0.75));

            double expected = 0.0;
            assertEquals(expected, bill.getDiscountPercent());
        }

        @Test
        @DisplayName("Test getDiscountPercent() 2")
        void test22() {
            boolean preferred = true;
            DiscountBill bill = new DiscountBill(new Employee("clerk-1"), preferred);
            bill.add(new Item("rice", 3.00, 0.75));

            double expected = 25.0;
            assertEquals(expected, bill.getDiscountPercent());
        }

        @Test
        @DisplayName("Test getDiscountPercent() 3")
        void test23() {
            boolean preferred = false;
            DiscountBill bill = new DiscountBill(new Employee("clerk-1"), preferred);
            bill.add(new Item("vinegar", 4.18, 0.0));

            double expected = 0.0;
            assertEquals(expected, bill.getDiscountPercent());
        }

        @Test
        @DisplayName("Test getDiscountPercent() 4")
        void test24() {
            boolean preferred = true;
            DiscountBill bill = new DiscountBill(new Employee("clerk-1"), preferred);
            bill.add(new Item("vinegar", 4.18, 0.0));

            double expected = 0.0;
            assertEquals(expected, bill.getDiscountPercent());
        }

        @Test
        @DisplayName("Test getDiscountPercent() 5")
        void test25() {
            boolean preferred = false;
            DiscountBill bill = new DiscountBill(new Employee("clerk-1"), preferred);
            bill.add(new Item("vinegar", 4.18, 0.0));
            bill.add(new Item("soup", 2.50, 0.15));
            bill.add(new Item("rice", 3.0, 0.75));
            bill.add(new Item("coffee", 4.25, 0.25));
            bill.add(new Item("flour", 6.50, 2.25));

            double expected = 0.0;
            assertEquals(expected, bill.getDiscountPercent());
        }

        @Test
        @DisplayName("Test getDiscountPercent() 6")
        void test26() {
            boolean preferred = true;
            DiscountBill bill = new DiscountBill(new Employee("clerk-1"), preferred);
            bill.add(new Item("vinegar", 4.18, 0.0));
            bill.add(new Item("soup", 2.50, 0.15));
            bill.add(new Item("rice", 3.0, 0.75));
            bill.add(new Item("coffee", 4.25, 0.25));
            bill.add(new Item("flour", 6.50, 2.25));

            double expected = 16.6421928536466;
            assertEquals(expected, bill.getDiscountPercent());
        }
    }

    @Nested
    @DisplayName("Tests for the second task")
    class Task2Test {

        @Test
        @DisplayName("Test constructor 1")
        void test1() {
            MinMaxAccount account = new MinMaxAccount(new Startup(150));

            int expected = 150;
            assertEquals(expected, account.getBalance());
        }

        @Test
        @DisplayName("Test constructor 2")
        void test2() {
            MinMaxAccount account = new MinMaxAccount(new Startup(0));

            int expected = 0;
            assertEquals(expected, account.getBalance());
        }

        @Test
        @DisplayName("Test constructor 3")
        void test3() {
            MinMaxAccount account = new MinMaxAccount(new Startup(-300));

            int expected = -300;
            assertEquals(expected, account.getBalance());
        }

        @Test
        @DisplayName("Test getBalance() 1")
        void test4() {
            MinMaxAccount account = new MinMaxAccount(new Startup(0));
            account.debit(new Debit(150));

            int expected = 150;
            assertEquals(expected, account.getBalance());
        }

        @Test
        @DisplayName("Test getBalance() 2")
        void test5() {
            MinMaxAccount account = new MinMaxAccount(new Startup(0));
            account.debit(new Debit(150));
            account.debit(new Debit(300));

            int expected = 450;
            assertEquals(expected, account.getBalance());
        }

        @Test
        @DisplayName("Test getBalance() 3")
        void test6() {
            MinMaxAccount account = new MinMaxAccount(new Startup(0));
            account.debit(new Debit(450));
            account.credit(new Credit(-225));

            int expected = 225;
            assertEquals(expected, account.getBalance());
        }

        @Test
        @DisplayName("Test getBalance() 4")
        void test7() {
            MinMaxAccount account = new MinMaxAccount(new Startup(0));
            account.debit(new Debit(150));
            account.credit(new Credit(-25));
            account.debit(new Debit(75));

            int expected = 200;
            assertEquals(expected, account.getBalance());
        }

        @Test
        @DisplayName("Test getBalance() 5")
        void test8() {
            MinMaxAccount account = new MinMaxAccount(new Startup(0));
            account.debit(new Debit(75));
            account.debit(new Debit(100));
            account.credit(new Credit(-25));

            int expected = 150;
            assertEquals(expected, account.getBalance());
        }

        @Test
        @DisplayName("Test getBalance() 6")
        void test9() {
            MinMaxAccount account = new MinMaxAccount(new Startup(0));
            account.debit(new Debit(150));
            account.credit(new Credit(-75));
            account.debit(new Debit(450));
            account.credit(new Credit(-175));

            int expected = 350;
            assertEquals(expected, account.getBalance());
        }

        @Test
        @DisplayName("Test getBalance() 7")
        void test10() {
            MinMaxAccount account = new MinMaxAccount(new Startup(0));
            account.credit(new Credit(-150));
            account.debit(new Debit(25));
            account.debit(new Debit(75));
            account.credit(new Credit(-300));

            int expected = -350;
            assertEquals(expected, account.getBalance());
        }

        @Test
        @DisplayName("Test getMin() 1")
        void test11() {
            MinMaxAccount account = new MinMaxAccount(new Startup(75));

            int expected = 75;
            assertEquals(expected, account.getMin());
        }

        @Test
        @DisplayName("Test getMin() 2")
        void test12() {
            MinMaxAccount account = new MinMaxAccount(new Startup(300));
            account.credit(new Credit(-150));
            account.debit(new Debit(200));
            account.debit(new Debit(25));
            account.debit(new Debit(250));
            account.credit(new Credit(-150));

            int expected = 150;
            assertEquals(expected, account.getMin());
        }

        @Test
        @DisplayName("Test getMin() 3")
        void test13() {
            MinMaxAccount account = new MinMaxAccount(new Startup(-300));
            account.debit(new Debit(150));
            account.debit(new Debit(25));
            account.debit(new Debit(125));
            account.debit(new Debit(300));

            int expected = -300;
            assertEquals(expected, account.getMin());
        }

        @Test
        @DisplayName("Test getMin() 4")
        void test14() {
            MinMaxAccount account = new MinMaxAccount(new Startup(150));
            account.debit(new Debit(25));
            account.debit(new Debit(25));
            account.credit(new Credit(-175));
            account.debit(new Debit(600));

            int expected = 25;
            assertEquals(expected, account.getMin());
        }

        @Test
        @DisplayName("Test getMin() 5")
        void test15() {
            MinMaxAccount account = new MinMaxAccount(new Startup(0));
            account.debit(new Debit(25));
            account.debit(new Debit(150));
            account.credit(new Credit(-25));
            account.debit(new Debit(300));

            int expected = 0;
            assertEquals(expected, account.getMin());
        }

        @Test
        @DisplayName("Test getMin() 6")
        void test16() {
            MinMaxAccount account = new MinMaxAccount(new Startup(0));
            account.debit(new Debit(150));
            account.credit(new Credit(-25));
            account.credit(new Credit(-250));
            account.debit(new Debit(300));
            account.credit(new Credit(-150));
            account.debit(new Debit(400));

            int expected = -125;
            assertEquals(expected, account.getMin());
        }

        @Test
        @DisplayName("Test getMax() 1")
        void test17() {
            MinMaxAccount account = new MinMaxAccount(new Startup(75));

            int expected = 75;
            assertEquals(expected, account.getMax());
        }

        @Test
        @DisplayName("Test getMax() 2")
        void test18() {
            MinMaxAccount account = new MinMaxAccount(new Startup(300));
            account.credit(new Credit(-150));
            account.debit(new Debit(200));
            account.debit(new Debit(25));
            account.debit(new Debit(250));
            account.credit(new Credit(-150));

            int expected = 625;
            assertEquals(expected, account.getMax());
        }

        @Test
        @DisplayName("Test getMax() 3")
        void test19() {
            MinMaxAccount account = new MinMaxAccount(new Startup(-300));
            account.debit(new Debit(150));
            account.debit(new Debit(25));
            account.debit(new Debit(125));
            account.debit(new Debit(300));

            int expected = 300;
            assertEquals(expected, account.getMax());
        }

        @Test
        @DisplayName("Test getMax() 4")
        void test20() {
            MinMaxAccount account = new MinMaxAccount(new Startup(150));
            account.debit(new Debit(25));
            account.debit(new Debit(25));
            account.credit(new Credit(-175));
            account.debit(new Debit(600));

            int expected = 625;
            assertEquals(expected, account.getMax());
        }

        @Test
        @DisplayName("Test getMax() 5")
        void test21() {
            MinMaxAccount account = new MinMaxAccount(new Startup(0));
            account.debit(new Debit(25));
            account.debit(new Debit(150));
            account.debit(new Debit(300));
            account.credit(new Credit(-25));

            int expected = 475;
            assertEquals(expected, account.getMax());
        }

        @Test
        @DisplayName("Test getMax() 6")
        void test22() {
            MinMaxAccount account = new MinMaxAccount(new Startup(0));
            account.debit(new Debit(150));
            account.debit(new Debit(300));
            account.credit(new Credit(-150));
            account.debit(new Debit(400));
            account.credit(new Credit(-25));
            account.credit(new Credit(-250));

            int expected = 700;
            assertEquals(expected, account.getMax());
        }
    }

    @Nested
    @DisplayName("Tests for the third task")
    class Task3Test {

        @Test
        @DisplayName("Test constructor 1")
        void test1() {
            Point3D point = new Point3D();

            assertEquals(0, point.getX());
            assertEquals(0, point.getY());
            assertEquals(0, point.getZ());
        }

        @Test
        @DisplayName("Test constructor 2")
        void test2() {
            Point3D point = new Point3D(0, 0, 0);

            assertEquals(0, point.getX());
            assertEquals(0, point.getY());
            assertEquals(0, point.getZ());
        }

        @Test
        @DisplayName("Test constructor 3")
        void test3() {
            Point3D point = new Point3D(1, 1, 1);

            assertEquals(1, point.getX());
            assertEquals(1, point.getY());
            assertEquals(1, point.getZ());
        }

        @Test
        @DisplayName("Test constructor 4")
        void test4() {
            Point3D point = new Point3D(-1, -1, -1);

            assertEquals(-1, point.getX());
            assertEquals(-1, point.getY());
            assertEquals(-1, point.getZ());
        }

        @Test
        @DisplayName("Test setLocation(x, y) 1")
        void test5() {
            Point3D point = new Point3D();
            point.setLocation(1, -1);

            assertEquals(1, point.getX());
            assertEquals(-1, point.getY());
            assertEquals(0, point.getZ());
        }

        @Test
        @DisplayName("Test setLocation(x, y) 2")
        void test6() {
            Point3D point = new Point3D(1, 1, 1);
            point.setLocation(0, -1);

            assertEquals(0, point.getX());
            assertEquals(-1, point.getY());
            assertEquals(0, point.getZ());
        }

        @Test
        @DisplayName("Test setLocation(x, y, z) 1")
        void test7() {
            Point3D point = new Point3D(0, 0, 0);
            point.setLocation(1, 0, 0);

            assertEquals(1, point.getX());
            assertEquals(0, point.getY());
            assertEquals(0, point.getZ());
        }

        @Test
        @DisplayName("Test setLocation(x, y, z) 2")
        void test8() {
            Point3D point = new Point3D(1, 0, 0);
            point.setLocation(0, -1, 0);

            assertEquals(0, point.getX());
            assertEquals(-1, point.getY());
            assertEquals(0, point.getZ());
        }

        @Test
        @DisplayName("Test setLocation(x, y, z) 3")
        void test9() {
            Point3D point = new Point3D(0, -1, 0);
            point.setLocation(0, 0, 3);

            assertEquals(0, point.getX());
            assertEquals(0, point.getY());
            assertEquals(3, point.getZ());
        }

        @Test
        @DisplayName("Test setLocation(x, y, z) 4")
        void test10() {
            Point3D point = new Point3D(0, 0, 3);
            point.setLocation(0, 0, 0);

            assertEquals(0, point.getX());
            assertEquals(0, point.getY());
            assertEquals(0, point.getZ());
        }

        @Test
        @DisplayName("Test getXYZ() 1")
        void test11() {
            Point3D point = new Point3D(-3, 6, 3);

            assertEquals(-3, point.getX());
            assertEquals(6, point.getY());
            assertEquals(3, point.getZ());
        }

        @Test
        @DisplayName("Test distanceFromOrigin() 1")
        void test12() {
            Point3D point = new Point3D(0, 0, 0);

            double expected = 0.0;
            assertEquals(expected, point.distanceFromOrigin());
        }

        @Test
        @DisplayName("Test distanceFromOrigin() 2")
        void test13() {
            Point3D point = new Point3D(1, 0, 0);

            double expected = 1.0;
            assertEquals(expected, point.distanceFromOrigin());
        }

        @Test
        @DisplayName("Test distanceFromOrigin() 3")
        void test14() {
            Point3D point = new Point3D(1, -1, 0);

            double expected = 1.4142135623730951;
            assertEquals(expected, point.distanceFromOrigin());
        }

        @Test
        @DisplayName("Test distanceFromOrigin() 4")
        void test15() {
            Point3D point = new Point3D(-2, 2, 1);

            double expected = 3.0;
            assertEquals(expected, point.distanceFromOrigin());
        }

        @Test
        @DisplayName("Test distanceFromOrigin() 5")
        void test16() {
            Point3D point = new Point3D(3, 3, 3);

            double expected = 5.196152422706632;
            assertEquals(expected, point.distanceFromOrigin());
        }
    }

    @Nested
    @DisplayName("Tests for the fourth task")
    class Task4Test {
        @Test
        @DisplayName("Test clerk for constructor 1")
        void test1() {
            DiscountBill2 bill = new DiscountBill2(new Employee("clerk-1"), true);
            String expected = "clerk-1";
            assertEquals(expected, bill.getClerk().getName());
        }

        @Test
        @DisplayName("Test clerk for constructor 2")
        void test2() {
            DiscountBill2 bill = new DiscountBill2(new Employee("clerk-2"), false);
            String expected = "clerk-2";
            assertEquals(expected, bill.getClerk().getName());
        }

        @Test
        @DisplayName("Test getTotal() 1")
        void test3() {
            boolean preferred = false;
            DiscountBill2 bill = new DiscountBill2(new Employee("clerk-1"), preferred);
            bill.add(new Item("candy bar", 1.35, 0.25));

            double expected = 1.35;
            assertEquals(expected, bill.getTotal());
        }

        @Test
        @DisplayName("Test getTotal() 2")
        void test4() {
            boolean preferred = true;
            DiscountBill2 bill = new DiscountBill2(new Employee("clerk-1"), preferred);
            bill.add(new Item("candy bar", 1.35, 0.25));

            double expected = 1.10;
            assertEquals(expected, bill.getTotal());
        }

        @Test
        @DisplayName("Test getTotal() 3")
        void test5() {
            boolean preferred = false;
            DiscountBill2 bill = new DiscountBill2(new Employee("clerk-1"), preferred);
            bill.add(new Item("newspaper", 0.99, 0.0));

            double expected = 0.99;
            assertEquals(expected, bill.getTotal());
        }

        @Test
        @DisplayName("Test getTotal() 4")
        void test6() {
            boolean preferred = true;
            DiscountBill2 bill = new DiscountBill2(new Employee("clerk-1"), preferred);
            bill.add(new Item("newspaper", 0.99, 0.0));

            double expected = 0.99;
            assertEquals(expected, bill.getTotal());
        }

        @Test
        @DisplayName("Test getTotal() 4")
        void test7() {
            boolean preferred = false;
            DiscountBill2 bill = new DiscountBill2(new Employee("clerk-1"), preferred);
            bill.add(new Item("candy bar", 1.35, 0.25));
            bill.add(new Item("toy car", 3.25, 0.50));
            bill.add(new Item("apple", 0.30, 0.05));
            bill.add(new Item("orange", 0.30, 0.05));
            bill.add(new Item("newspaper", 0.99, 0.0));

            double expected = 6.19;
            assertEquals(expected, bill.getTotal());
        }

        @Test
        @DisplayName("Test getTotal() 5")
        void test8() {
            boolean preferred = true;
            DiscountBill2 bill = new DiscountBill2(new Employee("clerk-1"), preferred);
            bill.add(new Item("candy bar", 1.35, 0.25));
            bill.add(new Item("toy car", 3.25, 0.50));
            bill.add(new Item("apple", 0.30, 0.05));
            bill.add(new Item("orange", 0.30, 0.05));
            bill.add(new Item("newspaper", 0.99, 0.0));

            double expected = 5.34;
            assertEquals(expected, bill.getTotal());
        }

        @Test
        @DisplayName("Test getDiscountCount() 1")
        void test9() {
            boolean preferred = false;
            DiscountBill2 bill = new DiscountBill2(new Employee("clerk-1"), preferred);
            bill.add(new Item("antique table", 125.00, 35.50));

            int expected = 0;
            assertEquals(expected, bill.getDiscountCount());
        }

        @Test
        @DisplayName("Test getDiscountCount() 2")
        void test10() {
            boolean preferred = true;
            DiscountBill2 bill = new DiscountBill2(new Employee("clerk-1"), preferred);
            bill.add(new Item("antique table", 125.00, 35.50));

            int expected = 1;
            assertEquals(expected, bill.getDiscountCount());
        }

        @Test
        @DisplayName("Test getDiscountCount() 3")
        void test11() {
            boolean preferred = false;
            DiscountBill2 bill = new DiscountBill2(new Employee("clerk-1"), preferred);
            bill.add(new Item("gift card", 75.00, 0.0));

            int expected = 0;
            assertEquals(expected, bill.getDiscountCount());
        }

        @Test
        @DisplayName("Test getDiscountCount() 4")
        void test12() {
            boolean preferred = true;
            DiscountBill2 bill = new DiscountBill2(new Employee("clerk-1"), preferred);
            bill.add(new Item("gift card", 75.00, 0.0)); // <-- no discount!

            int expected = 0;
            assertEquals(expected, bill.getDiscountCount());
        }

        @Test
        @DisplayName("Test getDiscountCount() 5")
        void test13() {
            boolean preferred = false;
            DiscountBill2 bill = new DiscountBill2(new Employee("clerk-1"), preferred);
            bill.add(new Item("notebook", 3.00, 0.15));
            bill.add(new Item("lemonade", 1.50, 0.0));
            bill.add(new Item("bread", 2.25, 0.35));
            bill.add(new Item("gift card", 75.00, 0.0));
            bill.add(new Item("bagels", 1.30, 0.16));
            bill.add(new Item("antique table", 125.00, 35.50));

            int expected = 0;
            assertEquals(expected, bill.getDiscountCount());
        }

        @Test
        @DisplayName("Test getDiscountCount() 6")
        void test14() {
            boolean preferred = true;
            DiscountBill2 bill = new DiscountBill2(new Employee("clerk-1"), preferred);
            bill.add(new Item("notebook", 3.00, 0.15));
            bill.add(new Item("lemonade", 1.50, 0.0)); // <-- no discount!
            bill.add(new Item("bread", 2.25, 0.35));
            bill.add(new Item("gift card", 75.00, 0.0)); // <-- no discount!
            bill.add(new Item("bagels", 1.30, 0.16));
            bill.add(new Item("antique table", 125.00, 35.50));

            int expected = 4;
            assertEquals(expected, bill.getDiscountCount());
        }

        @Test
        @DisplayName("Test getDiscountAmount() 1")
        void test15() {
            boolean preferred = false;
            DiscountBill2 bill = new DiscountBill2(new Employee("clerk-1"), preferred);
            bill.add(new Item("popcorn", 1.02, 0.12));

            double expected = 0.0;
            assertEquals(expected, bill.getDiscountAmount());
        }

        @Test
        @DisplayName("Test getDiscountAmount() 2")
        void test16() {
            boolean preferred = true;
            DiscountBill2 bill = new DiscountBill2(new Employee("clerk-1"), preferred);
            bill.add(new Item("popcorn", 1.02, 0.12));

            double expected = 0.12;
            assertEquals(expected, bill.getDiscountAmount());
        }

        @Test
        @DisplayName("Test getDiscountAmount() 3")
        void test17() {
            boolean preferred = false;
            DiscountBill2 bill = new DiscountBill2(new Employee("clerk-1"), preferred);
            bill.add(new Item("juice", 1.50, 0.0));

            double expected = 0.0;
            assertEquals(expected, bill.getDiscountAmount());
        }

        @Test
        @DisplayName("Test getDiscountAmount() 4")
        void test18() {
            boolean preferred = true;
            DiscountBill2 bill = new DiscountBill2(new Employee("clerk-1"), preferred);
            bill.add(new Item("juice", 1.50, 0.0));

            double expected = 0.0;
            assertEquals(expected, bill.getDiscountAmount());
        }

        @Test
        @DisplayName("Test getDiscountAmount() 5")
        void test19() {
            boolean preferred = false;
            DiscountBill2 bill = new DiscountBill2(new Employee("clerk-1"), preferred);
            bill.add(new Item("popcorn", 1.02, 0.12));
            bill.add(new Item("marmalade", 3.25, 0.15));
            bill.add(new Item("wristwatch", 67.90, 18.20));
            bill.add(new Item("juice", 1.50, 0.0));

            double expected = 0.0;
            assertEquals(expected, bill.getDiscountAmount());
        }

        @Test
        @DisplayName("Test getDiscountAmount() 6")
        void test20() {
            boolean preferred = true;
            DiscountBill2 bill = new DiscountBill2(new Employee("clerk-1"), preferred);
            bill.add(new Item("popcorn", 1.02, 0.12));
            bill.add(new Item("marmalade", 3.25, 0.15));
            bill.add(new Item("wristwatch", 67.90, 18.20));
            bill.add(new Item("juice", 1.50, 0.0));

            double expected = 18.47;
            assertEquals(expected, bill.getDiscountAmount());
        }

        @Test
        @DisplayName("Test getDiscountPercent() 1")
        void test21() {
            boolean preferred = false;
            DiscountBill2 bill = new DiscountBill2(new Employee("clerk-1"), preferred);
            bill.add(new Item("rice", 3.00, 0.75));

            double expected = 0.0;
            assertEquals(expected, bill.getDiscountPercent());
        }

        @Test
        @DisplayName("Test getDiscountPercent() 2")
        void test22() {
            boolean preferred = true;
            DiscountBill2 bill = new DiscountBill2(new Employee("clerk-1"), preferred);
            bill.add(new Item("rice", 3.00, 0.75));

            double expected = 25.0;
            assertEquals(expected, bill.getDiscountPercent());
        }

        @Test
        @DisplayName("Test getDiscountPercent() 3")
        void test23() {
            boolean preferred = false;
            DiscountBill2 bill = new DiscountBill2(new Employee("clerk-1"), preferred);
            bill.add(new Item("vinegar", 4.18, 0.0));

            double expected = 0.0;
            assertEquals(expected, bill.getDiscountPercent());
        }

        @Test
        @DisplayName("Test getDiscountPercent() 4")
        void test24() {
            boolean preferred = true;
            DiscountBill2 bill = new DiscountBill2(new Employee("clerk-1"), preferred);
            bill.add(new Item("vinegar", 4.18, 0.0));

            double expected = 0.0;
            assertEquals(expected, bill.getDiscountPercent());
        }

        @Test
        @DisplayName("Test getDiscountPercent() 5")
        void test25() {
            boolean preferred = false;
            DiscountBill2 bill = new DiscountBill2(new Employee("clerk-1"), preferred);
            bill.add(new Item("vinegar", 4.18, 0.0));
            bill.add(new Item("soup", 2.50, 0.15));
            bill.add(new Item("rice", 3.0, 0.75));
            bill.add(new Item("coffee", 4.25, 0.25));
            bill.add(new Item("flour", 6.50, 2.25));

            double expected = 0.0;
            assertEquals(expected, bill.getDiscountPercent());
        }

        @Test
        @DisplayName("Test getDiscountPercent() 6")
        void test26() {
            boolean preferred = true;
            DiscountBill2 bill = new DiscountBill2(new Employee("clerk-1"), preferred);
            bill.add(new Item("vinegar", 4.18, 0.0));
            bill.add(new Item("soup", 2.50, 0.15));
            bill.add(new Item("rice", 3.0, 0.75));
            bill.add(new Item("coffee", 4.25, 0.25));
            bill.add(new Item("flour", 6.50, 2.25));

            double expected = 16.6421928536466;
            assertEquals(expected, bill.getDiscountPercent());
        }
    }
}
