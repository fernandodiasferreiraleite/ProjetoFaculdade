package com.example.administrador.projetofaculdade;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by admin4 on 05/06/2017.
 */

public class Relatorio3 extends AppCompatActivity {

    private Button btnSite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relatorioss);

        btnSite=(Button)findViewById(R.id.btnsite);
        btnSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("http://172.31.0.34:9999/TESTE-1.0/RelatorioDespesas"));
                startActivity(it);

            }
        });

    }

}



