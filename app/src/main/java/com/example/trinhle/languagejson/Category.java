package com.example.trinhle.languagejson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Trinh Le on 28/07/2016.
 */
public class Category {
    @SerializedName("category_id")
    private String categoryID;

    @SerializedName("category_name")
    private String categoryName;

    @SerializedName("description")
    private String description;

    @SerializedName("num_col")
    private String numCol;

    public Category (String categoryID, String categoryName, String description, String numCol) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.description = description;
        this.numCol = numCol;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getDescription() {
        return description;
    }

    public String getNumCol() {
        return numCol;
    }
}
