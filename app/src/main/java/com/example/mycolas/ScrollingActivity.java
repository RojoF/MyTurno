package com.example.mycolas;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ScrollingActivity extends AppCompatActivity {
    private TextView mJsonTxtView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mJsonTxtView = findViewById(R.id.listTurno);
        getPosts();
    }

    // Metodo para obtener los campos
    private void getPosts(){

        Retrofit retrofit = new Retrofit.Builder()
                // Establecemos la base URL para la API REST
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Se crea el objeto de tipo JsonApi y llamamos al interfaz de java
        JsonApi jsonApi = retrofit.create(JsonApi.class);

        Call<List<Posts>> call = jsonApi.getPosts();

        call.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(@NonNull Call<List<Posts>> call,@NonNull Response<List<Posts>> response) {

                // Condicion para que si no hay respuesta enviar mensaje de Error
                if(!response.isSuccessful()){
                    mJsonTxtView.setText("Codigo: "+response.code());
                    return;
                }

                List<Posts> postsList = response.body();
                Intent intent = getIntent();
                String message = intent.getStringExtra(InsertActivity.EXTRA_MESSAGE);
                mJsonTxtView.append("Número de Prioridad cola introducido: "+message+"\n"+"" +
                        "-------------------------------------\n");
                int mes = Integer.parseInt(message);

                // Bucle para pintar los campos en el textView
                for(@Nullable Posts post: postsList){
                    String content = "";
                    content += "userId:"+ post.getUserId() + "\n";
                    content += "id:"+ post.getId() +
                            "\n"+"----------------------------------------"+"\n";


                    //Mas campos de la BBDD o servidor
                    //content += "title:"+ post.getTitle() + "\n";
                    //content += "body:"+ post.getBody() + "\n\n";
                    if (mes == post.getUserId()){
                    mJsonTxtView.append(content);}

                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Posts>> call,@NonNull Throwable t) {
                mJsonTxtView.setText(t.getMessage());

            }
        });
    }
}

