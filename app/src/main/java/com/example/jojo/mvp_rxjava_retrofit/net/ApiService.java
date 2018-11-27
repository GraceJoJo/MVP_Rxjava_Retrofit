package com.example.jojo.mvp_rxjava_retrofit.net;

import com.example.jojo.mvp_rxjava_retrofit.bean.WeatherEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * author : JOJO
 * e-mail : 18510829974@163.com
 * date   : 2018/11/21 2:35 PM
 * desc   : 网络请求接口的配置
 */
public interface ApiService {
    //获取北京的天气信息
//    "https://www.sojson.com/open/api/weather/json.shtml?city=" + "北京"
    @GET("weather/json.shtml")
    Observable<Object> getWeatherNormal(@Query("city") String city);

    //添加的city_code = 101030100
//    http://t.weather.sojson.com/api/weather/city/+city_code”
    @GET("weather/city/{city_code}")
    Observable<BaseHttpResponse<WeatherEntity>> getWeather(@Path("city_code") String city_code);
}