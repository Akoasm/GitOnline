package feicui.edu.git.pager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import feicui.edu.git.R;

/**
 * Created by 王小川 on 2016/7/26.
 */
public class pager1 extends FrameLayout {
    public void getLayout(){
        LayoutInflater.from(getContext()).inflate(R.layout.content_pager_1, this, true);
    }
    public pager1(Context context) {
        this(context,null);
    }

    public pager1(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public pager1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getLayout();
    }
}
