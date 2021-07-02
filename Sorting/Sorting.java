package com.gracia.modul9;

import java.util.Scanner;

public class Sorting {
    static int temp, pos, i, j;

    public static int[] bubbleSort(int data[]){
        for(i = 1; i < data.length; i++){
            for(j = data.length - 1; j >= i; j--){
                if(data[j] < data[j - 1]){
                    temp = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = temp;
                }
            }
        }
        return data;
    }

    public static void Opt_bubbleSort(int data[]){
        int n = data.length;
        boolean doMore = true;
        while(doMore){
            n--;
            doMore = false;
            for(i = 0; i<n; i++){
                if(data[i] > data[i + 1]){
                    temp = data[i];
                    data[i] = data[i + 1];
                    data[i + 1] = temp;
                    doMore = true;
                }
            }
        }
    }

    public static int[] selectionSort(int data[]){
        for(i = 0; i <data.length - 1; i++){
            pos = i;
            for(j = i + 1; j <data.length; j++){
                if(data[j] < data[pos]){
                    pos = j;
                }
            }
            if(pos != i){
                temp = data[pos];
                data[pos] = data[i];
                data[i] = temp;
            }
        }
        return data;
    }

    public static int[] insertionSort(int data[]){
        for(i = 1; i < data.length; i++){
            temp = data[i];
            j = i;
            while((j > 0) && (data[j-1] > temp)){
                data[j] = data[j-1];
                j--;
            }
            data[j] = temp;
            System.out.println(j);
        }
        return data;
    }
}

