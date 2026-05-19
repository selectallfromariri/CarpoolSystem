/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bobble;

/**
 *
 * @author harir
 */
public class Bobble {

    public static void main(String[] args) {

        int[] arr = {5, 2, 9, 1};

        // Bubble Sort
        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - 1 - i; j++) {

                if (arr[j] > arr[j + 1]) {

                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        // print result
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

