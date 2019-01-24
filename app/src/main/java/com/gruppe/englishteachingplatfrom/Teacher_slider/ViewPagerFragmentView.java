package com.gruppe.englishteachingplatfrom.Teacher_slider;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gruppe.englishteachingplatfrom.R;
import com.gruppe.englishteachingplatfrom.SingletonData;

import java.util.ArrayList;


public class ViewPagerFragmentView extends Fragment {

    private ViewPager mViewPager;

    private ViewPagerAdapterController mAdapter;

    private ArrayList<Integer> img = new ArrayList<Integer>();

    private ArrayList<ViewPagerModel> mContents;

    private SingletonData info;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_viewpager_list, container, false);

        info = SingletonData.getInstance();

        mViewPager = (ViewPager) view.findViewById(R.id.ViewPager);

        mContents = new ArrayList<>();

        //Created for counting images

        int images[] = {R.drawable.fire, R.drawable.water, R.drawable.air, R.drawable.earth};

        img.add(R.drawable.fire);
        img.add(R.drawable.water);
        img.add(R.drawable.air);
        img.add(R.drawable.earth);

       // String names[] = {"Smith", "Johnson", "David", "Adam"};

        info.getNames().add("Zero");
        info.getNames().add("Zero");
        info.getNames().add("Zero");
        info.getNames().add("Zero");

       // String desig[] = {"English Teacher"};
        info.getProf().add("FireDragon");
        info.getProf().add("WaterDragon");
        info.getProf().add("AirDragon");
        info.getProf().add("EarthDragon");

       // String place[] = {"USA", "DENMARK", "SWEDEN"};

        info.getNation().add("FireDragon");
        info.getNation().add("WaterDragon");
        info.getNation().add("AirDragon");
        info.getNation().add("EarthDragon");

        ArrayList<String> names = info.getNames();
        ArrayList<String> prof = info.getProf();
        ArrayList<String> nation = info.getNation();
        for (int i = 0; i < images.length; i++){

            ViewPagerModel viewPagerModel = new ViewPagerModel();

            viewPagerModel.images = images[i];

            viewPagerModel.names = names.get(i);

            viewPagerModel.desig = prof.get(i);

            viewPagerModel.place = nation.get(i);

            mContents.add(viewPagerModel);

        }

        mAdapter = new ViewPagerAdapterController(mContents, getActivity());
        mViewPager.setPageTransformer(true, new ViewPagerStack());
        mViewPager.setOffscreenPageLimit(3);


        mViewPager.setAdapter(mAdapter);

        return view;
    }

    public int getCurrentPosition(){
        return mViewPager.getCurrentItem();
    }

    public int getCurrentPic(){

        return img.get(mViewPager.getCurrentItem());
    }

    private class ViewPagerStack implements ViewPager.PageTransformer {

        @Override
        public void transformPage(View page, float position) {

            if (position >= 0) {

                page.setScaleX(0.8f - 0.05f * position);
                page.setScaleY(0.8f);

                page.setTranslationX(-page.getWidth() * position);

                page.setTranslationY(-30 * position);

            }

        }

    }
}
