package com.tilak.apps.airlineapp.home.view;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.tilak.apps.airlineapp.R;

public class AirlinesHomeActivity extends AppCompatActivity implements AirlineListFragment.OnAirlinesListItemSelection {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airlines_home);
        loadFragment(AirlineListFragment.newInstance(), false);
    }

    private void loadFragment(Fragment fragment, boolean backStack) {
        FragmentTransaction fmTransaction = getFragmentManager().beginTransaction();
        fmTransaction.add(R.id.container_frame_layout, fragment, fragment.getClass().getSimpleName());
        if (backStack) {
            fmTransaction.addToBackStack(null);
        }
        fmTransaction.commit();
    }

    @Override
    public void onAirlineListItemSelection(int position) {

    }
}
