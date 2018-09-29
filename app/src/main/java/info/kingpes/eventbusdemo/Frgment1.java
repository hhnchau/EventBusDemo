package info.kingpes.eventbusdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by kingpes on 9/29/18.
 */

public class Frgment1 extends Fragment {
    TextView txt;
    Button btn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);
        txt = view.findViewById(R.id.txt1);
        btn = view.findViewById(R.id.btn1);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new Bus("Fragment 1"));
            }
        });


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

        //Foreground
//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onBus(Bus bus){
//        txt.setText(bus.getS());
//    }
        //Foreground
    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onBus(Bus bus){
        txt.setText(bus.getS());
    }

        //Do in Background
//    @Subscribe(threadMode = ThreadMode.BACKGROUND)
//    public void onBus(Bus bus){
//        txt.setText(bus.getS());
//    }
        //Do in background
//    @Subscribe(threadMode = ThreadMode.ASYNC)
//    public void onBus(Bus bus){
//        txt.setText(bus.getS());
//    }


}
