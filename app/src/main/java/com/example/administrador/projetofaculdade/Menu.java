package com.example.administrador.projetofaculdade;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.app.Activity;

/**
 * Created by admin4 on 04/06/2017.
 */

public class Menu extends Activity{
    @Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    }
    public void selectMainOpetion(View view){
        Intent intent = null;
        switch (view.getId()){
            case R.id.btnInserir:
                intent = new Intent(this,InsertDespesa.class);
                break;
            case R.id.btnListar:
                intent = new Intent(this,ListDespesaActivity.class);
                break;
            case R.id.btnBaixarRelatorio:
                intent = new Intent(this,Relatorio3.class);
                break;
            case R.id.btnEnviarEmail:
                intent = new Intent(this,MainActivity.class);
                break;
        }
        if(intent != null){
            startActivity(intent);
        }
    }

}
