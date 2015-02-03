package wedding.karpov.invitation.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by arsenitykarpov on 29/01/15.
 */
public class BackImageView extends ImageView {

    private int mDesiredHeight = 0;

    public BackImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BackImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setDesiredHeight(int height) {
        mDesiredHeight = height;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (mDesiredHeight != 0) {
            int heightDesiredSpec = MeasureSpec
                    .makeMeasureSpec(mDesiredHeight, MeasureSpec.EXACTLY);
            setMeasuredDimension(widthMeasureSpec, heightDesiredSpec);
        }
    }
}
