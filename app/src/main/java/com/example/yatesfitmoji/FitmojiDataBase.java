package com.example.yatesfitmoji;

import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;
import androidx.annotation.NonNull;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {User.class}, version = 1, exportSchema = false)
abstract class FitmojiDataBase extends RoomDatabase{
    abstract UserDao userDao();


    private static volatile FitmojiDataBase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static FitmojiDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (FitmojiDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            FitmojiDataBase.class, "fitmoji_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
