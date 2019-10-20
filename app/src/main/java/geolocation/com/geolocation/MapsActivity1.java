package geolocation.com.geolocation;

import androidx.fragment.app.FragmentActivity;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity1 extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private Marker markerPrueba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps1);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //setZoomControlsEnabled
        UiSettings uiSettings = mMap.getUiSettings();

        uiSettings.setZoomControlsEnabled(true);
        uiSettings.setCompassEnabled(true);
        //uiSettings.setMyLocationEnabled(true);
        uiSettings.setMapToolbarEnabled(true);

        LatLng ubication;

        // Add a marker in Sydney and move the camera
        ubication = new LatLng(-16.4955455, -68.1336229);
        mMap.addMarker(new MarkerOptions().position(ubication)
                .title("La Paz")
                .snippet("Ciudad de La Paz, Bolivia")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.mexico)));

        ubication = new LatLng(-16.4955593, -68.1934964);
        mMap.addMarker(new MarkerOptions().position(ubication)
                .title("El Alto")
                .snippet("Ciudad de El Alto, Bolivia")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));

        ubication = new LatLng(-16.56812812228955, -68.17105065791885);
        mMap.addMarker(new MarkerOptions().position(ubication)
                .draggable(true)
                .title("Achocalla")
                .snippet("Comunidad Achocalla")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

        LatLng prueba;
        prueba = new LatLng(-16.4908505, -68.1934713);
        markerPrueba = googleMap.addMarker(new MarkerOptions().position(prueba)
                .draggable(true)
                .title("Prueba")
                .snippet("Marca de prueba")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

        //mMap.moveCamera(CameraUpdateFactory.newLatLng(ubication));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ubication,12));

        googleMap.setOnMarkerClickListener(this);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        String lat, lng;
        lat = Double.toString(marker.getPosition().latitude);
        lng = Double.toString(marker.getPosition().longitude);
        if(marker.equals(markerPrueba)){
            Toast.makeText(this, "Latitud: " + lat + "\nLongitud: " + lng, Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}
