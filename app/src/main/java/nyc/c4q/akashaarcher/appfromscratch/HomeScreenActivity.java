package nyc.c4q.akashaarcher.appfromscratch;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class HomeScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        HomeScreenFragment homeFragment = new HomeScreenFragment();
        FragmentTransaction homeFragTransaction = getSupportFragmentManager().beginTransaction();
        homeFragTransaction.add(R.id.main_container, homeFragment);
        homeFragTransaction.commit();
    }


}
