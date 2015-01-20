package wedding.karpov.invitation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import wedding.karpov.invitation.fragments.MapFragment;
import wedding.karpov.invitation.fragments.WhereFragment;
import wedding.karpov.invitation.fragments.WhoFragment;
import wedding.karpov.invitation.widget.ExtendedLinearLayout;
import wedding.karpov.invitation.widget.SlidingTabLayout;


public class Main extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    private Toolbar mToolbar;

    private SlidingTabLayout mSlidingTabLayout;

    private ViewPager mViewPager;

    private ImageView mLogo;

    private ExtendedLinearLayout mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

        }
        mLogo = (ImageView) findViewById(R.id.toolbar_image);
        mContainer = (ExtendedLinearLayout) findViewById(R.id.container);
        mContainer.setDisplayHeight(getResources().getDisplayMetrics().heightPixels);
        setViewPager();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuItem item = menu.add(0, R.id.action_example, 1, R.string.action_example)
//                .setIcon(R.drawable.ic_cake_black_24dp);
//        MenuItemCompat.setShowAsAction(item, MenuItem.SHOW_AS_ACTION_IF_ROOM);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_example) {
            Toast.makeText(this, "Допольнительное инфо будет тут", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == android.R.id.home) {
            ((InvitationApplication)getApplication()).setGuest(null);
            showLoginFragment();
        }

        return super.onOptionsItemSelected(item);
    }

    public void showLoginFragment() {
        if (getSupportFragmentManager().findFragmentByTag(OverlappingScreen.class.getName()) == null
                && ((InvitationApplication) getApplication()).getGuest() == null) {
            mToolbar.setVisibility(View.GONE);
            moveDown();
            OverlappingScreen.newInstance(new LoginScreenGenerator())
                    .show(getSupportFragmentManager());
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
                        mContainer.getTranslationY()
                                - getResources().getDisplayMetrics().heightPixels * 2f / 2.8f);
        a.setDuration(1000);
        a.setInterpolator(new OvershootInterpolator(2f));
        a.start();
    }

    private void moveDown() {
        ValueAnimator a = ObjectAnimator
                .ofFloat(mContainer.getTranslationY(), 0);
        a.setDuration(700);
        a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mContainer.setTranslationY((Float) valueAnimator.getAnimatedValue());
            }
        });
        a.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        showLoginFragment();
    }


    @Override
    public void onNavigationDrawerItemSelected(int position) {

    }

    class SamplePagerAdapter extends FragmentPagerAdapter {

        public SamplePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Кто";
                case 1:
                    return "Где";
                case 2:
                    return "Карта";
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
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

    }

}
