package com.example.hsai_project;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {ProductEntity.class}, version = 1)
public abstract class ProductDatabase extends RoomDatabase {
    private static ProductDatabase instance;

    public abstract ProductDao productDao();

    public static synchronized ProductDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), ProductDatabase.class, "product_database").fallbackToDestructiveMigration().addCallback(roomCallback).build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void>{
        private ProductDao productDao;
        private PopulateDbAsyncTask(ProductDatabase db){

            productDao = db.productDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            productDao.insert(new ProductEntity("Laptop", 297, "MediaMarkt", "https://i.redd.it/qnw9dn0rvau31.png", false, false));
            productDao.insert(new ProductEntity("PC", 420, "MediaMarkt", "https://i.redd.it/qnw9dn0rvau31.png", false, false));
            productDao.insert(new ProductEntity("Laptop_2", 555, "MediaMarkt", "https://i.redd.it/qnw9dn0rvau31.png", false, false));
            productDao.insert(new ProductEntity("MacBook", 555, "MediaMarkt", "https://i.redd.it/qnw9dn0rvau31.png", false, false));
            return null;
        }
    }
}
