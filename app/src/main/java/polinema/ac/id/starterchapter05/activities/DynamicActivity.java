package polinema.ac.id.starterchapter05.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import polinema.ac.id.starterchapter05.R;
import polinema.ac.id.starterchapter05.fragments.BlueFragment;
import polinema.ac.id.starterchapter05.fragments.RedFragment;

public class DynamicActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic);
    }

    public void handlerClickLoadRedFragment(View view) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        // If fragment doesn't exist yet, create one
        if (getSupportFragmentManager().findFragmentByTag("RED_FRAGMENT") == null) {
            fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_from_left, R.anim.enter_from_left, R.anim.exit_from_right);
            fragmentTransaction.add(R.id.dynamic_fragment_placeholder, new RedFragment(), "RED_FRAGMENT");
            fragmentTransaction.commit();
            fragmentTransaction.addToBackStack(null);
        }
        else { // re-use the old fragment
            fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_from_left, R.anim.enter_from_left, R.anim.exit_from_right);
            fragmentTransaction.replace(R.id.dynamic_fragment_placeholder, getSupportFragmentManager().findFragmentByTag("RED_FRAGMENT"), "RED_FRAGMENT");
            fragmentTransaction.commit();
            fragmentTransaction.addToBackStack(null);
        }
    }

    public void handlerClickLoadBlueFragment(View view) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter_from_left,R.anim.exit_from_left,R.anim.enter_from_left,R.anim.exit_from_right);
        fragmentTransaction.add(R.id.dynamic_fragment_placeholder,new BlueFragment(),"BLUE_FRAGMENT");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
