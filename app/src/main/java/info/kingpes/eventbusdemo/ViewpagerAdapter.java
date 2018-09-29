package info.kingpes.eventbusdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kingpes on 9/29/18.
 */

public class ViewpagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> listFragment = new ArrayList<>();

    public ViewpagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }


    public void addFragment(Fragment fragment){
        listFragment.add(fragment);
    }

}
