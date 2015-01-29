package wedding.karpov.invitation.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by akarpov on 1/20/15.
 */
public class ExtendedLinearLayout extends LinearLayout {

    BackImageView mImageView;

    int mParentMeasuredHeight = -1;

    public static final float EXTENDED_HEIGHT_KOEFF = 2f / 2.7f;

    public ExtendedLinearLayout(Context context) {
        super(context);
    }

    public ExtendedLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ExtendedLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public int getDesiredHeight() {
        return Math.round(getParentMeasuredHeight()
                + getParentMeasuredHeight() * EXTENDED_HEIGHT_KOEFF);
    }

    public void setImageView(BackImageView imageView) {
        mImageView = imageView;
    }

    public int getParentMeasuredHeight() {
        return mParentMeasuredHeight;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (mParentMeasuredHeight == -1) {
            mParentMeasuredHeight = MeasureSpec.getSize(heightMeasureSpec);
            if (mImageView != null) {
                mImageView.setDesiredHeight(mParentMeasuredHeight);
            }
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getDefaultSize(0, widthMeasureSpec);
        int height = getDesiredHeight();
        int widthSpec = MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY);
        int heightSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.AT_MOST);
        measureChildren(widthSpec, heightSpec);
        setMeasuredDimension(width, height);
    }
}
