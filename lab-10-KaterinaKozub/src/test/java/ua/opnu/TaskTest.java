package ua.opnu;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    public static Task task;

    @BeforeAll
    static void setup() {
        task = new Task();
    }

    @Nested
    @DisplayName("Tests for the first task")
    class Task1Test {

        @Test
        public void test1() {
            Set<String> src = Set.of("tenletters");
            int actual = task.maxLength(src);

            assertEquals(10, actual);
        }

        @Test
        public void test2() {
            Set<String> src = Set.of("one", "two", "three", "four", "get your person", "on the floor", "gotta gotta get up to get", "down");
            int actual = task.maxLength(src);

            assertEquals(25, actual);
        }

        @Test
        public void test3() {
            Set<String> src = Collections.emptySet();
            int actual = task.maxLength(src);

            assertEquals(0, actual);
        }
    }

    @Nested
    @DisplayName("Tests for the second task")
    class Task2Test {
        @Test
        public void test1() {
            Set<String> actual = Stream.of("foo", "buzz", "bar", "fork", "bort", "spoon", "!", "dude").collect(Collectors.toSet());
            Set<String> expected = Stream.of("!", "bar", "foo", "spoon").collect(Collectors.toSet());
            task.removeEvenLength(actual);

            assertEquals(expected, actual);
        }

        @Test
        public void test2() {
            Set<String> actual = Stream.of("foo", "bar").collect(Collectors.toSet());
            Set<String> expected = Stream.of("foo", "bar").collect(Collectors.toSet());
            Task.removeEvenLength(actual);

            assertEquals(expected, actual);
        }

        @Test
        public void test3() {
            Set<String> actual = Collections.emptySet();
            Set<String> expected = Collections.emptySet();
            Task.removeEvenLength(actual);

            assertEquals(expected, actual);
        }
    }

    @Nested
    @DisplayName("Tests for the third task")
    class Task3Test {

        @Test
        public void test1() {
            List<Integer> list1 = List.of(3, 7, 3, -1, 2, 3, 7, 2, 15, 15);
            List<Integer> list2 = List.of(-5, 15, 2, -1, 7, 15, 36);
            int actual = task.numInCommon(list1, list2);

            assertEquals(4, actual);
        }

        @Test
        public void test2() {
            List<Integer> list1 = List.of(1, 2, 3);
            List<Integer> list2 = List.of(3, 4, 5);
            int actual = task.numInCommon(list1, list2);

            assertEquals(1, actual);
        }

        @Test
        public void test3() {
            List<Integer> list1 = List.of(1, 2, 3);
            List<Integer> list2 = List.of(2);
            int actual = task.numInCommon(list1, list2);

            assertEquals(1, actual);
        }

        @Test
        public void test4() {
            List<Integer> list1 = List.of(4);
            List<Integer> list2 = List.of(1, 2, 3);
            int actual = task.numInCommon(list1, list2);

            assertEquals(0, actual);
        }

        @Test
        public void test5() {
            List<Integer> list1 = Collections.emptyList();
            List<Integer> list2 = Collections.emptyList();
            int actual = task.numInCommon(list1, list2);

            assertEquals(0, actual);
        }
    }

    @Nested
    @DisplayName("Tests for the fourth task")
    class Task4Test {

        @Test
        public void test1() {
            Map<String, String> map = new HashMap<>();
            map.put("Marty", "Stepp");
            map.put("Stuart", "Reges");
            map.put("Jessica", "Miller");
            map.put("Amanda", "Camp");
            map.put("Hal", "Perkins");
            boolean actual = task.isUnique(map);

            assertTrue(actual);
        }

        @Test
        public void test2() {
            Map<String, String> map = new HashMap<>();
            map.put("Kendrick", "Perkins");
            map.put("Stuart", "Reges");
            map.put("Jessica", "Miller");
            map.put("Bruce", "Reges");
            map.put("Hal", "Perkins");
            boolean actual = task.isUnique(map);

            assertFalse(actual);
        }

        @Test
        public void test3() {
            Map<String, String> map = new HashMap<>();
            boolean actual = task.isUnique(map);

            assertTrue(actual);
        }
    }

    @Nested
    @DisplayName("Tests for the fifth task")
    class Task5Test {

        @Test
        public void test1() {
            Map<String, Integer> map1 = new HashMap<>();
            map1.put("Janet", 87);
            map1.put("Logan", 62);
            map1.put("Whitaker", 46);
            map1.put("Alyssa", 100);
            map1.put("Stefanie", 80);
            map1.put("Jeff", 88);
            map1.put("Kim", 52);
            map1.put("Sylvia", 95);

            Map<String, Integer> map2 = new HashMap<>();
            map2.put("Logan", 62);
            map2.put("Kim", 52);
            map2.put("Whitaker", 52);
            map2.put("Jeff", 88);
            map2.put("Stefanie", 80);
            map2.put("Brian", 60);
            map2.put("Lisa", 83);
            map2.put("Sylvia", 87);

            Map<String, Integer> expected = new HashMap<>();
            expected.put("Logan", 62);
            expected.put("Stefanie", 80);
            expected.put("Jeff", 88);
            expected.put("Kim", 52);

            Map<String, Integer> actual = task.intersect(map1, map2);

            assertEquals(expected, actual);
        }

        @Test
        public void test2() {
            Map<String, Integer> map1 = new HashMap<>();
            map1.put("a", 1);
            map1.put("b", 2);
            map1.put("c", 3);
            map1.put("d", 4);

            Map<String, Integer> map2 = new HashMap<>();
            map2.put("b", 2);
            map2.put("c", 5);
            map2.put("d", 4);
            map2.put("e", 4);
            map2.put("f", 1);

            Map<String, Integer> expected = new HashMap<>();
            expected.put("b", 2);
            expected.put("d", 4);

            Map<String, Integer> actual = task.intersect(map1, map2);

            assertEquals(expected, actual);
        }

        @Test
        public void test3() {
            Map<String, Integer> map1 = new HashMap<>();
            map1.put("a", 1);
            map1.put("b", 2);
            map1.put("c", 3);
            map1.put("d", 4);

            Map<String, Integer> map2 = new HashMap<>();
            map2.put("a", 1);
            map2.put("b", 2);
            map2.put("c", 3);
            map2.put("d", 4);

            Map<String, Integer> expected = new HashMap<>();
            expected.put("a", 1);
            expected.put("b", 2);
            expected.put("c", 3);
            expected.put("d", 4);

            Map<String, Integer> actual = task.intersect(map1, map2);

            assertEquals(expected, actual);
        }

        @Test
        public void test4() {
            Map<String, Integer> map1 = new HashMap<>();
            map1.put("a", 1);
            map1.put("b", 2);
            map1.put("c", 3);
            map1.put("d", 4);

            Map<String, Integer> map2 = new HashMap<>();
            map2.put("x", 0);
            map2.put("a", 1);
            map2.put("b", 2);
            map2.put("c", 3);
            map2.put("d", 4);
            map2.put("e", 5);

            Map<String, Integer> expected = new HashMap<>();
            expected.put("a", 1);
            expected.put("b", 2);
            expected.put("c", 3);
            expected.put("d", 4);

            Map<String, Integer> actual = task.intersect(map1, map2);

            assertEquals(expected, actual);
        }

        @Test
        public void test5() {
            Map<String, Integer> map1 = new HashMap<>();
            map1.put("x", 0);
            map1.put("a", 1);
            map1.put("b", 2);
            map1.put("c", 3);
            map1.put("d", 4);
            map1.put("e", 5);

            Map<String, Integer> map2 = new HashMap<>();
            map2.put("a", 1);
            map2.put("b", 2);
            map2.put("c", 3);
            map2.put("d", 4);

            Map<String, Integer> expected = new HashMap<>();
            expected.put("a", 1);
            expected.put("b", 2);
            expected.put("c", 3);
            expected.put("d", 4);

            Map<String, Integer> actual = task.intersect(map1, map2);

            assertEquals(expected, actual);
        }

        @Test
        public void test6() {
            Map<String, Integer> map1 = new HashMap<>();
            map1.put("a", 1);
            map1.put("b", 2);
            map1.put("c", 3);
            map1.put("d", 4);

            Map<String, Integer> map2 = new HashMap<>();
            map2.put("a", 5);
            map2.put("b", 6);
            map2.put("c", 7);
            map2.put("d", 8);

            Map<String, Integer> expected = new HashMap<>();
            Map<String, Integer> actual = task.intersect(map1, map2);

            assertEquals(expected, actual);
        }

        @Test
        public void test7() {
            Map<String, Integer> map1 = new HashMap<>();
            map1.put("a", 1);
            map1.put("b", 2);

            Map<String, Integer> map2 = new HashMap<>();

            Map<String, Integer> expected = new HashMap<>();
            Map<String, Integer> actual = task.intersect(map1, map2);

            assertEquals(expected, actual);
        }

        @Test
        public void test8() {
            Map<String, Integer> map1 = new HashMap<>();

            Map<String, Integer> map2 = new HashMap<>();
            map2.put("a", 1);

            Map<String, Integer> expected = new HashMap<>();
            Map<String, Integer> actual = task.intersect(map1, map2);

            assertEquals(expected, actual);
        }
    }

    @Nested
    @DisplayName("Tests for the sixth task")
    class Task6Test {

        @Test
        public void test1() {
            Map<Integer, String> map = new TreeMap<>();
            map.put(42, "Marty");
            map.put(81, "Sue");
            map.put(17, "Ed");
            map.put(31, "Dave");
            map.put(56, "Ed");
            map.put(3, "Marty");
            map.put(29, "Ed");

            Map<String, Integer> expected = new TreeMap<>();
            expected.put("Sue", 81);
            expected.put("Marty", 42);
            expected.put("Dave", 31);
            expected.put("Ed", 56);

            Map<String, Integer> actual = task.reverse(map);

            assertEquals(expected, actual);
        }

        @Test
        public void test2() {
            Map<Integer, String> map = new HashMap<>();
            map.put(13, "King");
            map.put(12, "Queen");
            map.put(11, "Jack");
            map.put(1, "Ace");

            Map<String, Integer> expected = new HashMap<>();
            expected.put("Ace", 1);
            expected.put("King", 13);
            expected.put("Queen", 12);
            expected.put("Jack", 11);

            Map<String, Integer> actual = task.reverse(map);

            assertEquals(expected, actual);
        }

        @Test
        public void test3() {
            Map<Integer, String> map = new HashMap<>();
            map.put(1, "John");
            map.put(25, "John");
            map.put(47, "John");
            map.put(13, "John");
            map.put(0, "Smith");

            Map<String, Integer> expected = new HashMap<>();
            expected.put("Smith", 0);
            expected.put("John", 47);

            Map<String, Integer> actual = task.reverse(map);

            assertEquals(expected, actual);
        }

        @Test
        public void test4() {
            Map<Integer, String> map = new HashMap<>();

            Map<String, Integer> expected = new HashMap<>();
            Map<String, Integer> actual = task.reverse(map);

            assertEquals(expected, actual);
        }
    }

    @Nested
    @DisplayName("Tests for the seventh task")
    class Task7Test {

        @Test
        public void test1() {
            Map<String, Integer> map = new TreeMap<>();
            map.put("Alyssa", 22);
            map.put("Char", 25);
            map.put("Dan", 25);
            map.put("Jeff", 20);
            map.put("Kasey", 20);
            map.put("Kim", 20);
            map.put("Morgan", 25);
            map.put("Ryan", 25);
            map.put("Stef", 22);

            int actual = task.rarest(map);

            assertEquals(22, actual);
        }

        @Test
        public void test2() {
            Map<String, Integer> map = new TreeMap<>();
            map.put("Alyssa", 22);
            map.put("Char", 25);
            map.put("Dan", 25);
            map.put("Jeff", 20);
            map.put("Kasey", 20);
            map.put("Kim", 20);
            map.put("Morgan", 25);
            map.put("Ryan", 25);
            map.put("Stef", 22);
            map.put("Kelly", 22);

            int actual = task.rarest(map);

            assertEquals(20, actual);
        }

        @Test
        public void test3() {
            Map<String, Integer> map = new TreeMap<>();
            map.put("Alyssa", 21);
            map.put("Char", 21);
            map.put("Dan", 21);
            map.put("Jeff", 21);
            map.put("Kasey", 21);
            map.put("Kim", 21);
            map.put("Morgan", 21);
            map.put("Ryan", 21);
            map.put("Stef", 21);

            int actual = task.rarest(map);

            assertEquals(21, actual);
        }

        @Test
        public void test4() {
            Map<String, Integer> map = new TreeMap<>();
            map.put("Marty", 40);
            map.put("Stuart", 50);

            int actual = task.rarest(map);

            assertEquals(40, actual);
        }

        @Test
        public void test5() {
            Map<String, Integer> map = new TreeMap<>();
            map.put("Alyssa", 40);

            int actual = task.rarest(map);
            assertEquals(40, actual);
        }
    }

    @Nested
    @DisplayName("Tests for the eights task")
    class Task8Test {

        @Test
        public void test1() {
            List<Integer> list1 = List.of(1, 1, 2, 3, 4);

            int actual = task.maxOccurrences(list1);

            assertEquals(2, actual);
        }

        @Test
        public void test2() {
            List<Integer> list1 = List.of(5, 6, 5, 6, 5, 6);

            int actual = task.maxOccurrences(list1);

            assertEquals(3, actual);
        }

        @Test
        public void test3() {
            List<Integer> list1 = List.of(0, 0, 0, 0);

            int actual = task.maxOccurrences(list1);

            assertEquals(4, actual);
        }

        @Test
        public void test4() {
            List<Integer> list1 = Collections.emptyList();

            int actual = task.maxOccurrences(list1);

            assertEquals(0, actual);
        }
    }
}