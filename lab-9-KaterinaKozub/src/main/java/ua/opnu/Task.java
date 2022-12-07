package ua.opnu;

import java.util.*;

public class Task {
    public static void main(String[] args) {
        // Для виконання лабораторної роботи необхідно написати вміст методів згідно умовам завдання,
        // після чого протестувати метод за допомогою тестів, які знаходяться в папці
        // src\test\TaskTest.java
    }

    public void removeShorterStrings(List<String> list) {
        int oldSize = list.size();

        for (int i = 0; i < oldSize / 2; i++) {
            if (list.get(i).length() > list.get(i + 1).length()) {
                list.remove(i + 1);
            } else if (list.get(i).length() == list.get(i + 1).length()) {
                list.remove(i);
            } else {
                list.remove(i);
            }
        }
    }

    public void stutter(List<String> list) {
        int oldSize = list.size();

        for (int i = 0; i < oldSize; i++)
            list.add(i * 2, list.get(i * 2));
    }

    public void switchPairs(List<String> list) {
        String tmp = " ";

        if (list.size() % 2 != 0)
            tmp = list.remove(list.size() - 1);

        for (int i = 0; i < list.size(); i++) {
            list.add(i++, list.remove(i++));
            i--;
        }

        if (!tmp.equals(" "))
            list.add(tmp);
    }

    public void removeDuplicates(List<String> list) {
        ArrayList<String> newList = new ArrayList<>();

        for (String element : list) {
            if (!newList.contains(element))
                newList.add(element);
        }

        list.clear();
        list.addAll(newList);
    }

    public void markLength4(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == 4) {
                list.add(i, "****");
                i++;
            }
        }
    }

    public boolean isPalindrome(Queue<Integer> queue) {
        ArrayDeque<Integer> d = new ArrayDeque<>();
        int oldSize = queue.size();
        boolean palindrome = true;

        for (int i = 0; i < oldSize; i++) {
            int value = queue.peek();
            d.push(value);
            queue.remove();
            queue.add(value);
        }

        while (!d.isEmpty()) {
            if (!d.peek().equals(queue.peek()))
                palindrome = false;
            d.pop();
            queue.add(queue.remove());
        }
        return palindrome;
    }

    public void reorder(Queue<Integer> queue) {
        if (queue.size() == 0 || queue.size() == 1)
            return;

        int oldSize = queue.size();
        int count = 0;
        int x = queue.poll();
        reorder(queue);

        while (queue.peek() < x && count < oldSize) {
            queue.add(queue.poll());
            count++;
        }
        queue.add(x);

        if (count == oldSize)
            return;
        count = 0;

        while (queue.peek() >= x && count < oldSize) {
            queue.add(queue.poll());
            count++;
        }
    }

    public void rearrange(Queue<Integer> queue) {
        ArrayDeque<Integer> d = new ArrayDeque<>();
        int oldSize = queue.size();

        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < oldSize; i++) {
                if (queue.peek() % 2 == 0)
                    queue.add(queue.remove());
                else
                    d.push(queue.remove());
            }

            while (!d.isEmpty())
                queue.add(d.pop());
        }
    }

}