package com.mendoza.arredondo.daniel.estadosdeanimo;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import com.mendoza.arredondo.daniel.estadosdeanimo.Clonable;
import com.mendoza.arredondo.daniel.estadosdeanimo.NullObject;

public class MainActivity extends Activity {
		//Se declaran los controles 
	private ImageView imgEstado;
	private Spinner spnEstadio;
	private Button botonCrear;
	private Button botonClonar;
	private Balon balon;
	private Balon balonClonado;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//Se relacionan los controles 
		imgEstado = (ImageView)findViewById(R.id.imgEstado);
		spnEstadio=(Spinner)findViewById(R.id.spnEstadios);
		botonCrear = (Button)findViewById(R.id.btn_boton);
		botonClonar = (Button)findViewById(R.id.btn_botonClonar);
		
		
		
		botonCrear.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(balon == null){
					balon = Balon.getBalon();
					Toast.makeText(getApplicationContext(), "Se ha creado un balón de color: "+balon.getColor()+"\n"+
							" Con la mediada: "+balon.getMedida(), Toast.LENGTH_SHORT).show();
				}else{
					Toast.makeText(MainActivity.this, "El balon ya se seleccionó" +
							", no puedes elejir otro. ", Toast.LENGTH_SHORT).show();
				}
				
			}
		});
	
		
		botonClonar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(balon == null){
					Toast.makeText(getApplicationContext(), "No puedes Clonar sin antes crear un Balon.", Toast.LENGTH_SHORT).show();
				}else{
					balonClonado = PrototipoBalon.getBalon();
					Toast.makeText(getApplicationContext(), "Se ha clonado un balón de color: "+balonClonado.getColor()+"\n"+
							" Con la mediada: "+balonClonado.getMedida(), Toast.LENGTH_SHORT).show();
				}
			}
		});
		
		//Se crea un arreglo con las operaciones de los spinner
		String operacionSpinner[] = new String[]{"Estadio 1","Estadio 2","Estadio 3","Estadio 4","No jugar"};
		//Se asigna los adaptadores para pasar el arreglo como opciones al spiner
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getApplicationContext(),
				android.R.layout.select_dialog_singlechoice, operacionSpinner);
		spnEstadio.setAdapter(adaptador);
		//FIN DE LA INICIALIZACION DEL SPINNER
		//Se asigna un escuchador Al Spinner
		spnEstadio.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
					if (spnEstadio.getSelectedItem().equals("Estadio 1")) {
						imgEstado.setImageResource(R.drawable.estadio1);
					}else if (spnEstadio.getSelectedItem().equals("Estadio 2")) {
						imgEstado.setImageResource(R.drawable.estadio2);
					}else if (spnEstadio.getSelectedItem().equals("Estadio 3")) {
						imgEstado.setImageResource(R.drawable.estadio3);
					}else if (spnEstadio.getSelectedItem().equals("Estadio 4")) {
						imgEstado.setImageResource(R.drawable.estadio4);
					}else if (spnEstadio.getSelectedItem().equals("No jugar")) {
						//Plamamos una imagen en la que se refleje que no se realiza nada
						imgEstado.setImageResource(R.drawable.enfermo);
						NullObject nula = new NullObject();
						nula.imagenNula();
						Toast.makeText(getApplicationContext(), "Null Object No se jugará", Toast.LENGTH_SHORT).show();
					}
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
