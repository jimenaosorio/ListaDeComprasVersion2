package cl.ejercicios.listadecomprasversion2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import cl.ejercicios.listadecomprasversion2.modelo.ListDeCompras;
import cl.ejercicios.listadecomprasversion2.modelo.Producto;

public class DetallesActivity extends AppCompatActivity {

    private Producto producto;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        //Obtener el producto
        intent=getIntent();
        int id=(Integer) intent.getExtras().get("idProducto");
        producto= ListDeCompras.getInstancia().getProducto(id);

        //Mostrar la información del producto
        TextView txtNombre=(TextView)findViewById(R.id.txtNombre);
        txtNombre.setText(producto.getNombre());

        TextView txtCantidad=(TextView)findViewById(R.id.txtCantidad);
        txtCantidad.setText("Cantidad: "+producto.getCantidad() +" "+ producto.getUnidad());

        TextView txtEstado=(TextView)findViewById(R.id.txtEstado);
        Button cambiar=(Button) findViewById(R.id.estado);
        if(producto.isEstado())
        {
            txtEstado.setText("Pendiente");
            cambiar.setText("Marcar como comprado");
        }
        else {
            txtEstado.setText("Comprado");
            cambiar.setText("Marcar como pendiente");
        }

    }

    public void cambiarEstado(View view)
    {
        producto.setEstado(!producto.isEstado());
        setResult(RESULT_OK,intent);
        finish();
    }
}
