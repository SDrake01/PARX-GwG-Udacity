package com.example.drake.parx.Utilities;

import android.content.Context;
import android.widget.Toast;
import com.example.drake.parx.ViewModels.BadgesViewModel;
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
                        // Build a list of achievement objects and send it to the BadgesViewModel
                        // for the map fragment recyclerview to use
                        AchievementBuffer buff = achievementBufferAnnotatedData.get();
                        Iterator<Achievement> iterator = buff.iterator();
                        List<Achievement> achList = new ArrayList<>();
                        while (iterator.hasNext()){
                            achList.add(iterator.next());
                        }
                        BadgesViewModel.setPlayerAchievementList(achList);
                        //
                        // used to create the toast - delete when the recyclerview is working
                        //
//                        Achievement achievement = buff.get(0);
//                        String achName = achievement.getName();
//                        // Toast to show what data I'm working with
//                        Toast.makeText(sendingContext, achName, Toast.LENGTH_LONG).show();
                    }
                });
    }
}
