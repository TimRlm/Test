package teko.biz.test;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        Log.v("TIMTIM","asad");
        Toast.makeText(context, "Alarm went off", Toast.LENGTH_SHORT).show();
//
//        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
//        Notification notification = new Notification.Builder(context)
//                .setContentTitle("Уведомление")
//                .setContentText("Адрес вот")
//                .build();
//        manager.notify(0,notification);
    }
}
