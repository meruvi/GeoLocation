package geolocation.com.geolocation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnTipos, btnSitios, btnUbicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTipos = (Button)findViewById(R.id.btn_tipos);
        btnUbicacion = (Button)findViewById(R.id.btn_ubicacion);
        btnSitios = (Button)findViewById(R.id.btn_sitios);

        btnSitios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MapsActivity1.class);
                startActivity(intent);
            }
        });

    }

    public void MapaSitios(View view){
        Intent intent = new Intent(getApplicationContext(), MapsActivityTipos.class);
        startActivity(intent);
    }

    public void MiLocalizacion(View v){
        Intent intent = new Intent(getApplicationContext(), MapsActivityMiLocalizacion.class);
        startActivity(intent);
    }
}
