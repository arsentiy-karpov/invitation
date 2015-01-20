package wedding.karpov.invitation.fragments;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.graphics.Camera;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import wedding.karpov.invitation.R;

/**
 * Created by arsenitykarpov on 15/01/15.
 */
public class MapFragment extends Fragment {

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (getMapView() != null) {
            getMapView().onDestroy();
        }
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        if (getMapView() != null) {
            getMapView().onLowMemory();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (getMapView() != null) {
            getMapView().onPause();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getMapView() != null) {
            getMapView().onResume();
            MapsInitializer.initialize(getActivity());
            setUpMap();
        }
    }

    public MapView getMapView() {
        if (getView() != null) {
            return ((MapView) getView().findViewById(R.id.mapView));
        }
        return null;
    }

    public GoogleMap getMap() {
        if (getView() != null) {
            return getMapView().getMap();
        }
        return null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_map, container, false);
        ((MapView) v.findViewById(R.id.mapView)).onCreate(savedInstanceState);
        return v;
    }

    private void setUpMap() {
        if (getMap() != null) {
            getMap().addMarker(new MarkerOptions().position(new LatLng(55.0848989, 38.7748349))
                    .title("Party hard!"));
            CameraUpdate cameraUpdate1 = CameraUpdateFactory.newLatLngZoom(
                    new LatLng(55.0848989, 38.7748349), 14.0f);
            getMap().moveCamera(cameraUpdate1);
            CameraUpdate cameraUpdate2 = CameraUpdateFactory.scrollBy(0, -100);
            getMap().animateCamera(cameraUpdate2);
        }
    }
}
