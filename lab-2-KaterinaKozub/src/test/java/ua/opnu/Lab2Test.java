package ua.opnu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Lab2Test {

    @Nested
    @DisplayName("Tests for TimeSpan task")
    class TimeSpanTest {
        @Test
        @DisplayName("Test constructor for zeroes")
        void test1() {
            TimeSpan span = new TimeSpan(0, 0);
            assertEquals(0, span.getHours());
            assertEquals(0, span.getMinutes());
        }

        @Test
        @DisplayName("Test constructor for invalid arguments 1")
        void test2() {
            TimeSpan span = new TimeSpan(-1, 0);
            assertEquals(0, span.getHours());
            assertEquals(0, span.getMinutes());
        }

        @Test
        @DisplayName("Test constructor for invalid arguments 2")
        void test3() {
            TimeSpan span = new TimeSpan(0, -1);
            assertEquals(0, span.getHours());
            assertEquals(0, span.getMinutes());
        }

        @Test
        @DisplayName("Test constructor for invalid arguments 3")
        void test4() {
            TimeSpan span = new TimeSpan(-1, -1);
            assertEquals(0, span.getHours());
            assertEquals(0, span.getMinutes());
        }

        @Test
        @DisplayName("Test constructor for invalid arguments 4")
        void test5() {
            TimeSpan span = new TimeSpan(0, 60);
            assertEquals(0, span.getHours());
            assertEquals(0, span.getMinutes());
        }

        @Test
        @DisplayName("Test constructor for valid arguments")
        void test6() {
            TimeSpan span = new TimeSpan(1, 59);
            assertEquals(1, span.getHours());
            assertEquals(59, span.getMinutes());
        }

        @Test
        @DisplayName("Test getMinutes() method")
        void test7() {
            TimeSpan span = new TimeSpan(0, 20);
            assertEquals(20, span.getMinutes());
        }

        @Test
        @DisplayName("Test getHours() method")
        void test8() {
            TimeSpan span = new TimeSpan(20, 0);
            assertEquals(20, span.getHours());
        }

        @Test
        @DisplayName("Test getMinutes() and getHours() method ")
        void test9() {
            TimeSpan span = new TimeSpan(20, 20);
            assertEquals(20, span.getMinutes());
            assertEquals(20, span.getHours());
        }

        @Test
        @DisplayName("Test add() method for invalid arguments 1")
        void test10() {
            TimeSpan span = new TimeSpan(2, 20);
            span.add(-1, -1);
            assertEquals(2, span.getHours());
            assertEquals(20, span.getMinutes());
        }

        @Test
        @DisplayName("Test add() method for invalid arguments 2")
        void test11() {
            TimeSpan span = new TimeSpan(2, 20);
            span.add(1, 60);
            assertEquals(2, span.getHours());
            assertEquals(20, span.getMinutes());
        }

        @Test
        @DisplayName("Test add() method for valid arguments 1")
        void test12() {
            TimeSpan span = new TimeSpan(2, 20);
            span.add(1, 20);
            assertEquals(3, span.getHours());
            assertEquals(40, span.getMinutes());
        }

        @Test
        @DisplayName("Test add() method for valid arguments 2")
        void test13() {
            TimeSpan span = new TimeSpan(2, 20);
            span.add(1, 59);
            assertEquals(4, span.getHours());
            assertEquals(19, span.getMinutes());
        }


        @Test
        @DisplayName("Test addTimeSpan() method for valid arguments 1")
        void test16() {
            TimeSpan span = new TimeSpan(2, 20);
            TimeSpan other = new TimeSpan(1, 20);
            span.addTimeSpan(other);
            assertEquals(3, span.getHours());
            assertEquals(40, span.getMinutes());
        }

        @Test
        @DisplayName("Test addTimeSpan() method for valid arguments 2")
        void test17() {
            TimeSpan span = new TimeSpan(2, 20);
            TimeSpan other = new TimeSpan(1, 59);
            span.addTimeSpan(other);
            assertEquals(4, span.getHours());
            assertEquals(19, span.getMinutes());
        }

        @Test
        @DisplayName("Test getTotalHours() method 1")
        void test18() {
            TimeSpan span = new TimeSpan(3, 45);
            double actual = span.getTotalHours();
            assertEquals(3.75, actual);
        }

        @Test
        @DisplayName("Test getTotalHours() method 2")
        void test19() {
            TimeSpan span = new TimeSpan(12, 30);
            double actual = span.getTotalHours();
            assertEquals(12.5, actual);
        }

        @Test
        @DisplayName("Test getTotalHours() method 3")
        void test20() {
            TimeSpan span = new TimeSpan(0, 57);
            double actual = span.getTotalHours();
            assertEquals(0.95, actual);
        }

        @Test
        @DisplayName("Test getTotalMinutes() method 1")
        void test21() {
            TimeSpan span = new TimeSpan(0, 57);
            int actual = span.getTotalMinutes();
            assertEquals(57, actual);
        }

        @Test
        @DisplayName("Test getTotalMinutes() method 2")
        void test22() {
            TimeSpan span = new TimeSpan(1, 57);
            int actual = span.getTotalMinutes();
            assertEquals(117, actual);
        }

        @Test
        @DisplayName("Test getTotalMinutes() method 3")
        void test23() {
            TimeSpan span = new TimeSpan(3, 0);
            int actual = span.getTotalMinutes();
            assertEquals(180, actual);
        }

        @Test
        @DisplayName("Test subtract() method 1")
        void test24() {
            TimeSpan span = new TimeSpan(9, 15);
            TimeSpan other = new TimeSpan(0, 30);
            span.subtract(other);
            assertEquals(8, span.getHours());
            assertEquals(45, span.getMinutes());
        }

        @Test
        @DisplayName("Test subtract() method 2")
        void test25() {
            TimeSpan span = new TimeSpan(6, 55);
            TimeSpan other = new TimeSpan(0, 30);
            span.subtract(other);
            assertEquals(6, span.getHours());
            assertEquals(25, span.getMinutes());
        }

        @Test
        @DisplayName("Test subtract() method 3")
        void test26() {
            TimeSpan span = new TimeSpan(11, 55);
            TimeSpan other = new TimeSpan(4, 10);
            span.subtract(other);
            assertEquals(7, span.getHours());
            assertEquals(45, span.getMinutes());
        }

        @Test
        @DisplayName("Test subtract() method 4")
        void test27() {
            TimeSpan span = new TimeSpan(4, 23);
            TimeSpan other = new TimeSpan(2, 12);
            span.subtract(other);
            assertEquals(2, span.getHours());
            assertEquals(11, span.getMinutes());
        }

        @Test
        @DisplayName("Test subtract() method 5")
        void test28() {
            TimeSpan span = new TimeSpan(0, 59);
            TimeSpan other = new TimeSpan(0, 59);
            span.subtract(other);
            assertEquals(0, span.getHours());
            assertEquals(0, span.getMinutes());
        }

        @Test
        @DisplayName("Test subtract() method 6")
        void test29() {
            TimeSpan span = new TimeSpan(2, 1);
            TimeSpan other = new TimeSpan(0, 0);
            span.subtract(other);
            assertEquals(2, span.getHours());
            assertEquals(1, span.getMinutes());
        }

        @Test
        @DisplayName("Test subtract() method 7")
        void test30() {
            TimeSpan span = new TimeSpan(2, 1);
            TimeSpan other = new TimeSpan(1, 2);
            span.subtract(other);
            assertEquals(0, span.getHours());
            assertEquals(59, span.getMinutes());
        }

        @Test
        @DisplayName("Test subtract() method 8")
        void test31() {
            TimeSpan span = new TimeSpan(2, 1);
            TimeSpan other = new TimeSpan(2, 1);
            span.subtract(other);
            assertEquals(0, span.getHours());
            assertEquals(0, span.getMinutes());
        }

        @Test
        @DisplayName("Test subtract() method with valid arguments 1")
        void test32() {
            TimeSpan span = new TimeSpan(2, 1);
            TimeSpan other = new TimeSpan(2, 2);
            span.subtract(other);
            assertEquals(2, span.getHours());
            assertEquals(1, span.getMinutes());
        }

        @Test
        @DisplayName("Test scale() method 1")
        void test33() {
            TimeSpan span = new TimeSpan(1, 45);
            span.scale(2);
            assertEquals(3, span.getHours());
            assertEquals(30, span.getMinutes());
        }

        @Test
        @DisplayName("Test scale() method 2")
        void test34() {
            TimeSpan span = new TimeSpan(9, 15);
            span.scale(1);
            assertEquals(9, span.getHours());
            assertEquals(15, span.getMinutes());
        }

        @Test
        @DisplayName("Test scale() method 3")
        void test35() {
            TimeSpan span = new TimeSpan(6, 55);
            span.scale(3);
            assertEquals(20, span.getHours());
            assertEquals(45, span.getMinutes());
        }

        @Test
        @DisplayName("Test scale() method 4")
        void test36() {
            TimeSpan span = new TimeSpan(11, 55);
            span.scale(4);
            assertEquals(47, span.getHours());
            assertEquals(40, span.getMinutes());
        }

        @Test
        @DisplayName("Test scale() method 5")
        void test37() {
            TimeSpan span = new TimeSpan(4, 23);
            span.scale(2);
            assertEquals(8, span.getHours());
            assertEquals(46, span.getMinutes());
        }

        @Test
        @DisplayName("Test scale() method 6")
        void test38() {
            TimeSpan span = new TimeSpan(0, 7);
            span.scale(58);
            assertEquals(6, span.getHours());
            assertEquals(46, span.getMinutes());
        }

        @Test
        @DisplayName("Test scale() method 7")
        void test39() {
            TimeSpan span = new TimeSpan(2, 17);
            span.scale(9);
            assertEquals(20, span.getHours());
            assertEquals(33, span.getMinutes());
        }

        @Test
        @DisplayName("Test scale() method 8")
        void test40() {
            TimeSpan span = new TimeSpan(2, 2);
            span.scale(99999999);
            assertEquals(203333331, span.getHours());
            assertEquals(18, span.getMinutes());
        }

        @Test
        @DisplayName("Test scale() method with illegal arguments 1")
         void test41() {
            TimeSpan span = new TimeSpan(2, 2);
            span.scale(0);
            assertEquals(2, span.getHours());
            assertEquals(2, span.getMinutes());
        }

        @Test
        @DisplayName("Test scale() method with illegal arguments 2")
        void test42() {
            TimeSpan span = new TimeSpan(2, 2);
            span.scale(-1);
            assertEquals(2, span.getHours());
            assertEquals(2, span.getMinutes());
        }
    }

    @Nested
    @DisplayName("Tests for BankAccount")
    class BankAccountTest {
        @Test
        @DisplayName("Test deposit with illegal argument 1")
        void test1() {
            BankAccount bankAccount = new BankAccount();
            bankAccount.balance = 100;
            bankAccount.deposit(-1);
            assertEquals(100, bankAccount.balance);
        }

        @Test
        @DisplayName("Test deposit with illegal argument 2")
        void test2() {
            BankAccount bankAccount = new BankAccount();
            bankAccount.balance = 100;
            bankAccount.deposit(0);
            assertEquals(100, bankAccount.balance);
        }

        @Test
        @DisplayName("Test deposit 1")
        void test3() {
            BankAccount bankAccount = new BankAccount();
            bankAccount.balance = 100;
            bankAccount.deposit(100);
            assertEquals(200, bankAccount.balance);
        }

        @Test
        @DisplayName("Test withdraw with illegal argument 1")
        void test4() {
            BankAccount bankAccount = new BankAccount();
            bankAccount.balance = 100;
            bankAccount.transactionFee = 5;
            bankAccount.withdraw(0);
            assertEquals(100, bankAccount.balance);
        }

        @Test
        @DisplayName("Test withdraw with illegal argument 2")
        void test5() {
            BankAccount bankAccount = new BankAccount();
            bankAccount.balance = 100;
            bankAccount.transactionFee = 5;
            bankAccount.withdraw(-1);
            assertEquals(100, bankAccount.balance);
        }

        @Test
        @DisplayName("Test withdraw 1")
        void test6() {
            BankAccount bankAccount = new BankAccount();
            bankAccount.balance = 100;
            bankAccount.transactionFee = 0;
            bankAccount.withdraw(10);
            assertEquals(90, bankAccount.balance);
        }

        @Test
        @DisplayName("Test withdraw 2")
        void test7() {
            BankAccount bankAccount = new BankAccount();
            bankAccount.balance = 100;
            bankAccount.transactionFee = 1;
            bankAccount.withdraw(10);
            assertEquals(89, bankAccount.balance);
        }

        @Test
        @DisplayName("Test withdraw 3")
        void test8() {
            BankAccount bankAccount = new BankAccount();
            bankAccount.balance = 100;
            bankAccount.transactionFee = 5;
            bankAccount.withdraw(10);
            assertEquals(85, bankAccount.balance);
            bankAccount.withdraw(20);
            assertEquals(60, bankAccount.balance);
            bankAccount.withdraw(2);
            assertEquals(53, bankAccount.balance);
        }

        @Test
        @DisplayName("Test withdraw 4")
        void test9() {
            BankAccount bankAccount = new BankAccount();
            bankAccount.balance = 50;
            bankAccount.transactionFee = 6.25;
            boolean actual = bankAccount.withdraw(35);
            assertEquals(8.75, bankAccount.balance);
            assertTrue(actual);
            actual = bankAccount.withdraw(10);
            assertEquals(8.75, bankAccount.balance);
            assertFalse(actual);
            actual = bankAccount.withdraw(1);
            assertEquals(1.5, bankAccount.balance);
            assertTrue(actual);
            actual = bankAccount.withdraw(5);
            assertEquals(1.5, bankAccount.balance);
            assertFalse(actual);
            actual = bankAccount.withdraw(0.5);
            assertEquals(1.5, bankAccount.balance);
            assertFalse(actual);
        }

        @Test
        @DisplayName("Test transfer 1")
        void test10() {
            BankAccount first = new BankAccount();
            first.balance = 100;
            first.transactionFee = 5;

            BankAccount second = new BankAccount();
            second.balance = 200;
            second.transactionFee = 7;

            boolean actual = first.transfer(second, 20);
            assertTrue(actual);
            assertEquals(75, first.balance);
            assertEquals(220, second.balance);
        }

        @Test
        @DisplayName("Test transfer 2")
        void test11() {
            BankAccount first = new BankAccount();
            first.balance = 100;
            first.transactionFee = 5;

            BankAccount second = new BankAccount();
            second.balance = 200;
            second.transactionFee = 7;

            boolean actual = first.transfer(second, -5);
            assertFalse(actual);
            assertEquals(100, first.balance);
            assertEquals(200, second.balance);
        }

        @Test
        @DisplayName("Test transfer 3")
        void test12() {
            BankAccount first = new BankAccount();
            first.balance = 100;
            first.transactionFee = 5;

            BankAccount second = new BankAccount();
            second.balance = 200;
            second.transactionFee = 7;

            boolean actual = first.transfer(second, 0);
            assertFalse(actual);
            assertEquals(100, first.balance);
            assertEquals(200, second.balance);
        }

        @Test
        @DisplayName("Test transfer 4")
        void test13() {
            BankAccount first = new BankAccount();
            first.balance = 100;
            first.transactionFee = 5;

            BankAccount second = new BankAccount();
            second.balance = 200;
            second.transactionFee = 7;

            boolean actual = first.transfer(second, 100);
            assertFalse(actual);
            assertEquals(100, first.balance);
            assertEquals(200, second.balance);
        }

        @Test
        @DisplayName("Test transfer 5")
        void test14() {
            BankAccount first = new BankAccount();
            first.balance = 100;
            first.transactionFee = 5;

            BankAccount second = new BankAccount();
            second.balance = 200;
            second.transactionFee = 7;

            boolean actual = first.transfer(second, 95);
            assertTrue(actual);
            assertEquals(0, first.balance);
            assertEquals(295, second.balance);
        }
    }
}
