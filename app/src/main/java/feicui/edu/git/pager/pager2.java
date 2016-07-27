package feicui.edu.git.pager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import butterknife.Bind;
import butterknife.ButterKnife;
import feicui.edu.git.R;

/**
 * Created by 王小川 on 2016/7/26.
 */
public class pager2 extends FrameLayout {
    @Bind(R.id.ivBubble1)
    ImageView ivBubble1;
    @Bind(R.id.ivBubble2)
    ImageView ivBubble2;
    @Bind(R.id.ivBubble3)
    ImageView ivBubble3;

    public void getLayout() {
        LayoutInflater.from(getContext()).inflate(R.layout.content_pager_2, this, true);
        ButterKnife.bind(this);
        ivBubble1.setVisibility(View.GONE);
        ivBubble2.setVisibility(View.GONE);
        ivBubble3.setVisibility(View.GONE);
    }

    public pager2(Context context) {
        this(context, null);
    }

    public pager2(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public pager2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getLayout();
    }

    public void showAnima() {
        if(ivBubble1.getVisibility() != View.VISIBLE){
            postDelayed(new Runnable() {
                @Override public void run() {
                    ivBubble1.setVisibility(View.VISIBLE);
                    YoYo.with(Techniques.FadeInLeft).duration(300).playOn(ivBubble1);
                }
            }, 50);
            postDelayed(new Runnable() {
                @Override public void run() {
                    ivBubble2.setVisibility(View.VISIBLE);
                    YoYo.with(Techniques.FadeInLeft).duration(300).playOn(ivBubble2);
                }
            }, 550);
            postDelayed(new Runnable() {
                @Override public void run() {
                    ivBubble3.setVisibility(View.VISIBLE);
                    YoYo.with(Techniques.FadeInLeft).duration(300).playOn(ivBubble3);
                }
            }, 1050);
        }
    }
}
