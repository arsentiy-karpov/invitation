package wedding.karpov.invitation;

import android.app.Activity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import wedding.karpov.invitation.fragments.MapFragment;
import wedding.karpov.invitation.fragments.WhereFragment;
import wedding.karpov.invitation.fragments.WhoFragment;
import wedding.karpov.invitation.widget.SlidingTabLayout;


public class Main extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    private Toolbar mToolbar;

    private SlidingTabLayout mSlidingTabLayout;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        // Get the ViewPager and set it's PagerAdapter so that it can display items
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(new SamplePagerAdapter(getSupportFragmentManager()));

        // Give the SlidingTabLayout the ViewPager, this must be done AFTER the ViewPager has had
        // it's PagerAdapter set.
        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
        mSlidingTabLayout.setViewPager(mViewPager);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (getSupportFragmentManager().findFragmentByTag(
                OverlappingScreen.class.getName()) == null) {
            OverlappingScreen.newInstance(new LoginScreenGenerator()).show(getSupportFragmentManager());
        }
    }

    public void showGuestContent() {
        mViewPager.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new WhoFragment();
                case 1:
                    return new WhereFragment();
                case 2:
                    return new MapFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

    }

}
