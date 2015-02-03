package wedding.karpov.invitation.widget;

import android.app.Fragment;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.TextView;

import wedding.karpov.invitation.R;

/**
 * Created by akarpov on 1/20/15.
 */
public class ExtendedLinearLayout extends LinearLayout {

    BackImageView mImageView;

    LoginLayout mLoginContainer;

    int mParentMeasuredHeight = -1;

    public static final float EXTENDED_HEIGHT_KOEFF = 2f / 2.9f;

    public ExtendedLinearLayout(Context context) {
        this(context, null);
    }

    public ExtendedLinearLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ExtendedLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public int getDesiredHeight() {
        return Math.round(getParentMeasuredHeight()
                + getParentMeasuredHeight() * EXTENDED_HEIGHT_KOEFF);
    }

    public void setLoginContainer(LoginLayout loginContainer) {
        mLoginContainer = loginContainer;
    }

    public void setImageView(BackImageView imageView) {
        mImageView = imageView;
    }

    public int getParentMeasuredHeight() {
        return mParentMeasuredHeight;
    }


    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        SavedState state = new SavedState(superState);
        state.parentMeasuredHeight = mParentMeasuredHeight;
        return state;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof SavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        mParentMeasuredHeight = ss.parentMeasuredHeight;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (mParentMeasuredHeight == -1) {
            mParentMeasuredHeight = MeasureSpec.getSize(heightMeasureSpec);
            if (mLoginContainer != null) {
                mLoginContainer.setDesiredHeight((int) (mParentMeasuredHeight));
            }
            if (mImageView != null) {
                mImageView.setDesiredHeight((int) (mParentMeasuredHeight));
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

    static class SavedState extends BaseSavedState {

        int parentMeasuredHeight;

        SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            this.parentMeasuredHeight = in.readInt();
        }

        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(this.parentMeasuredHeight);
        }

        //required field that makes Parcelables from a Parcel
        public static final Parcelable.Creator<SavedState> CREATOR =
                new Parcelable.Creator<SavedState>() {
                    public SavedState createFromParcel(Parcel in) {
                        return new SavedState(in);
                    }

                    public SavedState[] newArray(int size) {
                        return new SavedState[size];
                    }
                };
    }
}
