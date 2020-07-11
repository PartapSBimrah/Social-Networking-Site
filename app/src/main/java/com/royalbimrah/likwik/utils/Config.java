package com.royalbimrah.likwik.utils;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.royalbimrah.likwik.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by amsavarthan on 10/3/18.
 */

public class Config {

    public static final String TOPIC_GLOBAL           = "global";

    public static final String REGISTRATION_COMPLETE  = "registrationComplete";
    public static final String PUSH_NOTIFICATION      = "pushNotification";


    public static final String SHARED_PREF            = "ah_firebase";


    public static final int PICK_IMAGES = 102;
    public static final String NEWS_API_KEY = "9fe4773c7c2f44a1ac5641e382038b54";

    @NonNull
    public static String random() {
        Random generator = new Random();
        StringBuilder randomStringBuilder = new StringBuilder();
        int randomLength = generator.nextInt(10);
        char tempChar;
        for (int i = 0; i < randomLength; i++) {
            tempChar = (char) (generator.nextInt(96) + 32);
            randomStringBuilder.append(tempChar);
        }
        return randomStringBuilder.toString();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void createNotificationChannels(Context context){

        NotificationManager notificationManager=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

        List<NotificationChannelGroup> notificationChannelGroups=new ArrayList<>();
        notificationChannelGroups.add(new NotificationChannelGroup("LikWik","LikWik"));
        notificationChannelGroups.add(new NotificationChannelGroup("other","Other"));

        notificationManager.createNotificationChannelGroups(notificationChannelGroups);

        NotificationChannel flash_message_channel=new NotificationChannel("flash_message","Flash Messages",NotificationManager.IMPORTANCE_HIGH);
        flash_message_channel.enableLights(true);
        flash_message_channel.enableVibration(true);
        flash_message_channel.setGroup("LikWik");
        flash_message_channel.setSound(Uri.parse("android.resource://"+context.getPackageName()+"/"+ R.raw.hify_sound), null);

        NotificationChannel comments_channel=new NotificationChannel("comments_channel","Comments",NotificationManager.IMPORTANCE_HIGH);
        comments_channel.enableLights(true);
        comments_channel.enableVibration(true);
        comments_channel.setGroup("LikWik");
        comments_channel.setSound(Uri.parse("android.resource://"+context.getPackageName()+"/"+ R.raw.hify_sound), null);


        NotificationChannel like_channel=new NotificationChannel("like_channel","Likes",NotificationManager.IMPORTANCE_HIGH);
        like_channel.enableLights(true);
        like_channel.enableVibration(true);
        like_channel.setGroup("LikWik");
        like_channel.setSound(Uri.parse("android.resource://"+context.getPackageName()+"/"+ R.raw.hify_sound), null);

        NotificationChannel forum_channel=new NotificationChannel("forum_channel","Forum",NotificationManager.IMPORTANCE_HIGH);
        forum_channel.enableLights(true);
        forum_channel.enableVibration(true);
        forum_channel.setGroup("LikWik");
        forum_channel.setSound(Uri.parse("android.resource://"+context.getPackageName()+"/"+ R.raw.hify_sound), null);

        NotificationChannel sending_channel=new NotificationChannel("sending_channel","Sending Media",NotificationManager.IMPORTANCE_LOW);
        sending_channel.enableLights(true);
        sending_channel.enableVibration(true);
        sending_channel.setGroup("other");

        NotificationChannel other_channel=new NotificationChannel("other_channel","Other Notifications",NotificationManager.IMPORTANCE_LOW);
        other_channel.enableLights(true);
        other_channel.enableVibration(true);
        other_channel.setGroup("other");

        NotificationChannel hify_other_channel=new NotificationChannel("LikWik_other_channel","Other Notifications",NotificationManager.IMPORTANCE_LOW);
        hify_other_channel.enableLights(true);
        hify_other_channel.enableVibration(true);
        hify_other_channel.setGroup("LikWik");
        hify_other_channel.setSound(Uri.parse("android.resource://"+context.getPackageName()+"/"+ R.raw.hify_sound), null);

        List<NotificationChannel> notificationChannels=new ArrayList<>();
        notificationChannels.add(flash_message_channel);
        notificationChannels.add(like_channel);
        notificationChannels.add(comments_channel);
        notificationChannels.add(forum_channel);
        notificationChannels.add(sending_channel);
        notificationChannels.add(other_channel);
        notificationChannels.add(hify_other_channel);

        notificationManager.createNotificationChannels(notificationChannels);

    }

}
