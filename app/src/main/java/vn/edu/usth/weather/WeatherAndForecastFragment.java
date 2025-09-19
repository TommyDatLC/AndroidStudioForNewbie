package vn.edu.usth.weather;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.Nullable;
public class WeatherAndForecastFragment extends Fragment {
    final int HORIZONTAL = 0;
    final int VERTICAL = 1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        Context ctx = getContext();
        View v = inflater.inflate(R.layout.forecast_fragment,container,false);LinearLayout listView = (LinearLayout)v;
        var weatherList = CreateForecastFragment(listView.getContext());
        listView.addView(weatherList);

        var layoutParam = (LinearLayout.LayoutParams)weatherList.getLayoutParams();
        layoutParam.weight = 0.5f;
        weatherList.setLayoutParams(layoutParam);

        return v;
    }
    LinearLayout CreateForecastFragment(Context ctx)
    {
        LinearLayout __container = new LinearLayout(ctx);
        __container.setOrientation(VERTICAL);
        __container.setBackgroundColor(0x200000FF);
        //View v = new View(ctx);
        Context container_context = __container.getContext();
        LinearLayout linear = CreateLinearLayout(container_context,"Mon",R.mipmap.cloudy_with_sun,"Cloudy\n24C-31C");
        LinearLayout linear1 = CreateLinearLayout(container_context,"Tue",R.mipmap.cloudy_with_sun,"Not Cloudy Any more\n24C-31C");
        LinearLayout linear2 = CreateLinearLayout(container_context,"Wen",R.mipmap.cloudy_with_sun,"Hot\n24C-31C");
        LinearLayout linear3 = CreateLinearLayout(container_context,"Thu",R.mipmap.cloudy_with_sun,"Sunny\n24C-31C");
        LinearLayout linear4 = CreateLinearLayout(container_context,"Fri",R.mipmap.cloudy_with_sun,"Rainny\n24C-31C");
        __container.addView(linear);
        __container.addView(linear1);
        __container.addView(linear2);
        __container.addView(linear3);
        __container.addView(linear4);
        return __container;
    }
    int paddingLR = 50;
    int paddingUB = 25;
    LinearLayout CreateLinearLayout(Context ctx,String Day,int id_Drawableicon,String WeatherStatus)
    {
        LinearLayout linear = new LinearLayout(ctx);
        TextView textView_day = new TextView(ctx);
        ImageView image = new ImageView(ctx);
        TextView textView_status = new TextView(ctx);

        //Set properties
        textView_day.setText(Day);
        image.setImageResource(id_Drawableicon);
        textView_status.setText(WeatherStatus);

        linear.addView(textView_day);
        linear.addView(image);
        linear.addView(textView_status);

        // Set image layout param
        var layoutParam = image.getLayoutParams();
        layoutParam.height = 100;
        layoutParam.width = 100;

        var layoutParam_textday = textView_day.getLayoutParams();
        layoutParam_textday.height = 100;
        layoutParam_textday.width = 100;
        textView_day.setLayoutParams(layoutParam_textday);
        var layoutParam_textstatus = textView_status.getLayoutParams();
        layoutParam_textstatus.height = -1;
        layoutParam_textstatus.width = 300;
        textView_status.setLayoutParams(layoutParam_textstatus);


        textView_day.setGravity(Gravity.CENTER);
        textView_status.setGravity(Gravity.CENTER_VERTICAL);
        textView_status.setPadding(30,0,0,0);
        // add to view

        linear.setOrientation(LinearLayout.HORIZONTAL);

        return linear;
    }

}
