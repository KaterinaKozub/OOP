package ua.opnu;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.*;

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
            String[] data = {"four", "score", "and", "seven", "years", "ago"};
            String[] data2 = {"score", "seven", "years"};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.removeShorterStrings(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

        @Test
        public void test2() {
            String[] data = {"Lots", "of  ", "ties", "in  ", "this", "test"};
            String[] data2 = {"of  ", "in  ", "test"};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.removeShorterStrings(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

        @Test
        public void test3() {
            String[] data = {"Don't", "remove", "the", "last", "string (me)"};
            String[] data2 = {"remove", "last", "string (me)"};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.removeShorterStrings(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

        @Test
        public void test4() {
            String[] data = {"Don't remove me"};
            String[] data2 = {"Don't remove me"};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.removeShorterStrings(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

        @Test
        public void test5() {
            String[] data = {};
            String[] data2 = {};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.removeShorterStrings(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }
    }

    @Nested
    @DisplayName("Tests for the second task")
    class Task2Test {
        @Test
        public void test1() {

            String[] data = {"how", "are", "you?"};
            String[] data2 = {"how", "how", "are", "are", "you?", "you?"};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.stutter(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

        @Test
        public void test2() {

            String[] data = {"I", "am", "great,", "thanks!"};
            String[] data2 = {"I", "I", "am", "am", "great,", "great,", "thanks!", "thanks!"};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.stutter(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

        @Test
        public void test3() {

            String[] data = {"One string only"};
            String[] data2 = {"One string only", "One string only"};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.stutter(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

        @Test
        public void test4() {

            String[] data = {"1", "4", "3"};
            String[] data2 = {"1", "1", "4", "4", "3", "3"};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.stutter(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

        @Test
        public void test5() {

            String[] data = {};
            String[] data2 = {};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.stutter(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

    }

    @Nested
    @DisplayName("Tests for the third task")
    class Task3Test {

        @Test
        public void test1() {
            String[] data = {"four", "score", "and", "seven", "years", "ago"};
            String[] data2 = {"score", "four", "seven", "and", "ago", "years"};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.switchPairs(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

        @Test
        public void test2() {
            String[] data = {"to", "be", "or", "not", "to", "be", "hamlet"};
            String[] data2 = {"be", "to", "not", "or", "be", "to", "hamlet"};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.switchPairs(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

        @Test
        public void test3() {
            String[] data = {"I", "love", "programming!"};
            String[] data2 = {"love", "I", "programming!"};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.switchPairs(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

        @Test
        public void test4() {
            String[] data = {"Pretty", "straight", "forward", "test", "with", "a", "twist"};
            String[] data2 = {"straight", "Pretty", "test", "forward", "a", "with", "twist"};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.switchPairs(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

        @Test
        public void test5() {
            String[] data = {"don't move me"};
            String[] data2 = {"don't move me"};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.switchPairs(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

        @Test
        public void test6() {
            String[] data = {};
            String[] data2 = {};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.switchPairs(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

    }

    @Nested
    @DisplayName("Tests for the fourth task")
    class Task4Test {

        @Test
        public void test1() {
            String[] data = {"be", "be", "is", "not", "or", "question", "that", "the", "to", "to"};
            String[] data2 = {"be", "is", "not", "or", "question", "that", "the", "to"};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.removeDuplicates(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

        @Test
        public void test2() {
            String[] data = {"duplicate", "duplicate", "duplicate", "duplicate", "duplicate"};
            String[] data2 = {"duplicate"};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.removeDuplicates(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

        @Test
        public void test3() {
            String[] data = {"unique"};
            String[] data2 = {"unique"};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.removeDuplicates(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

        @Test
        public void test4() {
            String[] data = {"be", "is", "not", "or", "question", "that", "the", "to"};
            String[] data2 = {"be", "is", "not", "or", "question", "that", "the", "to"};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.removeDuplicates(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

        @Test
        public void test5() {
            String[] data = {};
            String[] data2 = {};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.removeDuplicates(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

    }

    @Nested
    @DisplayName("Tests for the fifth task")
    class Task5Test {

        @Test
        public void test1() {
            String[] data = {"this", "is", "lots", "of", "fun", "for", "every", "Java", "programmer"};
            String[] data2 = {"****", "this", "is", "****", "lots", "of", "fun", "for", "every", "****", "Java", "programmer"};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.markLength4(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

        @Test
        public void test2() {
            String[] data = {"four", "for ", "all "};
            String[] data2 = {"****", "four", "****", "for ", "****", "all "};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.markLength4(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

        @Test
        public void test3() {
            String[] data = {"Don't", "do", "anything", "to", "the", "list!"};
            String[] data2 = {"Don't", "do", "anything", "to", "the", "list!"};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.markLength4(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

        @Test
        public void test4() {
            String[] data = {"four"};
            String[] data2 = {"****", "four"};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.markLength4(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

        @Test
        public void test5() {
            String[] data = {};
            String[] data2 = {};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.markLength4(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

    }

    @Nested
    @DisplayName("Tests for the sixth task")
    class Task6Test {

        @Test
        public void test1() {
            Integer[] data = {3, 8, 17, 9, 17, 8, 3};

            Queue<Integer> actual = new LinkedList<>(Arrays.asList(data));
            Task task = new Task();
            boolean result = task.isPalindrome(actual);

            assertTrue(result);
        }

        @Test
        public void test2() {
            Integer[] data = {3, 8, 17, 9, 4, 17, 8, 3};

            Queue<Integer> actual = new LinkedList<>(Arrays.asList(data));
            Task task = new Task();
            boolean result = task.isPalindrome(actual);

            assertFalse(result);
        }

        @Test
        public void test3() {
            Integer[] data = {};

            Queue<Integer> actual = new LinkedList<>(Arrays.asList(data));
            Task task = new Task();
            boolean result = task.isPalindrome(actual);

            assertTrue(result);
        }

        @Test
        public void test4() {
            Integer[] data = {1};

            Queue<Integer> actual = new LinkedList<>(Arrays.asList(data));
            Task task = new Task();
            boolean result = task.isPalindrome(actual);

            assertTrue(result);
        }

        @Test
        public void test5() {
            Integer[] data = {1, 2};

            Queue<Integer> actual = new LinkedList<>(Arrays.asList(data));
            Task task = new Task();
            boolean result = task.isPalindrome(actual);

            assertFalse(result);
        }

        @Test
        public void test6() {
            Integer[] data = {1, 2, 1};

            Queue<Integer> actual = new LinkedList<>(Arrays.asList(data));
            Task task = new Task();
            boolean result = task.isPalindrome(actual);

            assertTrue(result);
        }

        @Test
        public void test7() {
            Integer[] data = {5, 10, -1, 4, 3, 2, 4, -1, 10, 5};

            Queue<Integer> actual = new LinkedList<>(Arrays.asList(data));
            Task task = new Task();
            boolean result = task.isPalindrome(actual);

            assertFalse(result);
        }

        @Test
        public void test8() {
            Integer[] data = {5, 10, -1, 4, 3, 3, 4, -1, 10, 5};

            Queue<Integer> actual = new LinkedList<>(Arrays.asList(data));
            Task task = new Task();
            boolean result = task.isPalindrome(actual);

            assertTrue(result);
        }

        @Test
        public void test9() {
            Integer[] data = {5, 10, -1, 4, 3, 2, 2, 4, -1, 10, 5};

            Queue<Integer> actual = new LinkedList<>(Arrays.asList(data));
            Task task = new Task();
            boolean result = task.isPalindrome(actual);

            assertFalse(result);
        }

        @Test
        public void test10() {
            Integer[] data = {5, 10, -1, 4, 3, 4, -1, 10, 5};

            Queue<Integer> actual = new LinkedList<>(Arrays.asList(data));
            Task task = new Task();
            boolean result = task.isPalindrome(actual);

            assertTrue(result);
        }
    }

    @Nested
    @DisplayName("Tests for the seventh task")
    class Task7Test {

        @Test
        public void test1() {
            Integer[] data = {-15, -8, -5, -2, 1, 2, 4, 8, 12, 23};
            Integer[] data2 = {1, 2, -2, 4, -5, 8, -8, 12, -15, 23};
            Queue<Integer> actual = new LinkedList<>(Arrays.asList(data2));
            Queue<Integer> expected = new LinkedList<>(Arrays.asList(data));
            Task task = new Task();
            task.reorder(actual);

            assertArrayEquals(actual.toArray(new Integer[0]), expected.toArray(new Integer[0]));
        }

    }

    @Nested
    @DisplayName("Tests for the eights task")
    class Task8Test {

        @Test
        public void test1() {
            Integer[] data = {4, 6, 84, 16, 3, 5, 17, 83, 1, 37};
            Integer[] data2 = {3, 5, 4, 17, 6, 83, 1, 84, 16, 37};
            Queue<Integer> actual = new LinkedList<>(Arrays.asList(data2));
            Queue<Integer> expected = new LinkedList<>(Arrays.asList(data));
            Task task = new Task();
            task.rearrange(actual);

            assertArrayEquals(actual.toArray(new Integer[0]), expected.toArray(new Integer[0]));
        }

        @Test
        public void test2() {
            Integer[] data = {-3, -1, 1, 3};
            Integer[] data2 = {-3, -1, 1, 3};
            Queue<Integer> actual = new LinkedList<>(Arrays.asList(data2));
            Queue<Integer> expected = new LinkedList<>(Arrays.asList(data));
            Task task = new Task();
            task.rearrange(actual);

            assertArrayEquals(actual.toArray(new Integer[0]), expected.toArray(new Integer[0]));
        }

        @Test
        public void test3() {
            Integer[] data = {-4, -2, 0, 2, 4};
            Integer[] data2 = {-4, -2, 0, 2, 4};
            Queue<Integer> actual = new LinkedList<>(Arrays.asList(data2));
            Queue<Integer> expected = new LinkedList<>(Arrays.asList(data));
            Task task = new Task();
            task.rearrange(actual);

            assertArrayEquals(actual.toArray(new Integer[0]), expected.toArray(new Integer[0]));
        }

        @Test
        public void test4() {
            Integer[] data = {0, -3, -1, 1, 3};
            Integer[] data2 = {-3, -1, 0, 1, 3};
            Queue<Integer> actual = new LinkedList<>(Arrays.asList(data2));
            Queue<Integer> expected = new LinkedList<>(Arrays.asList(data));
            Task task = new Task();
            task.rearrange(actual);

            assertArrayEquals(actual.toArray(new Integer[0]), expected.toArray(new Integer[0]));
        }

        @Test
        public void test5() {
            Integer[] data = {-4, -2, 8, 6, 0, 3, 7, 1, 5};
            Integer[] data2 = {-4, -2, 3, 7, 8, 6, 1, 5, 0};
            Queue<Integer> actual = new LinkedList<>(Arrays.asList(data2));
            Queue<Integer> expected = new LinkedList<>(Arrays.asList(data));
            Task task = new Task();
            task.rearrange(actual);

            assertArrayEquals(actual.toArray(new Integer[0]), expected.toArray(new Integer[0]));
        }

        @Test
        public void test6() {
            Integer[] data = {0};
            Integer[] data2 = {0};
            Queue<Integer> actual = new LinkedList<>(Arrays.asList(data2));
            Queue<Integer> expected = new LinkedList<>(Arrays.asList(data));
            Task task = new Task();
            task.rearrange(actual);

            assertArrayEquals(actual.toArray(new Integer[0]), expected.toArray(new Integer[0]));
        }

        @Test
        public void test7() {
            Integer[] data = {};
            Integer[] data2 = {};
            Queue<Integer> actual = new LinkedList<>(Arrays.asList(data2));
            Queue<Integer> expected = new LinkedList<>(Arrays.asList(data));
            Task task = new Task();
            task.rearrange(actual);

            assertArrayEquals(actual.toArray(new Integer[0]), expected.toArray(new Integer[0]));
        }
    }
}