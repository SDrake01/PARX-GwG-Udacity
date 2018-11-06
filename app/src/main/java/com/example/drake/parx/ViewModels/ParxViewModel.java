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

    private static List<StatePark> allParxList;

    public static void setPlayerAchievementList(List<Achievement> newPlayerList){
        playerAchievementList.setValue(newPlayerList);
    }

    public LiveData<List<Achievement>> getPlayerAchievementList(){
        return playerAchievementList;
    }

    public static void setAllParxList(List<StatePark> newParksList){
        allParxList = newParksList;
    }

    public static List<StatePark> getAllParxList(){
        return allParxList;
    }

    public ParxViewModel(@NonNull Application application){
        super(application);

        // This async task will load the State Parks from the database on a background thread
        // into allParxList
//        StateParksAsyncTask parksAsyncTask = new StateParksAsyncTask();
//        parksAsyncTask.execute(getApplication());
    }
}
