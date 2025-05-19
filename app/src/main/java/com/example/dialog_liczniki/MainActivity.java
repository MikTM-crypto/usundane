package com.example.dialog_liczniki;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    public int usuniecia =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button btnusun = findViewById(R.id.btnusun);

        btnusun.setOnClickListener(v->showAlertDialog());
        }
    public void showAlertDialog() {
        // 1. Utwórz Buildera dla AlertDialog, przekazując kontekst (this - Activity)
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // 2. Skonfiguruj okno dialogowe
        builder.setTitle("Usuń"); // Tytuł
        builder.setMessage("Czy na pewno usunąć dane?"); // Wiadomość

        // 3. Dodaj przycisk pozytywny ("OK")
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Akcja po kliknięciu "OK"
                Toast.makeText(MainActivity.this, "Dane usunięte", Toast.LENGTH_SHORT).show();
                usuniecia++;
                TextView licznik = findViewById(R.id.licznik);
                licznik.setText("Dane usunieto: " + usuniecia +" razy");
            }
        });

        // 4. Dodaj przycisk negatywny ("Anuluj")
        builder.setNegativeButton("Anuluj", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss(); // Zamykamy dialog po kliknięciu
            }
        });

        // 5. Stwórz i wyświetl AlertDialog
        builder.create().show();
    }
}
