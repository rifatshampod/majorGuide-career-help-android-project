package fsktm.um.edu.mymajor;

import java.util.ArrayList;

public class MajorCategoryModel {

    private String title, description;
    private ArrayList<MajorSubcategoryModel> subcategories;

    public MajorCategoryModel(){

    }

    public MajorCategoryModel(String title, String description, ArrayList<MajorSubcategoryModel> subcategories){
        this.title = title;
        this.description = description;
        this.subcategories = subcategories;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<MajorSubcategoryModel> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(ArrayList<MajorSubcategoryModel> subcategories) {
        this.subcategories = subcategories;
    }
}
