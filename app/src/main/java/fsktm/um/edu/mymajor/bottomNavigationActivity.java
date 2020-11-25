package fsktm.um.edu.mymajor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class bottomNavigationActivity extends AppCompatActivity {

    BottomNavigationView bnv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer,new HomeFragment()).commit();

        bnv=findViewById(R.id.bottomNavigation);

        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment temp = null;

                switch(item.getItemId()){
                    case R.id.menu_home: temp = new HomeFragment();
                        break;

                    case R.id.menu_account: temp = new AccountFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer,temp).commit();

                return true;
            }
        });


    }
}