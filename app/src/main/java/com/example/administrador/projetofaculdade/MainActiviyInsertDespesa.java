package com.example.administrador.projetofaculdade;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.app.Activity;

/**
 * Created by admin4 on 04/06/2017.
 */

public class MainActiviyInsertDespesa extends Activity{

    @Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_insert_despesa);
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
            }
            if(intent != null){
                startActivity(intent);
            }
        }
}
