package com.gracia.modul9;

import java.util.Scanner;

public class Method_main {
    public static void printPilihan() {
        System.out.print("Pilihan Anda :\n"
                + "1.  Bubble Sort\n"
                + "2.  Optimalisasi Bubble Sort\n"
                + "3.  Selection Sort\n"
                + "4.  Insertion Sort\n"
                + "5.  Keluar\n"
                + "Silahkan masukkan pilihan Anda : ");
    }
    static int temp, i, j;
        public static void main (String[] args){
            Scanner input = new Scanner(System.in);
            try {
                while (true) {
                    printPilihan();
                    int pilihan = input.nextInt();
                    switch (pilihan) {
                        case 1:
                        {
                            System.out.println("Sorting dengan Bubble Sort");
                            System.out.print("Masukkan jumlah data : ");
                            temp = input.nextInt();
                            int a[] = new int [temp];
                            System.out.println("Masukkan data : ");
                            for(i=0; i<a.length; i++)
                                a[i] = input.nextInt();
                            System.out.print("Data sebelum disorting : ");
                            for(i=0; i<a.length; i++)
                                System.out.print(a[i]+" ");
                            Sorting.bubbleSort(a);
                            System.out.print("\nData setelah disorting : ");
                            for(i=0; i<a.length; i++)
                                System.out.print(a[i]+" ");
                            System.out.println();
                            break;
                        }
                        case 2:
                        {
                            System.out.println("Sorting dengan optimalisasi Bubble Sort");
                            System.out.print("Masukkan jumlah data : ");
                            temp = input.nextInt();
                            int a[] = new int [temp];
                            System.out.println("Masukkan data : ");
                            for(i=0; i<a.length; i++)
                                a[i] = input.nextInt();
                            System.out.print("Data sebelum disorting : ");
                            for(i=0; i<a.length; i++)
                                System.out.print(a[i]+" ");
                            Sorting.Opt_bubbleSort(a);
                            System.out.print("\nData setelah disorting : ");
                            for(i=0; i<a.length; i++)
                                System.out.print(a[i]+" ");
                            System.out.println();
                            break;
                        }
                        case 3:
                        {
                            System.out.println("Sorting dengan Selection Sort");
                            System.out.print("Masukkan jumlah data : ");
                            temp = input.nextInt();
                            int a[] = new int [temp];
                            System.out.println("Masukkan data : ");
                            for(i=0; i<a.length; i++)
                                a[i] = input.nextInt();
                            System.out.print("Data sebelum disorting : ");
                            for(i=0; i<a.length; i++)
                                System.out.print(a[i]+" ");
                            Sorting.selectionSort(a);
                            System.out.print("\nData setelah disorting : ");
                            for(i=0; i<a.length; i++)
                                System.out.print(a[i]+" ");
                            System.out.println();
                            break;
                        }
                        case 4:
                        {
                            System.out.println("Sorting dengan Insertion Sort");
                            System.out.print("Masukkan jumlah data : ");
                            temp = input.nextInt();
                            int a[] = new int [temp];
                            System.out.println("Masukkan data : ");
                            for(i=0; i<a.length; i++)
                                a[i] = input.nextInt();
                            System.out.print("Data sebelum disorting : ");
                            for(i=0; i<a.length; i++)
                                System.out.print(a[i]+" ");
                            Sorting.insertionSort(a);
                            System.out.print("\nData setelah disorting : ");
                            for(i=0; i<a.length; i++)
                                System.out.print(a[i]+" ");
                            System.out.println();
                            break;
                        }
                        case 5:
                        {
                            System.out.println("Anda telah keluar, Thanks");
                            System.exit(0);
                        }
                        default:System.out.println("Masukkan angka 1-5!");
                    }
                }
            } catch (Exception e) {
                System.out.println("Illegal Akses !"
                        + " Ulangi lagi run-file, masukkan angka 1-5!");
            }
        }
    }
