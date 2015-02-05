package wedding.karpov.invitation;

/**
 * Created by arsenitykarpov on 12/01/15.
 */

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;

import java.io.Serializable;

public class OverlappingScreen extends Fragment {

    public static final OverlappingScreen newInstance(
            InformationScreenGenerator informationScreenGenerator) {
        OverlappingScreen overlappingInformationScreen = new OverlappingScreen();
        overlappingInformationScreen.setInformationScreenGenerator(informationScreenGenerator);
        overlappingInformationScreen.setRetainInstance(true);
        return overlappingInformationScreen;
    }

    public static interface OnAnimationListener {

        void onEnd();

        void onStart();
    }

    private InformationScreenGenerator mInformationScreenGenerator;

    private ClosingLayout mAttachedView;

    public void setInformationScreenGenerator(
            InformationScreenGenerator informationScreenGenerator) {
        mInformationScreenGenerator = informationScreenGenerator;
    }

    @Override
    public void onStart() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
        layoutParams.format = PixelFormat.TRANSLUCENT;
        if (mAttachedView == null) {
            mAttachedView = new ClosingLayout(getActivity());
        }
        if (mInformationScreenGenerator != null) {
            mAttachedView.addView(mInformationScreenGenerator.getView(this));
        }
        ((WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE))
                .addView(mAttachedView, layoutParams);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0f, 1f);
        alphaAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        alphaAnimation.setDuration(1000);
        if (mAttachedView.getChildAt(0) != null) {
            mAttachedView.getChildAt(0).startAnimation(alphaAnimation);
        }
        super.onStart();
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null && savedInstanceState.getSerializable("screen") != null
                && mInformationScreenGenerator == null) {
            mInformationScreenGenerator = (InformationScreenGenerator) savedInstanceState
                    .getSerializable("screen");
        }
        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putSerializable("screen", mInformationScreenGenerator);
        super.onSaveInstanceState(outState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            if (savedInstanceState != null && savedInstanceState.getSerializable("screen") != null
                    && mInformationScreenGenerator == null) {
                mInformationScreenGenerator = (InformationScreenGenerator) savedInstanceState
                        .getSerializable("screen");
            }
        }
        return null;
    }

    public void show(FragmentManager fragmentManager) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(this, "login_screen");
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAttachedView != null) {
            ((WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE))
                    .removeView(mAttachedView);
        }
        mAttachedView = null;
    }

    public void detach(final OnAnimationListener listener) {
        if (mAttachedView != null) {
            ((WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE))
                    .removeView(mAttachedView);
            mAttachedView = null;
        }
        getFragmentManager().beginTransaction().remove(OverlappingScreen.this)
                .commitAllowingStateLoss();

    }

    private class ClosingLayout extends FrameLayout {

        public ClosingLayout(Context context) {
            super(context);
        }

        public ClosingLayout(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public ClosingLayout(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
        }

        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        public ClosingLayout(Context context, AttributeSet attrs, int defStyleAttr,
                int defStyleRes) {
            super(context, attrs, defStyleAttr, defStyleRes);
        }

    }

    public static interface InformationScreenGenerator extends Serializable {

        public View getView(OverlappingScreen overlappingInformationScreen);
    }
}
