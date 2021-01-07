package fsktm.um.edu.mymajor;

public class MajorSubcategoryModel {

    private String title, description, skills_required;

    public MajorSubcategoryModel(){

    }

    public MajorSubcategoryModel(String title, String description){
        this.title = title;
        this.description = description;
    }

    public MajorSubcategoryModel(String title, String description, String skills_required){
        this.title = title;
        this.description = description;
        this.skills_required = skills_required;
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

    public String getSkills_required() {
        return skills_required;
    }

    public void setSkills_required(String skills_required) {
        this.skills_required = skills_required;
    }
}
