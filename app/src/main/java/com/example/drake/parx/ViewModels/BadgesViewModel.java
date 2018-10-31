package com.example.drake.parx.ViewModels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.drake.parx.Adapters.MainBadgesAdapter;
import com.example.drake.parx.UI.BadgesFragment;
import com.example.drake.parx.UI.MainActivity;
import com.google.android.gms.games.achievement.Achievement;
import java.util.List;

public class BadgesViewModel extends ViewModel {

    private static final MutableLiveData<List<Achievement>> playerAchievementList = new MutableLiveData<>();

    public static void setPlayerAchievementList(List<Achievement> newPlayerList){
        playerAchievementList.setValue(newPlayerList);
    }

    public LiveData<List<Achievement>> getPlayerAchievementList(){
        return playerAchievementList;
    }
}
