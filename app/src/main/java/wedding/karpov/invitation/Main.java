package wedding.karpov.invitation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Typeface;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;

import wedding.karpov.invitation.fragments.QuestionFragment;
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

    private BackImageView mBackImage;

    private ExtendedLinearLayout mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            SpannableString builder = new SpannableString("Пригласительный");
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
        mContainer.setDisplayHeight(getWindowHeight());
        mContainer.setImageView(mBackImage);
        setViewPager();
    }

    private int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    private int getNavigationBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        if (ViewConfiguration.get(this).hasPermanentMenuKey()) {
            return 0;
        } else {
            return result;
        }
    }

    private int getWindowHeight() {
        return getResources().getDisplayMetrics().heightPixels;
    }

    private int getVisibleWindowHeight() {
        return getWindowHeight() - getNavigationBarHeight();
    }

    private int getVisibleWindowTop() {
        return getNavigationBarHeight();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem item = menu.add(0, R.id.action_example, 1, getString(R.string.action_example) + (
                ((InvitationApplication) getApplication()).getGuest() != null
                        ? ((InvitationApplication) getApplication()).getGuest().getName() : ""))
                .setIcon(R.drawable.ic_cake_black_24dp);
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


    public void updateGuestContent() {
        mToolbar.setVisibility(View.VISIBLE);
        mViewPager.getAdapter().notifyDataSetChanged();
        moveUp();
    }

    public void setViewPager() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(new SamplePagerAdapter(getSupportFragmentManager()));
        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
        mSlidingTabLayout.setViewPager(mViewPager);
    }

    private void moveUp() {
        ValueAnimator a = ObjectAnimator
                .ofFloat(mContainer, "translationY", mContainer.getTranslationY(),
                        mContainer.getTranslationY() - mContainer.getParentMeasuredHeight()
                                * ExtendedLinearLayout.EXTENDED_HEIGHT_KOEFF);
        a.setDuration(1000);
        a.setInterpolator(new AnticipateInterpolator(2f));
        a.start();
    }

    private void moveDown() {
        ValueAnimator a = ObjectAnimator
                .ofFloat(mContainer, "translationY", mContainer.getTranslationY(), 0);
        a.setDuration(1000);
        a.setInterpolator(new DecelerateInterpolator(2f));
        a.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        showLoginFragment();
    }

    class SamplePagerAdapter extends FragmentPagerAdapter {

        public SamplePagerAdapter(FragmentManager fm) {
            super(fm);
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
                    return "Вопрос...";
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
                    return new QuestionFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 4;
        }

    }

}
