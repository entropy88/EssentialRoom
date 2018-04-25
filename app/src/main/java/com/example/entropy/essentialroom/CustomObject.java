package com.example.entropy.essentialroom;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "customObjects")
public class CustomObject {


    @PrimaryKey
    @NonNull

    private String fieldOne;
    private String fieldTwo;
    private String fieldThree;



    @NonNull
    public String getFieldOne() {
        return fieldOne;
    }

    public void setFieldOne(@NonNull String fieldOne) {
        this.fieldOne = fieldOne;
    }

    public String getFieldTwo() {
        return fieldTwo;
    }

    public void setFieldTwo(String fieldTwo) {
        this.fieldTwo = fieldTwo;
    }

    public String getFieldThree() {
        return fieldThree;
    }

    public void setFieldThree(String fieldThree) {
        this.fieldThree = fieldThree;
    }


}
