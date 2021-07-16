package modul12;

public class Searching {
//    DEKLARASI ATRIBUT
    static int temp, pos, i, j, start, end, mid, low, high;

//    PENGURUTAN DATA MENGGUNAKAN SELECTION SORT
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

//    PENCARIAN DATA MENGGUNAKAN SEQUENTIAL SEARCH
//    mengecek data satu per satu hingga data di temukan
    public static int sequential (int[] data, int cari){
//        LOOPING SEBANYAK ELEMEN YANG ADA
//        data.length-1 karena i dimulai dari 0
        for(i=0; i<data.length-1; i++){
//            Jika data[i] sama dengan data yang dicari
            if(data[i]==cari){
//                maka nilai kembalian berupa indeks dari data yang ditemukan
                return i;
            }
        }
//        Jika data[i] tidak sesuai dengan data yang dicari
        return -1;
    }

//    PENCARIAN DATA MENGGUNAKAN BINARY SEARCH
//    Mencari data dengan cara membagi 2 data dan dibandingkan dengan nilai tengah
    public static int binarySearch(int[] data, int cari) {
//        DATA HARUS DIURUTKAN TERLEBIH DAHULU
        Searching.selectionSort(data);
//        Inisiasi
        start = 0; end = data.length - 1;
//        Ketika nilai start <= nilai end maka terjadi looping
        while (start <= end) {
//            Menentukan nilai tengah
            mid = (start + end) / 2;
//            Jika data pada indeks tengah = data yang dicari
            if (data[mid] == cari) {
//                Nilai kembalian berupa indeks data yang ada di tengah
                return mid;
//                Jika data pada indeks tengah < data yang dicari
            } else if (data[mid] < cari) {
//                nilai start berubah, end tetap
                start = mid + 1;
//                Jika data pada indeks tengah > data yang dicari
            } else {
//                Nilai end berubah, start tetap
                end = mid - 1;
            }
        }
//        Jika data tidak ditemukan
        return -1;
    }

//    PENCARIAN DATA MENGGUNAKAN INTERPOLATION SEARCH
    public static int interpolationSearch(int data[], int cari){
//        DATA HARUS DIURUTKAN DAHULU
        Searching.selectionSort(data);
//        Inisiasi
        low = 0; high = data.length - 1;
//        Looping jika kondisi terpenuhi
        while(cari>=data[low] && cari<=data[high]){
//            Variable pos untuk indeks pada data array
            pos = ((cari-data[low])/(data[high]-data[low]))*(high-low)+low;
            if (data[pos] == cari) {
                return pos;
            }if (data[pos] > cari)
                high = pos - 1;
            else if(data[pos] < cari)
                low = pos + 1;
        }
        return -1;
    }
}
