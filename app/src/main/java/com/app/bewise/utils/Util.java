package com.app.bewise.utils;

import com.app.bewise.R;
import com.app.bewise.model.BookCategory;
import com.app.bewise.model.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Util {
    public final static String BASE_API = "http://api-bewise.herokuapp.com/api/v1";

    public final static List<BookCategory> getCategory() {
        List<BookCategory> categoryList = new ArrayList<>();

        categoryList.add(new BookCategory(0,1,"Matematica", R.drawable.rocket_3));
        categoryList.add(new BookCategory(0,1, "Quimica", R.drawable.rocket));
        categoryList.add(new BookCategory(0,1,"Geografia", R.drawable.rocket_3));
        categoryList.add(new BookCategory(0,1,"Fisica", R.drawable.rocket_3));
        categoryList.add(new BookCategory(0,1,"Ingles", R.drawable.rocket_3));
        categoryList.add(new BookCategory(0,1,"DGD", R.drawable.rocket_3));
        categoryList.add(new BookCategory(0,1, "Filosofia", R.drawable.rocket_3));
        return categoryList;
    }

}
