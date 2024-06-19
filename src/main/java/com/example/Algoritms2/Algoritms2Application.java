package com.example.Algoritms2;

import com.example.Algoritms2.realisation.MyArrayList2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Random;


public class Algoritms2Application {

    public static void main(String[] args) {

        MyArrayList2 myArrayList = new MyArrayList2(8);
        myArrayList.add(8);
        myArrayList.add(4);
        myArrayList.add(7);
        myArrayList.add(9);
        myArrayList.add(3);

//        myArrayList.add("F");
//        myArrayList.add("G");

        myArrayList.set(1, 333);
        myArrayList.add(3, 55);
        myArrayList.add(5, 66);
        myArrayList.remove(5);
//		myArrayList.remove(1);

        System.out.println("contains " + myArrayList.contains(8));


        System.out.println(Arrays.toString(myArrayList.toArray()));

        System.out.println("indexOf " + myArrayList.indexOf(7));


        Algoritms2Application.sortBubble();
        Algoritms2Application.sortSelection();
        Algoritms2Application.sortInsertion();
    }

    ////  Пузырьковая сортировка
    public static void sortBubble() {
        int[] arr = getArr();

        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    ////  Сортировка выбором
    public static void sortSelection() {
        int[] arr = getArr();

        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    //// Сортировка вставкой
    public static void sortInsertion() {
        int[] arr = getArr();
        long start = System.currentTimeMillis();
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    private static int[] getArr() {
        Random random = new Random();
        int[] arr = new int[100_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000);
        }
        return arr;
    }

}




