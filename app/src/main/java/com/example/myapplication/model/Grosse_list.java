package com.example.myapplication.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Grosse_list implements Serializable {

    private static Grosse_list mInstance = null;
    public static ArrayList<List_rubriques> universal_list = new ArrayList<List_rubriques>();

    protected Grosse_list() {
    }



    public static synchronized Grosse_list getInstance() {


        if (null == mInstance) {
            mInstance = new Grosse_list();

        }
        return mInstance;
    }


}
