package ua.opnu;

import java.util.*;

public class Task {

    public static void main(String[] args) {
        // Для виконання лабораторної роботи необхідно написати вміст методів згідно умовам завдання,
        // після чого протестувати метод за допомогою тестів, які знаходяться в папці
        // src\test\TaskTest.java
    }

    public int maxLength(Set<String> set) {
        int max = 0;

        for (String word : set) {
            if (word.length() > max) {
                max = word.length();
            }
        }
        return 0;
    }

    public static void removeEvenLength(Set<String> set) {
        Iterator<String> i = set.iterator();

        while (i.hasNext()) {
            String word = i.next();
            if (word.length() % 2 == 0) {
                i.remove();
            }
        }
    }

    public int numInCommon(List<Integer> list1, List<Integer> list2) {
        HashSet<Integer> set1 = new HashSet<Integer>(list1);
        HashSet<Integer> set2 = new HashSet<Integer>(list2);
        int count = 0;

        for(int n : set2) {
            if(set1.contains(n))
                count++;
        }

        return count;
    }

    public boolean isUnique(Map<String, String> map) {
        HashSet<String> set = new HashSet<String>();

        for(String key : map.keySet()) {
            String value = map.get(key);

            if(set.contains(value))
                return false;

            set.add(value);
        }

        return true;
    }

    public static Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2){
        Map<String, Integer> newMap = new HashMap<String, Integer>();
        for(String key: map1.keySet()){
            Integer value1 = map1.get(key);
            Integer value2 = map2.get(key);
            if(map2.containsKey(key) && value1 ==value2){
                newMap.put(key, value1);
            }
        }
        return newMap;
    }

    public Map<String, Integer> reverse(Map<Integer, String> map) {
        HashMap<String, Integer> reversed = new HashMap<String, Integer>();

        for(int key : map.keySet()) {
            String value = map.get(key);

            if(!reversed.containsKey(value)) {
                reversed.put(value, key);
            }
        }

        return reversed;
    }

    public int rarest(Map<String, Integer> map) {
        HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        int rarest = Integer.MAX_VALUE;
        int numRarest = Integer.MAX_VALUE;

        for(String key : map.keySet()) {
            int value = map.get(key);

            if(hashmap.containsKey(value)) {
                hashmap.put(value, hashmap.get(value) + 1);
            } else {
                hashmap.put(value, 1);
            }
        }

        for(int key : hashmap.keySet()) {
            int value = hashmap.get(key);

            if(value < numRarest) {
                rarest = key;
                numRarest = value;
            } else if(value == numRarest) {
                rarest = key < rarest ? key : rarest;
            }
        }

        return rarest;
    }

    public int maxOccurrences(List<Integer> list) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int modeVal = 0;

        for(int n : list) {
            if(map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }

            if(map.get(n) > modeVal)
                modeVal = map.get(n);
        }

        return modeVal;
    }

}