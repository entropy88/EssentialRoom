package com.example.entropy.essentialroom;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {CustomObject.class},version = 1)
public abstract class MyRoomDatabase extends RoomDatabase {
    public abstract CustomObjectDao customObjectDao();
}