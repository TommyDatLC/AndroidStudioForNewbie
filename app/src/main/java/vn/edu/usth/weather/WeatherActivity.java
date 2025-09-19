package vn.edu.usth.weather;


import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.fragment.app.FragmentActivity;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.io.InputStream;

public class WeatherActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle saveInstance)
    {
        super.onCreate(saveInstance);
        setContentView(R.layout.weather_activity);
        ViewPager viewPager = findViewById(R.id.main_view_pager);
        TabLayout tabLayout = findViewById(R.id.test_tab_layout);
        androidx.appcompat.widget.Toolbar toolbar = (androidx.appcompat.widget.Toolbar)findViewById(R.id.main_toolbar);
        toolbar.setTitle(R.string.talavua);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(new viewPagerTest(getSupportFragmentManager(),0));

      //  getSupportFragmentManager().beginTransaction().add(R.id.main_weather_activity,f).commit();
        PlayMusic();
    }
    void PlayMusic()
    {
        MediaPlayer mp = MediaPlayer.create(this,R.raw.mikuuuu);
        mp.start();
    }


    public void onStart()
    {
        super.onStart();
        Log.i("Event call","onStart");
    }
    public void onPause()
    {
        super.onPause();
        Log.i("Event call","onPause");
    }
    public void onStop()
    {
        super.onStop();
        Log.i("Event call","onStop");
    }
    public void onDestroy()
    {
        super.onDestroy();
        Log.i("Event call","onDestroy");
    }
    public void onResume()
    {
        super.onResume();
        Log.i("Event call","onResume");
    }

}
