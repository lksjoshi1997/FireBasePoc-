package com.example.laxmikant.firebasepoc;

import android.app.Notification;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class FirebaseMessages extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        ShowNotificationToUser(remoteMessage.getNotification().getTitle(), remoteMessage.getNotification().getBody());
    }

    private void ShowNotificationToUser(String title, String body) {
        Notification notification = new NotificationCompat.Builder(this, "notification")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Firebase Notification :" + title)
                .setContentText(body)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setVibrate(new long[0])
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(this.NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);
    }
}
