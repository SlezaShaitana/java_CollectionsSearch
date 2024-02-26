package practice;

import java.util.*;

public class CoolNumbers {
    private static final int REGION_COUNT = 9;
    private static final String[] ALLOWED_LETTERS = { "А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х" };

    public static List<String> generateCoolNumbers() {
        List<String> numbers = new ArrayList<>();

        for (int i = 1; i <= 199; i++){
            for (String letter : ALLOWED_LETTERS){
                for (String letter2 : ALLOWED_LETTERS){
                    for (String letter3 : ALLOWED_LETTERS){
                        for (int num = 1; num < REGION_COUNT; num ++){
                            numbers.add(letter + num + num + num
                                    + letter2 + letter3 + String.format("%02d", i));
                        }
                    }
                }
            }
        }
        return numbers;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        long startTime = System.nanoTime();

        boolean found = list.contains(number);

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Поиск перебором: номер " + (found ? "" : "не")
        + "Найден, поиск занял " + duration + "нс" );
        return found;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        long startTime = System.nanoTime();

        int index = Collections.binarySearch(sortedList, number);
        boolean found = index >= 0;

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Бинарный поиск: номер " + (found ? "" : "не")
                + "Найден, поиск занял " + duration + "нс" );

        return found;
    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        long startTime = System.nanoTime();

        boolean found = hashSet.contains(number);

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Поиск в hashSet: номер " + (found ? "" : "не")
                + "Найден, поиск занял " + duration + "нс" );
        return found;
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        long startTime = System.nanoTime();

        boolean found = treeSet.contains(number);

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Поиск в treeSet: номер " + (found ? "" : "не")
                + "Найден, поиск занял " + duration + "нс" );
        return found;
    }

}
