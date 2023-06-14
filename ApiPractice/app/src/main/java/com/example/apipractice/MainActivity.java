package com.example.apipractice;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

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
        Call<WeatherInfoModeal> call = apiinterface.doGetJsonData("weather", "seoul", getString(R.string.weather_app_id));

        //응답 콜백 구현
        call.enqueue(new Callback<WeatherInfoModeal>() {
            @Override
            public void onResponse(Call<WeatherInfoModeal> call, Response<WeatherInfoModeal> response) {
                WeatherInfoModeal resource = response.body();
                if(response.isSuccessful()) {
                    setWeatherData(resource);   //UI 업데이트
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


    //통신하여 받아온 날씨 데이터를 통해 UI 업데이트 메소드
    private void setWeatherData(WeatherInfoModeal model) {
        tv_name.setText(model.getName());
        tv_country.setText(model.getSys().getCountry());

        Glide.with(context).load(getString(R.string.weather_url)+"img/w/"+model.getWeather().get(0).getIcon()+".png")
                //Glide 라이브러리를 이용하여 ImageView 에 url 로 이미지 지정
                .placeholder(R.drawable.icon_image)
                .error(R.drawable.icon_image)
                .into(iv_weather);
        tv_temp.setText(doubleToStrFormat(2,model.getMain().getTemp()-273.15)+ " °C");

        tv_main.setText(model.getWeather().get(0).getMain());
        tv_description.setText(model.getWeather().get(0).getDescription());
        tv_wind.setText(doubleToStrFormat(2, model.getWind().getSpeed()) + "m/s");
        tv_cloud.setText(doubleToStrFormat(2, model.getClouds().getAll())+ "%");
        tv_humidity.setText(doubleToStrFormat(2, model.getMain().getHumidity()) +"%");

    }

    //통신 실패시 lertDialog 표시하는 메소드
    private void showFailPop() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Title").setMessage("통신 싪패");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(getApplicationContext(), "OK Click", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(getApplicationContext(), "Cancel CLick", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }




    private String doubleToStrFormat(int n, double value) {
        return String.format("%."+n+"f", value);
    }
}