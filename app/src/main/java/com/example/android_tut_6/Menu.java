package com.example.android_tut_6;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;

//for menu we are not using any layout we are creating menu through java

public class Menu extends ListActivity {

    //created a string array of classes
    String classes[] = {"MainActivity", "example1", "example2", "example3", "example4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //this takes an array adapter
        //using setListAdapter method which is like ListView and using ArrayAdapter of String type inside the method
        //inside <String> method we are passing some parameters
        //Menu.this means context where to display menu & android.R.layout.simple_list_item_1 means using single list item within entire list
        //classes = String array we declared globally
        //each list item is going to have one position within our string array
        //currently we have 5 list items in our array and when any of those items are clicked onListItemClick method is called
        setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes));
    }


    //currently we have 5 list items in our array and when any of those items are clicked onListItemClick method is called
    //it also gives some info like which item is clicked , position of item in array and id
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        //creating a variable container of string type and storing items stored in classes variable and passing position as parameter bcz Position variables keeps track of the position of item in our array
        //i. position = what position was clicked
        String container = classes[position];

        //using different way to set Intent i.e class variable
        //creating class variable
        //using try and catch to remove error
        try {

            //if position 0 is clicked then it equals to com.example.android_tut.6.MainActivity
            //similarly for other items w.r.t their positions
            Class ourClass = Class.forName("com.example.android_tut_6." + container);

            //Intent will take 2 parameters i.e context and className that was stored in ourClass variable
            Intent ourIntent = new Intent(Menu.this, ourClass);
            startActivity(ourIntent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

//After doing all this, don't forget to add activity tag in your manifest file and setting attribute name to Menu and also changing the pacakge name
