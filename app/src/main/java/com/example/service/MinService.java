package com.example.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class MinService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
    Toast.makeText(getApplicationContext(), "I MinService", Toast.LENGTH_SHORT).show();

        NotificationManager notificationManager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        Intent i = new Intent(this, Resultat.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, i, 0);
        Notification notifikasjon = new NotificationCompat.Builder(this,"MinKanal")
                .setContentTitle("MinNotifikasjon")
                .setContentText("Tekst")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pIntent).build();
        notifikasjon.flags |= Notification.FLAG_AUTO_CANCEL;
        notificationManager.notify(88, notifikasjon);

        return super.onStartCommand(intent, flags, startId);
    }
}
