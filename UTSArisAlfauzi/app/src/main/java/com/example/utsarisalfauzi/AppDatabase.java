package com.example.utsarisalfauzi;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Product.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ProductDao productDao();

    public static AppDatabase db;

    public static AppDatabase getDb(Context context){
        if(db == null ){
            db = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "db_product")
                    .enableMultiInstanceInvalidation()
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
            Log.i("Database Initialized", "Database Initialized");
        }
        return db;
    }
}