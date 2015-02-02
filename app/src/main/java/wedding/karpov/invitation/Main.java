package wedding.karpov.invitation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Typeface;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.ActionBarActivity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.DecelerateInterpolator;

import wedding.karpov.invitation.fragments.QuestionCategoryFragment;
import wedding.karpov.invitation.fragments.QuestionContainerFragment;
import wedding.karpov.invitation.fragments.WhereFragment;
import wedding.karpov.invitation.fragments.WhoFragment;
import wedding.karpov.invitation.objects.CustomTypefaceSpan;
import wedding.karpov.invitation.widget.BackImageView;
import wedding.karpov.invitation.widget.ExtendedLinearLayout;
import wedding.karpov.invitation.widget.SlidingTabLayout;


public class Main extends ActionBarActivity {

    private Toolbar mToolbar;

    private SlidingTabLayout mSlidingTabLayout;

    private ViewPager mViewPager;

    private SamplePagerAdapter mViewPagerAdapter;

    private BackImageView mBackImage;

    private boolean mIsAlreadyGlobalLayout = false;

    private ExtendedLinearLayout mContainer;

    private boolean mIsMovedDown = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            SpannableString builder = new SpannableString("Приглашение");
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(
                    getResources().getColor(R.color.title_color));
            StyleSpan styleSpan = new StyleSpan(Typeface.NORMAL);
            Typeface font = Typeface.createFromAsset(getAssets(), "Lora/Lora-Bold.ttf");
            Typeface font2 = Typeface
                    .createFromAsset(getAssets(), "Marck_Script/MarckScript-Regular.ttf");
            Typeface font3 = Typeface.createFromAsset(getAssets(), "Neucha/Neucha.ttf");
            Typeface font4 = Typeface
                    .createFromAsset(getAssets(), "Ruslan_Display/RuslanDisplay.ttf");
            Typeface font5 = Typeface
                    .createFromAsset(getAssets(), "Seymour_One/SeymourOne-Regular.ttf");
            CustomTypefaceSpan typefaceSpan = new CustomTypefaceSpan("", font2);
            builder.setSpan(styleSpan, 0, builder.length(), Spanned.SPAN_COMPOSING);
            builder.setSpan(foregroundColorSpan, 0, builder.length(), Spanned.SPAN_COMPOSING);
            builder.setSpan(typefaceSpan, 0, builder.length(), Spanned.SPAN_COMPOSING);
//            builder.setSpan(new RelativeSizeSpan(1.2f), 0, builder.length(),
//                    Spanned.SPAN_COMPOSING);

