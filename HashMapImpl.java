package com.gracia.modul8;

public class HashMapImpl<K, V> {
    private int capacity = 100; // misalkan kapasitas tabel 100
    private int size = 0; // ukuran awal 0
    private Entry<K, V> table[] = new Entry[capacity]; // deklarasi array list

/*
    Method hashing berfungsi untuk menetapkan kode unik untuk variable/objek
    apapun setelah menerapkan fungsi/algoritma apapun pada propertinya
 */

    private int Hashing(int hashCode){
        int location = hashCode % capacity;
        return location;
    }

//    Jangan dipakai dulu
//    Menentukan ukuran hashmap (jumlah item di dalam hashmap
    public int size(){
        return this.size;
    }

//    Jangan dipakai dulu
//    Mengecek apakah key tersedia atau tidak
    public boolean containsKey(Object key) {
//        Mengembalikan nilai true jika kunci pada hashmap untuk kata kunci yang ditentukan
        if (key == null) {
            if (table[0].getKey() == null) {
                return true;
            }
        }
        int location = Hashing(key.hashCode());
        Entry e = null;
//        Error handling (penanganan kesalahan)
        try {
            e = table[location];
        } catch (NullPointerException ex) { }
//        Mengembalikan nilai true jika kunci pada hashmap untuk kata kunci yang ditentukan
        if (e != null && e.getKey() == key) {
            return true;
        }
//        Mengembalikan nilai false jika kunci pada hashmap tidak sesuai dengan kata kunci yang ditentukan
        return false;
    }

//    Jangan dipakai dulu
//    Mengecek apakah value tersedia atau tidak
    public boolean containsValue(Object value) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null && table[i].getVal() == value) {
                return true;
            }
        }
        return false;
    }

//    Mengambil data pada hashMap
    public V get(K key) {
        V ret = null;
        if (key == null) {
            Entry<K, V> e = null;
            try {
                e = table[0];
            } catch (NullPointerException ex) { }
            if (e != null) {
                return (V) e.getVal();
            }
        } else {
            int location = Hashing(key.hashCode());
            Entry<K, V> e = null;
            try {
                e = table[location];
            } catch (NullPointerException ex) { }
            if (e != null && e.getKey() == key) {
                return (V) e.getVal();
            }
        }
        return ret;
    }

//    Menaruh data
    public V put(K key, V val) {
        V ret = null;
//        Jika kunci == null
        if (key == null) {
//            menaruh data tanpa key
            ret = putForNullKey(val);
            return ret;
//            Jika key != null
        } else {
//            lokasi = perhitungan dari method hashing
            /*
                Parameter pada method hashing yaitu key.hashcode
                artinya melakukan perhitungan yang ada di method hashcode
                selama key nya tidak null.
                Setelah di temukan hasil hashcode, maka hitung method hashing
             */
            int location = Hashing(key.hashCode());
//            Jika lokasi melebihi kapasitas
            if (location >= capacity) {
//                Cetak data "perlu dilakukan perhitungan ulang"
                System.out.println("Rehashing required");
//                Karena melebihi kapasitas maka return null
                return null;
            }
            Entry<K, V> e = null;
//            Error handling e tidak sesuai dengan table[location]
            try {
                e = table[location];
            } catch (NullPointerException ex) { }
//            Jika e != null dan key sesuai
            if (e != null && e.getKey() == key) {
//                Tambahkan nilai
                ret = (V) e.getVal();
//                Jika key null dan
            } else {
                Entry<K, V> eNew = new Entry<K, V>();
                eNew.setKey(key);
                eNew.setVal(val);
                table[location] = eNew;
                size++;
            }
        }
        return ret;
    }

//    method untuk menaruh value tanpa key
    private V putForNullKey(V val) {
        Entry<K, V> e = null; // hashmap null
        try {
            e = table[0];
        } catch (NullPointerException ex) {

        }
        V ret = null;
//        Jika data (pasangan Key, Value) pada tabel tidak kosong, dan key nya null
        if (e != null && e.getKey() == null) {
//            tambahkan value
            ret = (V) e.getVal();
            e.setVal(val);
            return ret;
//        Jika data (pasangan key, value) pada tabel kosong
        } else {
            Entry<K, V> eNew = new Entry<K, V>();
//            Pasangan value dan key ditambahkan di indeks paling awal
            eNew.setKey(null);
            eNew.setVal(val);
            table[0] = eNew;
            size++;
        }
        return ret;
    }

//    Jangan dijelasin dulu
    public V remove(K key) {
        int location = Hashing(key.hashCode());
        V ret = null;
        if (table[location].getKey() == key) {
//            for (int i = location; i < table.length; i++) {
//                table[i] = table[i + 1];
//            }
            table[location] = null;
        }
        return ret;
    }

    public static void main(String[] args) {
        HashMapImpl<String, String> hashMap = new HashMapImpl<String, String>();
        Entry<String, String> entrydata = new Entry<>();
        hashMap.put("name","Rekayasa Perangkat Lunak");
        hashMap.put("url", "https://se.ittelkom-pwt.ac.id");
        hashMap.put("email", "se@ittelkom-pwt.ac.id");

        System.out.println("Nama \t: "+hashMap.get("name"));
        System.out.println("URL \t: "+hashMap.get("url"));
        System.out.println("Email \t: "+hashMap.get("email"));

        System.out.println(entrydata.equals(hashMap));
        
        // main 2
        HashMapImpl<Integer, String> hashMap = new HashMapImpl<Integer, String>();
        hashMap.put(10, "Apel");
        hashMap.put(1, "Jeruk");
        hashMap.put(79, "Anggur");
        System.out.println("Nilai pada 79 " + hashMap.get(79));
        System.out.println("Nilai pada 1 " + hashMap.get(1));
        System.out.println("Nilai pada 3 " + hashMap.get(3));

        hashMap.remove(1);
        System.out.println("Nilai pada 1 " + hashMap.get(1));
        System.out.println("Nilai pada 79 " + hashMap.get(79));
//        System.out.println("Val at 10 " + hashMap.get(10));
//        System.out.println("Val at 2 " + hashMap.get(2));
//        hashMap.put(null, "Pear");
//        System.out.println("Val at null " + hashMap.get(null));
//        System.out.println("Hashmap has key at null:" + hashMap.containsKey(null));
//        System.out.println("Hashmap has value at null:" + hashMap.containsValue("Pear"));
//        System.out.println("Size of Map:" + hashMap.size());
    }
}
