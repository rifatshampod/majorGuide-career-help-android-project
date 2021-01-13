package fsktm.um.edu.mymajor;

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
                Toast.makeText(getActivity(), "Database error!", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getActivity(), "Database error!", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getActivity(), "Database error!", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getActivity(), "Database error!", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getActivity(), "Database error!", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getActivity(), "Database error!", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getActivity(), "Database error!", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getActivity(), "Database error!", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getActivity(), "Database error!", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getActivity(), "Database error!", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getActivity(), "Database error!", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getActivity(), "Database error!", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getActivity(), "Database error!", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getActivity(), "Database error!", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getActivity(), "Database error!", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getActivity(), "Database error!", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getActivity(), "Database error!", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getActivity(), "Database error!", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getActivity(), "Database error!", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getActivity(), "Database error!", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getActivity(), "Database error!", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getActivity(), "Database error!", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getActivity(), "Database error!", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getActivity(), "Database error!", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getActivity(), "Database error!", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getActivity(), "Database error!", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getActivity(), "Database error!", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getActivity(), "Database error!", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getActivity(), "Database error!", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getActivity(), "Database error!", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getActivity(), "Database error!", Toast.LENGTH_SHORT).show();
            }
        });
        

    }



}