            getSupportActionBar().setTitle(builder);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
        mBackImage = (BackImageView) findViewById(R.id.toolbar_image);
        mContainer = (ExtendedLinearLayout) findViewById(R.id.container);
        mContainer.setImageView(mBackImage);
        mContainer.invalidate();
        if (savedInstanceState != null && savedInstanceState.getFloat("tY", -666f) != -666f) {
            mContainer.setTranslationY(savedInstanceState.getFloat("tY"));
        }
        setViewPager();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem item = menu.add(0, R.id.action_example, 1,
                (((InvitationApplication) getApplication()).getGuest() != null ?
                        getString(R.string.action_example)
                                + ((InvitationApplication) getApplication()).getGuest().getName()
                        : "")).setIcon(R.drawable.ic_cake_black_24dp);
        MenuItemCompat.setShowAsAction(item, MenuItem.SHOW_AS_ACTION_IF_ROOM);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_example) {
            ((InvitationApplication) getApplication()).setGuest(null);
            showLoginFragment();
        }
        if (id == android.R.id.home) {
            ((InvitationApplication) getApplication()).setGuest(null);
            showLoginFragment();
        }

        return super.onOptionsItemSelected(item);
    }

    public void showLoginFragment() {
        if (((InvitationApplication) getApplication()).getGuest() == null) {
            if (getSupportFragmentManager().findFragmentByTag("login_screen") == null) {
                if (mToolbar != null) {
                    mToolbar.setVisibility(View.GONE);
                    moveDown();
                }
                OverlappingScreen.newInstance(new LoginScreenGenerator())
                        .show(getSupportFragmentManager());
            }
        } else {
            updateGuestContent();
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.getFloat("tY", -666f) != -666f) {
            mContainer.setTranslationY(savedInstanceState.getFloat("tY"));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putFloat("tY", mContainer.getTranslationY());
        super.onSaveInstanceState(outState);
    }

    public void updateGuestContent() {
        mToolbar.setVisibility(View.VISIBLE);
        mViewPager.getAdapter().notifyDataSetChanged();
        moveUp();
    }

    public void setViewPager() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        if (mViewPagerAdapter == null) {
            mViewPagerAdapter = new SamplePagerAdapter(getFragmentManager());
        }
        mViewPager.setAdapter(mViewPagerAdapter);
        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
        mSlidingTabLayout.setViewPager(mViewPager);
    }

    private boolean isMovedDown() {
        return mIsMovedDown;
    }

    private void moveUp() {
        if (isMovedDown()) {
            ValueAnimator a = ObjectAnimator
                    .ofFloat(mContainer, "translationY", mContainer.getTranslationY(),
                            mContainer.getTranslationY() - mContainer.getParentMeasuredHeight()
                                    * ExtendedLinearLayout.EXTENDED_HEIGHT_KOEFF);
            a.setDuration(1000);
            a.setInterpolator(new AnticipateInterpolator(2f));
            a.start();
            mIsMovedDown = false;
        }
    }

    private void moveDown() {
        if (!isMovedDown()) {
            ValueAnimator a = ObjectAnimator.ofFloat(mContainer.getTranslationY(), 0);
            a.setDuration(700);
            a.setInterpolator(new DecelerateInterpolator(2f));
            a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    mContainer.setTranslationY((Float) valueAnimator.getAnimatedValue());
                }
            });
            a.start();
            mIsMovedDown = true;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mContainer.getViewTreeObserver()
                .addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        if (!mIsAlreadyGlobalLayout) {
                            showLoginFragment();
                            mIsAlreadyGlobalLayout = true;
                        }
                    }
                });
    }

//    @Override
//    public void onBackPressed() {
//
//        // We retrieve the fragment manager of the activity
//        FragmentManager frgmtManager = getFragmentManager();
//        FragmentManager childFragmentManager = null;
//        // We retrieve the fragment container showed right now
//        // The viewpager assigns tags to fragment automatically like this
//        // mPager is our ViewPager instance
//        int id = mViewPager.getId();
//        int currentItem = mViewPager.getCurrentItem();
//
//        Fragment fragment = mViewPagerAdapter.getItem(currentItem);
//        if (fragment instanceof QuestionContainerFragment) {
//            childFragmentManager = fragment.getChildFragmentManager();
//        }
//
//        if (childFragmentManager != null && childFragmentManager.getBackStackEntryCount() == 0) {
//            super.onBackPressed();
//        } else {
//            childFragmentManager.popBackStack();
//        }
//    }

    class SamplePagerAdapter extends FragmentPagerAdapter {

        FragmentManager mFragmentManager;

        Fragment mQuestionFragment;

        public SamplePagerAdapter(FragmentManager fm) {
            super(fm);
            mFragmentManager = fm;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Что?";
                case 1:
                    return "Где?";
                case 2:
                    return "Карта";
                case 3:
                    return "Вопрос";
            }
            return "";
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new WhoFragment();
                case 1:
                    return new WhereFragment();
                case 2:
                    return new wedding.karpov.invitation.fragments.MapFragment();
                case 3:
                    mQuestionFragment = QuestionCategoryFragment.newInstance();
                    return mQuestionFragment;
            }
            return null;
        }

        @Override
        public int getCount() {
            return 4;
        }

    }

}
