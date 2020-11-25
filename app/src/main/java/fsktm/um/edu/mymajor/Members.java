package fsktm.um.edu.mymajor;

import android.widget.EditText;
import android.widget.SeekBar;

public class Members {

    String memberId, name, email, phone, address, dob, studylevel, studyYear, studyResult, skill1, skill2;

    int level1,level2;

    public Members() {
    }

    public Members(String memberId,String name, String email, String phone, String address, String dob, String studylevel, String studyYear, String studyResult, String skill1, String skill2, int level1, int level2) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.dob = dob;
        this.studylevel = studylevel;
        this.studyYear = studyYear;
        this.studyResult = studyResult;
        this.skill1 = skill1;
        this.skill2 = skill2;
        this.level1 = level1;
        this.level2 = level2;
    }

    public String getName() {
        return name;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getStudylevel() {
        return studylevel;
    }

    public void setStudylevel(String studylevel) {
        this.studylevel = studylevel;
    }

    public String getStudyYear() {
        return studyYear;
    }

    public void setStudyYear(String studyYear) {
        this.studyYear = studyYear;
    }

    public String getStudyResult() {
        return studyResult;
    }

    public void setStudyResult(String studyResult) {
        this.studyResult = studyResult;
    }

    public String getSkill1() {
        return skill1;
    }

    public void setSkill1(String skill1) {
        this.skill1 = skill1;
    }

    public String getSkill2() {
        return skill2;
    }

    public void setSkill2(String skill2) {
        this.skill2 = skill2;
    }

    public int getLevel1() {
        return level1;
    }

    public void setLevel1(int level1) {
        this.level1 = level1;
    }

    public int getLevel2() {
        return level2;
    }

    public void setLevel2(int level2) {
        this.level2 = level2;
    }
}
