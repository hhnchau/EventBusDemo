package info.kingpes.eventbusdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by kingpes on 9/29/18.
 */

public class Frgment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);


        ViewPager viewPager = view.findViewById(R.id.viewPager);
        ViewpagerAdapter adapter = new ViewpagerAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(new Frgment1());
        adapter.addFragment(new Frgment2());
        adapter.addFragment(new Frgment3());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);


        return view;
    }
}
