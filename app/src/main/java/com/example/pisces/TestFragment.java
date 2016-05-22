package com.example.pisces;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TestFragment extends Fragment {
    private final static int TARGETACTIVITY_RESULTCODE = 200;

    View view;
    Button bt_StartActivityFromFragment;
    TextView tv_callBack;

    public TestFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_test, container, false);
        bt_StartActivityFromFragment = (Button) view.findViewById(R.id.Bt_StartActivityFromFragment);
        tv_callBack = (TextView) view.findViewById(R.id.TV_callBack);
        bt_StartActivityFromFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TargetActivity.class);
                startActivityForResult(intent, 200);
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TARGETACTIVITY_RESULTCODE) {
            tv_callBack.setText(MainActivity.getDate() + "  response result for TestFragment \n"+"resultCode is "+ resultCode);
        }
    }


}
