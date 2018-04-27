package com.example.entropy.essentialroom;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface CustomObjectDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void addObject(CustomObject customObject);

    @Query("select * from customObjects")
    public List<CustomObject> getObjects();

    @Query("select* from customObjects where fieldOne==:userQuery")
    CustomObject findCustomObjectByFieldOne(String userQuery);

    @Query ("delete from customObjects where fieldOne==:stringDelete")
    void deleteCustomOnjectByFieldOne(String stringDelete);

}
