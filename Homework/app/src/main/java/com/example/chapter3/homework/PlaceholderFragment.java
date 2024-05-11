package com.example.chapter3.homework;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.airbnb.lottie.LottieAnimationView;

public class PlaceholderFragment extends Fragment {
    private LottieAnimationView animationView;

//    private ListView listView;

    private static final String EXTRA_EXIT_ANIM = "extra_exit_anim";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        View view = inflater.inflate(R.layout.fragment_placeholder, container, false);
        animationView = view.findViewById(R.id.animation_view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
//                Intent intent = new Intent(getActivity(), getActivity().getClass());
//                intent.putExtra(EXTRA_EXIT_ANIM, R.anim.fade_out);
//                startActivity(intent);
//                getActivity().overridePendingTransition(R.anim.fade_in, 0);
//                animationView.setVisibility(View.INVISIBLE);
//                listView.setVisibility(View.VISIBLE);
                getFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.fade_in,R.anim.fade_out)
                        .replace(R.id.fragment_container, new OneFragment())
                        .addToBackStack(null).commit();
                animationView.setVisibility(View.INVISIBLE);
            }
        }, 5000);
    }
}

