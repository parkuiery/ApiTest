package com.example.apipractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static String TAG = "["+MainActivity.class.getSimpleName() +"]";
    Context context = MainActivity.this;

    TextView tv_name, tv_country;
    ImageView iv_weather;
    TextView tv_temp, tv_main, tv_description;
    TextView tv_wind, tv_cloud, tv_humidity;

    APIService apiinterface = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        requestNetwork();
    }

    private void initView() {
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_country = (TextView) findViewById(R.id.tv_country);
        iv_weather = (ImageView) findViewById(R.id.iv_weather);
        tv_temp = (TextView) findViewById(R.id.tv_temp);
        tv_main = (TextView) findViewById(R.id.tv_main);
        tv_description = (TextView) findViewById(R.id.tv_description);
        tv_wind = (TextView) findViewById(R.id.tv_wind);
        tv_cloud = (TextView) findViewById(R.id.tv_cloud);
        tv_humidity = (TextView) findViewById(R.id.tv_humidity);
    }

    private void requestNetwork() {

        //retrofit 객체와 인터페이스 연결
        apiinterface = APIClient.getClient(getString(R.string.weather_url)).create(APIService.class);

        //통신 요청
        Call<WeatherCloudsModeal> call = apiinterface.doGetJsonData("weather", "seoul", getString(R.string.weather_app_id));

        //응답 콜백 구현
        call.enqueue(new Callback<WeatherInfoModeal>() {
            @Override
            public void onResponse(Call<WeatherInfoModeal> call, Response<WeatherInfoModeal> response) {
                WeatherInfoModeal resource = response.body();
                if(response.isSuccessful()) {
                    setWeatherData(resource);
                }else{
                    showFailPop();
                }
            }

            @Override
            public void onFailure(Call<WeatherInfoModeal> call, Throwable t) {
                call.cancel();
                showFailPop();

            }
        });

    }


    
}