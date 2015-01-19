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
import android.widget.ImageView;
import android.widget.Toast;

import wedding.karpov.invitation.fragments.WhereFragment;
import wedding.karpov.invitation.fragments.WhoFragment;
import wedding.karpov.invitation.widget.SlidingTabLayout;


public class Main extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    private Toolbar mToolbar;

    private SlidingTabLayout mSlidingTabLayout;

    private ViewPager mViewPager;

    private ImageView mLogo;

    private View mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);

        }
        mLogo = (ImageView) findViewById(R.id.toolbar_image);
        mContainer = findViewById(R.id.container);
        setViewPager();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem item = menu.add(0, R.id.action_example, 1, R.string.action_example)
                .setIcon(R.drawable.ic_cake_white_24dp);
        MenuItemCompat.setShowAsAction(item, MenuItem.SHOW_AS_ACTION_IF_ROOM);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_example) {
            Toast.makeText(this, "Допольнительное инфо будет тут", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void moveUp() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int heightPixels = displayMetrics.heightPixels;
        ValueAnimator a = ObjectAnimator
                .ofFloat(mContainer.getTranslationY(), mContainer.getTranslationY() - heightPixels / 1.5f);
        a.setDuration(400);
        a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mContainer.setTranslationY((Float) valueAnimator.getAnimatedValue());
            }
        });
        a.start();
    }

    private void moveDown() {
        ValueAnimator a = ObjectAnimator
                .ofFloat(mContainer.getTranslationY(), 0);
        a.setDuration(400);
        a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mContainer.setTranslationY((Float) valueAnimator.getAnimatedValue());
            }
        });
        a.start();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        showLoginFragment();

    }

    public void showLoginFragment() {
        if (getSupportFragmentManager().findFragmentByTag(OverlappingScreen.class.getName()) == null
                && ((InvitationApplication) getApplication()).getGuest() == null) {
            hideViewPager();
            moveDown();
            OverlappingScreen.newInstance(new LoginScreenGenerator())
                    .show(getSupportFragmentManager());
        }
    }

    public void updateGuestContent() {
        showViewPager();
        mViewPager.getAdapter().notifyDataSetChanged();
        moveUp();
    }

    public void hideViewPager() {
        mViewPager.setVisibility(View.GONE);
        mSlidingTabLayout.setVisibility(View.GONE);
    }

    public void showViewPager() {
        mSlidingTabLayout.setVisibility(View.VISIBLE);
        mViewPager.setVisibility(View.VISIBLE);
    }

    public void setViewPager() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(new SamplePagerAdapter(getSupportFragmentManager()));
        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
        mSlidingTabLayout.setViewPager(mViewPager);
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
