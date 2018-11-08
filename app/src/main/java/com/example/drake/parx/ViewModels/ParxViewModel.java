package com.example.drake.parx.ViewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.drake.parx.Data.StatePark;
import com.google.android.gms.games.achievement.Achievement;

import java.util.List;

public class ParxViewModel extends AndroidViewModel {

    private static final MutableLiveData<List<Achievement>> playerAchievementList = new MutableLiveData<>();

    private static final MutableLiveData<List<StatePark>> allParxList = new MutableLiveData<>();

    public static void setPlayerAchievementList(List<Achievement> newPlayerList){
        playerAchievementList.setValue(newPlayerList);
    }

    public LiveData<List<Achievement>> getPlayerAchievementList(){
        return playerAchievementList;
    }

    public static void setAllParxList(List<StatePark> newParksList){
        allParxList.setValue(newParksList);
    }

    public LiveData<List<StatePark>> getAllParxList(){
        return allParxList;
    }

    public ParxViewModel(@NonNull Application application){
        super(application);
    }
}
