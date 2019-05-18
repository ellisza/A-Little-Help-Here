package com.example.alittlehelphere;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private TextView resultsText;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.navigation_map:
                    mTextMessage.setText(R.string.title_map);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        resultsText = findViewById(R.id.text_view_result);

        Retrofit alhhRetrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000")
                .addConverterFactory(MoshiConverterFactory.create())
                .build();

        AlhhApi alhhApi = alhhRetrofit.create(AlhhApi.class);

        final Call<List<Help>> alhhCall = alhhApi.getHelps();

        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                alhhCall.enqueue(new Callback<List<Help>>() {
                    @Override
                    public void onResponse(Call<List<Help>> call, Response<List<Help>> response) {

                        if (!response.isSuccessful()) {
                            resultsText.setText("Code:" + response.code());
                            return;
                        }

                        List<Help> helps = response.body();

                        for(Help help: helps){
                            String content = "";
                            content += "Title: " + help.getTitle() + "\n";
                            content += "Address: " + help.getAddress() + "\n\n";
                            resultsText.append(content);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Help>> alhhCall, Throwable t) {
                        resultsText.setText(t.getMessage());
                    }
                });
            }
        });
    }

}
