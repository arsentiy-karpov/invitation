package wedding.karpov.invitation.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import wedding.karpov.invitation.R;

/**
 * Created by arsenitykarpov on 03/02/15.
 */
public class LoginLayout extends RelativeLayout {

    private int mDesiredHeight = 0;

    public LoginLayout(Context context) {
        this(context, null);
    }

    public LoginLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public LoginLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initView(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.login_layout, this, true);

    }

    public void setDesiredHeight(int height) {
        mDesiredHeight = height;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (mDesiredHeight != 0) {
            int heightDesiredSpec = MeasureSpec
                    .makeMeasureSpec(mDesiredHeight, MeasureSpec.EXACTLY);
            super.onMeasure(widthMeasureSpec, heightDesiredSpec);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}
