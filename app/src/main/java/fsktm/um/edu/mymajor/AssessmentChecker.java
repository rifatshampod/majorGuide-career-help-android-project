package fsktm.um.edu.mymajor;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AssessmentChecker {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

    private ArrayList<MajorSubcategoryModel> questionMajors = new ArrayList<>();

    public AssessmentChecker() {
        // Question 1
        myRef.child("majors").child("categories").child("13").child("subcategories").child("0").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                questionMajors.add(dataSnapshot.getValue(MajorSubcategoryModel.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("Question 1", "Database Error!");
            }
        });

        // Question 2
        myRef.child("majors").child("categories").child("1").child("subcategories").child("2").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                questionMajors.add(dataSnapshot.getValue(MajorSubcategoryModel.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("Question 2", "Database Error!");
            }
        });

        // Question 3
        myRef.child("majors").child("categories").child("11").child("subcategories").child("0").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                questionMajors.add(dataSnapshot.getValue(MajorSubcategoryModel.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("Question 3", "Database Error!");
            }
        });

        // Question 4
        myRef.child("majors").child("categories").child("12").child("subcategories").child("0").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                questionMajors.add(dataSnapshot.getValue(MajorSubcategoryModel.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("Question 4", "Database Error!");
            }
        });

        // Question 5
        myRef.child("majors").child("categories").child("12").child("subcategories").child("2").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                questionMajors.add(dataSnapshot.getValue(MajorSubcategoryModel.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("Question 5", "Database Error!");
            }
        });

        // Question 6
        myRef.child("majors").child("categories").child("12").child("subcategories").child("3").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                questionMajors.add(dataSnapshot.getValue(MajorSubcategoryModel.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("Question 6", "Database Error!");
            }
        });

        // Question 7
        myRef.child("majors").child("categories").child("13").child("subcategories").child("2").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                questionMajors.add(dataSnapshot.getValue(MajorSubcategoryModel.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("Question 7", "Database Error!");
            }
        });

        // Question 8
        myRef.child("majors").child("categories").child("10").child("subcategories").child("1").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                questionMajors.add(dataSnapshot.getValue(MajorSubcategoryModel.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("Question 8", "Database Error!");
            }
        });

        // Question 9
        myRef.child("majors").child("categories").child("15").child("subcategories").child("0").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                questionMajors.add(dataSnapshot.getValue(MajorSubcategoryModel.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("Question 9", "Database Error!");
            }
        });

        // Question 10
        myRef.child("majors").child("categories").child("1").child("subcategories").child("0").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                questionMajors.add(dataSnapshot.getValue(MajorSubcategoryModel.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("Question 10", "Database Error!");
            }
        });

        // Question 11
        myRef.child("majors").child("categories").child("11").child("subcategories").child("1").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                questionMajors.add(dataSnapshot.getValue(MajorSubcategoryModel.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("Question 11", "Database Error!");
            }
        });

        // Question 12
        myRef.child("majors").child("categories").child("16").child("subcategories").child("0").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                questionMajors.add(dataSnapshot.getValue(MajorSubcategoryModel.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("Question 12", "Database Error!");
            }
        });

        // Question 13
        myRef.child("majors").child("categories").child("17").child("subcategories").child("0").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                questionMajors.add(dataSnapshot.getValue(MajorSubcategoryModel.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("Question 13", "Database Error!");
            }
        });

        // Question 14
        myRef.child("majors").child("categories").child("9").child("subcategories").child("1").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                questionMajors.add(dataSnapshot.getValue(MajorSubcategoryModel.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("Question 14", "Database Error!");
            }
        });

        // Question 15
        myRef.child("majors").child("categories").child("13").child("subcategories").child("1").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                questionMajors.add(dataSnapshot.getValue(MajorSubcategoryModel.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("Question 15", "Database Error!");
            }
        });

        // Question 16
        myRef.child("majors").child("categories").child("8").child("subcategories").child("0").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                questionMajors.add(dataSnapshot.getValue(MajorSubcategoryModel.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("Question 16", "Database Error!");
            }
        });

        // Question 17
        myRef.child("majors").child("categories").child("6").child("subcategories").child("1").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                questionMajors.add(dataSnapshot.getValue(MajorSubcategoryModel.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("Question 17", "Database Error!");
            }
        });

        // Question 18
        myRef.child("majors").child("categories").child("18").child("subcategories").child("0").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                questionMajors.add(dataSnapshot.getValue(MajorSubcategoryModel.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("Question 18", "Database Error!");
            }
        });

        // Question 19
        myRef.child("majors").child("categories").child("13").child("subcategories").child("3").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                questionMajors.add(dataSnapshot.getValue(MajorSubcategoryModel.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("Question 19", "Database Error!");
            }
        });

        // Question 20
        myRef.child("majors").child("categories").child("4").child("subcategories").child("2").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                questionMajors.add(dataSnapshot.getValue(MajorSubcategoryModel.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("Question 20", "Database Error!");
            }
        });

        // Question 21
        myRef.child("majors").child("categories").child("19").child("subcategories").child("0").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                questionMajors.add(dataSnapshot.getValue(MajorSubcategoryModel.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("Question 21", "Database Error!");
            }
        });

        // Question 22
        myRef.child("majors").child("categories").child("20").child("subcategories").child("0").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                questionMajors.add(dataSnapshot.getValue(MajorSubcategoryModel.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("Question 22", "Database Error!");
            }
        });

        // Question 23
        myRef.child("majors").child("categories").child("2").child("subcategories").child("3").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                questionMajors.add(dataSnapshot.getValue(MajorSubcategoryModel.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("Question 23", "Database Error!");
            }
        });

        // Question 24
        myRef.child("majors").child("categories").child("21").child("subcategories").child("0").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                questionMajors.add(dataSnapshot.getValue(MajorSubcategoryModel.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("Question 24", "Database Error!");
            }
        });

        // Question 25
        myRef.child("majors").child("categories").child("22").child("subcategories").child("0").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                questionMajors.add(dataSnapshot.getValue(MajorSubcategoryModel.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("Question 25", "Database Error!");
            }
        });

        // Question 26
        myRef.child("majors").child("categories").child("2").child("subcategories").child("0").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                questionMajors.add(dataSnapshot.getValue(MajorSubcategoryModel.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("Question 26", "Database Error!");
            }
        });

        // Question 27
        myRef.child("majors").child("categories").child("23").child("subcategories").child("0").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                questionMajors.add(dataSnapshot.getValue(MajorSubcategoryModel.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("Question 27", "Database Error!");
            }
        });

        // Question 28
        myRef.child("majors").child("categories").child("3").child("subcategories").child("1").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                questionMajors.add(dataSnapshot.getValue(MajorSubcategoryModel.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("Question 28", "Database Error!");
            }
        });

        // Question 29
        myRef.child("majors").child("categories").child("24").child("subcategories").child("0").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                questionMajors.add(dataSnapshot.getValue(MajorSubcategoryModel.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("Question 29", "Database Error!");
            }
        });

        // Question 30
        myRef.child("majors").child("categories").child("25").child("subcategories").child("0").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                questionMajors.add(dataSnapshot.getValue(MajorSubcategoryModel.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("Question 30", "Database Error!");
            }
        });

        // Question 31
        myRef.child("majors").child("categories").child("9").child("subcategories").child("2").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                questionMajors.add(dataSnapshot.getValue(MajorSubcategoryModel.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("Question 31", "Database Error!");
            }
        });
    }


    public ArrayList<MajorSubcategoryModel> checkAnswer(int question, ArrayList<MajorSubcategoryModel> list, int answer){
        MajorSubcategoryModel majorSubcategoryModel = questionMajors.get(question);
        if(answer == 0){
            if (!list.contains(majorSubcategoryModel)){
                list.remove(majorSubcategoryModel);
            }
        } else if(answer == 2) {
            if (!list.contains(majorSubcategoryModel)){
                list.add(majorSubcategoryModel);
            }
        }

        return list;
    }

}
