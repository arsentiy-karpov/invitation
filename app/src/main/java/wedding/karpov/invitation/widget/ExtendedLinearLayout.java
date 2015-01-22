package wedding.karpov.invitation.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by akarpov on 1/20/15.
 */
public class ExtendedLinearLayout extends LinearLayout {

    int mDisplayHeight;

    public ExtendedLinearLayout(Context context) {
        super(context);
    }

    public ExtendedLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ExtendedLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setDisplayHeight(int displayHeight) {
        mDisplayHeight = displayHeight;
    }

    private int getDesiredHeight() {
        return Math.round(mDisplayHeight * 1.73f);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = getDefaultSize(0, widthMeasureSpec);
        int height = getDesiredHeight();
        int widthSpec = MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY);
        int heightSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.AT_MOST);
        measureChildren(widthSpec, heightSpec);
        setMeasuredDimension(width, height);
    }
}
