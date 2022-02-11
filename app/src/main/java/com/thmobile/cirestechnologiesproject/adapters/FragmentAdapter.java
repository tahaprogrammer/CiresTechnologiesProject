package com.thmobile.cirestechnologiesproject.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.thmobile.cirestechnologiesproject.fragments.AutomobileFragment;
import com.thmobile.cirestechnologiesproject.fragments.BusinessFragment;
import com.thmobile.cirestechnologiesproject.fragments.ScienceFragment;
import com.thmobile.cirestechnologiesproject.fragments.SportsFragment;
import com.thmobile.cirestechnologiesproject.fragments.StartupFragment;
import com.thmobile.cirestechnologiesproject.fragments.TechnologyFragment;
import com.thmobile.cirestechnologiesproject.utils.Utils;

public class FragmentAdapter extends FragmentStateAdapter {

    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 0:
                return new ScienceFragment();
            case 1:
                return new BusinessFragment();
            case 2:
                return new SportsFragment();
            case 3:
                return new TechnologyFragment();
            case 4:
                return new StartupFragment();
            case 5:
                return new AutomobileFragment();
            default:
                return new ScienceFragment();
        }
    }



    @Override
    public int getItemCount() {
        return Utils.NUMBER_OF_TABS;
    }
}