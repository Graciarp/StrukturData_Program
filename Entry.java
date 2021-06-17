package com.gracia.modul8;

/*
    Hashmap berfungsi untuk memetakan objek dalam bentuk pasangan (key-value)
    dimana kunci harus bersifat unik
 */

// <K, V> Sejenis parameter tapi dalam hashmap
public class Entry<K, V>{
//    Deklarasi variable key dan val dengan tipe data K, V
    K key;
    V val;

//    Getter & Setter
    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getVal() {
        return val;
    }

    public void setVal(V val) {
        this.val = val;
    }

//    Method untuk menentukan lokasi penyimpanan key dan value
    public int hashCode(){
        int prime = 13; // bilangan prima : angka bebas yang penting bil. prima
        int mul = 11; // bilangan multiple : angka bebas
//        Kenapa pakai prima supaya ketika di modulus angkanya berbeda
        if(key != null){
            int hashCode = prime * mul + key.hashCode();
            return hashCode;
        }
        return 0;
    }

//    Method untuk membandingkan kesamaan nilai pada object
    public boolean equals(Object o){
//        Jika object yang dibandingkan bernilai sama
        if(this == o){
            return true;
        }
//        Jika object yang dibandingkan kosong atau tidak sama
        if(o == null || this.getClass().getName() != o.getClass().getName()){
            return false;
        }
        Entry e = (Entry)o;
//        Jika key yang dibandingkan sama
        if(this.key == e.key){
            return true;
        }
//        Defaultnya false
        return false;
    }
}
