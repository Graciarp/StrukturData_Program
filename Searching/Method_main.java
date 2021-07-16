package modul12;

import java.util.Random;
import java.util.Scanner;

public class Method_main {
    public static void printPilihan() {
        System.out.print("Pilihan Anda :\n"
                + "1.  Generate Data\n"
                + "2.  Tampilkan Data\n"
                + "3.  Sequential Search\n"
                + "4.  Binary Search\n"
                + "5.  Interpolation Search\n"
                + "6.  Keluar\n"
                + "Silahkan masukkan pilihan Anda : ");
    }
    public static void dataUrut(){
        Searching.selectionSort(a);
        System.out.println("Data array setelah diurutkan : ");
        for(i=0; i<a.length; i++)
            System.out.print(a[i]+" ");
        System.out.println();
    }
    static int a[], temp, i, cari;
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        Random acak = new Random();
        try {
            while (true) {
                printPilihan();
                int pilihan = input.nextInt();
                switch (pilihan) {
                    case 1:
                    {
                        System.out.print("Masukkan jumlah data random : ");
                        temp = input.nextInt();
                        a = new int [temp];
                        for(i=0; i<temp; i++)
                            a[i] = acak.nextInt(100);
                        break;
                    }
                    case 2:
                    {
                        System.out.println("Menampilkan data array : ");
                        for(i=0; i<a.length; i++)
                            System.out.print(a[i]+" ");
                        System.out.println();
                        break;
                    }
                    case 3:
                    {
                        if(a == null){
                            System.out.println("Array tidak boleh kosong !");
                            break;
                        }
                        System.out.print("Masukkan data yang ingin dicari : ");
                        cari = input.nextInt();
                        long awal = System.currentTimeMillis();
                        if(Searching.sequential(a, cari)>-1){
                            System.out.println("Data "+cari+" ditemukan pada indeks "+Searching.sequential(a, cari));
                        }
                        else
                            System.out.println("Data "+cari+" tidak ditemukan !");
                        long akhir = System.currentTimeMillis();
                        System.out.println("Waktu eksekusi program = " +(akhir-awal)+" nanoseconds");
                        break;
                    }
                    case 4:
                    {
                        if(a == null){
                            System.out.println("Array tidak boleh kosong !");
                            break;
                        }
                        dataUrut();
                        System.out.print("Masukkan data yang ingin dicari : ");
                        cari = input.nextInt();
                        long awal = System.nanoTime();
                        if(Searching.binarySearch(a, cari)>-1){
                            System.out.println("Data "+cari+" ditemukan pada indeks "+Searching.binarySearch(a, cari));
                        }
                        else
                            System.out.println("Data "+cari+" tidak ditemukan !");
                        long akhir = System.nanoTime();
                        System.out.println("Waktu eksekusi program = " +(akhir-awal)+" nanoseconds");
                        break;
                    }
                    case 5:
                    {
                        if(a == null){
                            System.out.println("Array tidak boleh kosong !");
                            break;
                        }
                        System.out.print("Masukkan data yang ingin dicari : ");
                        cari = input.nextInt();
                        long awal = System.nanoTime();
                        if(Searching.interpolationSearch(a, cari)>-1){
                            System.out.println("Data "+cari+" ditemukan pada indeks "+Searching.interpolationSearch(a, cari));
                        }
                        else
                            System.out.println("Data "+cari+" tidak ditemukan !");
                        long akhir = System.nanoTime();
                        System.out.println("Waktu eksekusi program = " +(akhir-awal)+" nanoseconds");
                        break;
                    }
                    case 6:
                    {
                        System.out.println("Anda telah keluar, Thanks");
                        System.exit(0);
                    }
                    default:System.out.println("Masukkan angka 1-6!");
                }
            }
        } catch (Exception e) {
            System.out.println("Illegal Akses !"
                    + " Ulangi lagi run-file, masukkan angka 1-6!");
        }
    }
}
