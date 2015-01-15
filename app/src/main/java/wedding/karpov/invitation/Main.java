package wedding.karpov.invitation;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;
import java.util.zip.GZIPOutputStream;

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

        setViewPager();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onStart() {
        showLoginFragment();
        super.onStart();
    }

    public void showLoginFragment() {
        if (getSupportFragmentManager().findFragmentByTag(
                OverlappingScreen.class.getName()) == null
                && ((InvitationApplication) getApplication()).getGuest() == null) {
            hideViewPager();
            OverlappingScreen.newInstance(new LoginScreenGenerator())
                    .show(getSupportFragmentManager());
        }
    }

    public void updateGuestContent() {
        showViewPager();
        mViewPager.getAdapter().notifyDataSetChanged();
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

        private GoogleMap mMap;

        private SupportMapFragment mSupportMapFragment;

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
                    if (mSupportMapFragment == null) {
                        mSupportMapFragment = SupportMapFragment.newInstance();
                    }
                    return mSupportMapFragment;
            }
            return null;
        }

        @Override
        public void finishUpdate(ViewGroup container) {
            super.finishUpdate(container);
            setUpMapIfNeeded();
        }

        @Override
        public int getCount() {
            return 3;
        }

//        @Override
//        public int getItemPosition(Object object) {
//            return POSITION_NONE;
//        }

        private void setUpMapIfNeeded() {
            // Do a null check to confirm that we have not already instantiated the map.
            if (mMap == null && mSupportMapFragment != null) {
                // Try to obtain the map from the SupportMapFragment.
                mMap = mSupportMapFragment.getMap();
                // Check if we were successful in obtaining the map.
                if (mMap != null) {
                    setUpMap();
                }
            }
        }

        private void setUpMap() {
            mMap.addMarker(new MarkerOptions().position(new LatLng(55.0848989, 38.7748349)).title(
                    "Party hard!"));
            mMap.animateCamera(CameraUpdateFactory
                    .newLatLngZoom(new LatLng(55.0848989, 38.7748349), 18.0f));
        }
    }

}
