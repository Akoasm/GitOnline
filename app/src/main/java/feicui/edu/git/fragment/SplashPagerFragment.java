package feicui.edu.git.fragment;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.BindColor;
import butterknife.ButterKnife;
import feicui.edu.git.R;
import feicui.edu.git.adapter.SplashPagerAdapter;
import feicui.edu.git.pager.pager2;
import me.relex.circleindicator.CircleIndicator;

/**
 * Created by 王小川 on 2016/7/26.
 */
public class SplashPagerFragment extends Fragment {
    @Bind(R.id.ivPhoneBlank) ImageView ivPhoneBlank;
    @Bind(R.id.ivPhoneFont) ImageView ivPhoneFont;
    @Bind(R.id.layoutPhoneInner) FrameLayout layoutPhoneInner;
    @Bind(R.id.layoutPhone) FrameLayout layoutPhone;
    @Bind(R.id.viewPager) ViewPager viewPager;
    @Bind(R.id.indicator) CircleIndicator indicator;
    @Bind(R.id.content) FrameLayout content;

    @BindColor(R.color.colorGreen) int colorGreen;
    @BindColor(R.color.colorRed) int colorRed;
    @BindColor(R.color.colorYellow) int colorYellow;
    private SplashPagerAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_splash_pager,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
        adapter = new SplashPagerAdapter(getContext());
        viewPager.setAdapter(adapter);
        indicator.setViewPager(viewPager);
        viewPager.addOnPageChangeListener(pageColorlistner);
        viewPager.addOnPageChangeListener(pagePhonelistner);
    }
    private ViewPager.OnPageChangeListener pageColorlistner = new ViewPager.OnPageChangeListener() {
            final ArgbEvaluator argbEvaluator = new ArgbEvaluator();
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    if(position == 0){
                        int color = (int) argbEvaluator.evaluate(positionOffset,colorGreen,colorRed);
                        content.setBackgroundColor(color);
                        return;
                    }
                if(position == 1){
                    int color = (int) argbEvaluator.evaluate(positionOffset,colorRed,colorYellow);
                    content.setBackgroundColor(color);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };

    private ViewPager.OnPageChangeListener pagePhonelistner = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            if(position == 0){
                float scale = 0.3f + positionOffset * 0.7f;
                layoutPhone.setScaleX(scale);
                layoutPhone.setScaleY(scale);
                int scroll = (int) ((positionOffset - 1) * 100);
                layoutPhone.setTranslationX(scroll);
                ivPhoneFont.setAlpha(positionOffset);
                    return;
            }
            if (position == 1) {
                layoutPhone.setTranslationX(-positionOffsetPixels);
            }
        }

        @Override
        public void onPageSelected(int position) {
            // 当显示出最后一个pager时，播放它自己的动画
            if(position == 2) {
                pager2 pager2= (feicui.edu.git.pager.pager2) adapter.getView(2);
                pager2.showAnima();
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
