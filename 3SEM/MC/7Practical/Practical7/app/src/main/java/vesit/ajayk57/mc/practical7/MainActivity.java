package vesit.ajayk57.mc.practical7;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.Task;

public class MainActivity extends AppCompatActivity implements
        OnMapReadyCallback {
    Location currentLocation;
    GoogleMap gMap;
    FusedLocationProviderClient fusedLocationProviderClient;
    private static final int REQUEST_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fusedLocationProviderClient =
                LocationServices.getFusedLocationProviderClient(this);
        fetchLastLocation();
    }

    private void fetchLastLocation() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]
                    {Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
            return;
        }
        Task<Location> task = fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(location -> {
            if (location != null) {
                currentLocation = location;
                Toast.makeText(getApplicationContext(), currentLocation.getLatitude()

                                + "" + currentLocation.getLongitude(),

                        Toast.LENGTH_SHORT).show();
                SupportMapFragment supportMapFragment = (SupportMapFragment)
                        getSupportFragmentManager().findFragmentById(R.id.google_map);
                assert supportMapFragment != null;
                supportMapFragment.getMapAsync(MainActivity.this);

            }
        });
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        double srcLat = currentLocation.getLatitude();
        double srcLong = currentLocation.getLongitude();
        LatLng latLng = new
                LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions().position(latLng)
                .title(srcLat + ":" + srcLong);
        googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
        googleMap.addMarker(markerOptions);
        gMap = googleMap;
        gMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            int count = -1;

            @Override
            public void onMapClick(@NonNull LatLng latLng) {
                MarkerOptions markerOptions1 = new MarkerOptions();
                markerOptions1.position(latLng);
                markerOptions1.title(latLng.latitude + ":" + latLng.longitude);
                count++;
                if (count % 2 != 0) {
                    gMap.clear();
                }
                gMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
                gMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
                gMap.addMarker(markerOptions1);
                double res =
                        distance(srcLat, latLng.latitude, srcLong, latLng.longitude);

                Toast.makeText(getApplicationContext(), "Distance = " + res,

                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static double distance(double lat1, double lat2, double lon1, double lon2) {
        lon1 = Math.toRadians(lon1);
        lon2 = Math.toRadians(lon2);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2), 2);
        double c = 2 * Math.asin(Math.sqrt(a));
        double r = 6371;
        return (c * r);
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull
    String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CODE) {
            fetchLastLocation();
        }
    }
}