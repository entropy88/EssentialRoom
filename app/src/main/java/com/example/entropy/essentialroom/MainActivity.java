package com.example.entropy.essentialroom;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.util.List;



public class MainActivity extends AppCompatActivity {
    MyRoomDatabase myRoomDatabase;
    EditText fieldOneValueEDT;
    EditText fieldTwoValueEDT;
    EditText fieldThreeValueEDT;
    Button addObjectBTN;
    TextView showRecordsTv;
    EditText searchDbValueOneEDT;
    Button searchDbBTN;
    TextView searchResultsTV;
    EditText deleteByValueOneEDT;
    Button deleteObjBTN;
    TextView deletionStatusTV;
    Button showAllRecords;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fieldOneValueEDT= (EditText) findViewById(R.id.edt_field_one);
        fieldTwoValueEDT= (EditText) findViewById(R.id.edt_field_two);
        fieldThreeValueEDT= (EditText) findViewById(R.id.edt_field_three);
        addObjectBTN= (Button)findViewById(R.id.btn_add_object);
        showRecordsTv= (TextView) findViewById(R.id.tvShowAllRecords);
        searchDbValueOneEDT= (EditText) findViewById(R.id.edt_search_by_field_one);
        searchDbBTN =(Button) findViewById(R.id.btn_search_object);
        searchResultsTV= (TextView) findViewById(R.id.tv_search_results);
        deleteByValueOneEDT=(EditText) findViewById(R.id.edt_delete_by_field_one);
        deleteObjBTN= (Button) findViewById(R.id.btn_delete_object);
        deletionStatusTV= (TextView) findViewById(R.id.tv_show_status) ;
        showAllRecords=(Button) findViewById(R.id.btn_show_all_records);

        myRoomDatabase = Room.databaseBuilder
                (MainActivity.this, MyRoomDatabase.class, "customObjects")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

//        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        List<CustomObject> customObjectList = myRoomDatabase.customObjectDao().getObjects();
//        CustomObjectsAdapter adapter= new CustomObjectsAdapter(customObjectList);
//        recyclerView.setAdapter(adapter);

        addObjectBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //step one:create object

                CustomObject customObject= new CustomObject();
                customObject.setFieldOne(fieldOneValueEDT.getText().toString());
                customObject.setFieldTwo(fieldTwoValueEDT.getText().toString());
                customObject.setFieldThree(fieldThreeValueEDT.getText().toString());
                myRoomDatabase.customObjectDao().addObject(customObject);


                //step two: generate lis from the database
//                List<CustomObject> customObjectList = myRoomDatabase.customObjectDao().getObjects();
//                String info = "";
//                for (CustomObject cobj :customObjectList) {
//                    String fldOne = cobj.getFieldOne();
//                    String fldTwo = cobj.getFieldTwo();
//                    String fldThree = cobj.getFieldThree();
//                    info = info + "\n" + fldOne + " " + fldTwo + " " + fldThree;
//                }




            }
        });

        searchDbBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String userInput = searchDbValueOneEDT.getText().toString();
              CustomObject customObject= myRoomDatabase.customObjectDao().findCustomObjectByFieldOne(userInput);
              if (customObject==null){
                  searchResultsTV.setText("never heard of it");
              } else {
                  searchResultsTV.setText(customObject.getFieldOne()+" "+customObject.getFieldTwo()+" "+customObject.getFieldThree());
              }

            }
        });

        deleteObjBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userInput=deleteByValueOneEDT.getText().toString();
                CustomObject customObject= myRoomDatabase.customObjectDao().findCustomObjectByFieldOne(userInput);
                if (customObject==null){
                    deletionStatusTV.setText("no such object");
                } else {
                    myRoomDatabase.customObjectDao().deleteCustomOnjectByFieldOne(userInput);
                    deletionStatusTV.setText("Object with value of field one "+ userInput+" was deleted");
                }
            }
        });
        showAllRecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RecyclerView recyclerView=(RecyclerView) findViewById(R.id.recyclerView);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                List<CustomObject> customObjectList = myRoomDatabase.customObjectDao().getObjects();
                CustomObjectsAdapter adapter= new CustomObjectsAdapter(customObjectList);
                recyclerView.setAdapter(adapter);
            }
        });
    }
}
