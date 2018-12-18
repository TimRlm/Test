package teko.biz.test;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;

import java.util.Calendar;

import teko.biz.test.data.DataManager;
import teko.biz.test.data.MyService;

public class App extends Application {
    public static DataManager dm;

    @Override
    public void onCreate() {
        super.onCreate();
        dm = new DataManager(getApplicationContext());
        startService(new Intent(this,MyService.class));
    }

    public void SetAlarm(Context context)
    {
        AlarmManager am=(AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent=new Intent(context, MyReceiver.class);
        PendingIntent pi= PendingIntent.getBroadcast(context,0, intent,0);
//Устанавливаем интервал срабатывания в 5 секунд.
        am.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),1000*5,pi);
    }
}
