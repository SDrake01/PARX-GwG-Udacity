package com.example.drake.parx.Utilities;

import android.content.Context;

import com.example.drake.parx.ViewModels.ParxViewModel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.achievement.Achievement;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.tasks.OnSuccessListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AchievementsUtility {

    public static void getAchievements(final Context sendingContext, GoogleSignInAccount sendingAccount) {
        Games.getAchievementsClient(sendingContext, sendingAccount)
                .load(true)
                .addOnSuccessListener(new OnSuccessListener<AnnotatedData<AchievementBuffer>>() {
                    @Override
                    public void onSuccess(AnnotatedData<AchievementBuffer> achievementBufferAnnotatedData) {
                        // Build a list of achievement objects and send it to the ParxViewModel
                        // for the map fragment recyclerview to use
                        AchievementBuffer achBuffer = achievementBufferAnnotatedData.get();
                        Iterator<Achievement> iterator = achBuffer.iterator();
                        List<Achievement> achList = new ArrayList<>();
                        while (iterator.hasNext()){
                            achList.add(iterator.next());
                        }
                        ParxViewModel.setPlayerAchievementList(achList);
                    }
                });
    }
}
