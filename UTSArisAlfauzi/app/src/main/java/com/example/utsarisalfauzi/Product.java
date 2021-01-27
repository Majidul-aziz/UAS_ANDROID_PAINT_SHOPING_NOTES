package com.example.utsarisalfauzi;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Product implements Cloneable{
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "nama")
    private String nama;

    @ColumnInfo(name = "merk")
    private  String merk;

    public Product(){}

    public Product(int id, String nama, String merk) {
        this.id = id;
        this.nama = nama;
        this.merk = merk;

    }
    public int getId(){ return id; }


    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }



    public Product clone() throws CloneNotSupportedException {
        return (Product) super.clone();
    }

}
