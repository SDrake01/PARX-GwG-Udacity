package com.example.drake.parx.Utilities;

import com.example.drake.parx.UI.MainActivity;
import com.example.drake.parx.ViewModels.ParxViewModel;

import java.util.ArrayList;
import java.util.List;

public class UpdateUtility {

    public static void updatePark(String parkId){
        // Reference to MainActivity and strings needed to update achievements
        MainActivity mainActivity = new MainActivity();
        List<String> updatingBadges = new ArrayList<>();
        List<String> incrementBadges = new ArrayList<>();
        // I have tried to get a reference to the strings in the games_ids.xml file
        // but everything I tried failed with a null pointer exception,
        // so I had to hard-code these while I keep trying to see how to get
        // strings from the res folder to a class that doesn't have a context
        String appalId = "CgkInO6PsZIPEAIQAQ";
        String cccId = "CgkInO6PsZIPEAIQAg";
        String compassId = "CgkInO6PsZIPEAIQBw";
        String explorerId = "CgkInO6PsZIPEAIQCg";
        String sadieId = "CgkInO6PsZIPEAIQAw";
        String sheltoweeId = "CgkInO6PsZIPEAIQBA";
        String tvaId = "CgkInO6PsZIPEAIQCA";
        String unbridledId = "CgkInO6PsZIPEAIQBQ";

        switch (parkId){
            // All parks update the Unbridled badge
            // just to update version control
            case "01park01":
                // Barren River State Park
                // Update explorer badge
                updatingBadges.add(explorerId);
                ParxViewModel.setUpdateBadgeList(updatingBadges);
                // Increment tva and unbridled badges
                incrementBadges.add(tvaId);
                incrementBadges.add(unbridledId);
                ParxViewModel.setIncrementBadgeList(incrementBadges);
                break;
            case "02hist01":
                // Big Bone Lick State Historic Site
                // Update explorer badge
                updatingBadges.add(explorerId);
                ParxViewModel.setUpdateBadgeList(updatingBadges);
                // Increment compass and unbridles badges
                incrementBadges.add(compassId);
                incrementBadges.add(unbridledId);
                ParxViewModel.setIncrementBadgeList(incrementBadges);
                break;
            case "03resort01":
                // Blue Licks Battlefield State Resort Park
                // Update explorer badge
                updatingBadges.add(explorerId);
                ParxViewModel.setUpdateBadgeList(updatingBadges);
                // Increment sheltowee and unbridled badges
                incrementBadges.add(sheltoweeId);
                incrementBadges.add(unbridledId);
                ParxViewModel.setIncrementBadgeList(incrementBadges);
                break;
            case "04park02":
                // Breaks Interstate Park
                // Update explorer badge
                updatingBadges.add(explorerId);
                ParxViewModel.setUpdateBadgeList(updatingBadges);
                // Increment compass & appal badges
                incrementBadges.add(compassId);
                incrementBadges.add(appalId);
                incrementBadges.add(unbridledId);
                ParxViewModel.setIncrementBadgeList(incrementBadges);
                break;
            case "05resort02":
                // Buckhorn Lake State Resort Park
                // Update explorer badge
                updatingBadges.add(explorerId);
                ParxViewModel.setUpdateBadgeList(updatingBadges);
                // Increment appal badge
                incrementBadges.add(appalId);
                incrementBadges.add(unbridledId);
                ParxViewModel.setIncrementBadgeList(incrementBadges);
                break;
            case "06park03":
                // Carr Creek State Park
                // Update explorer badge
                updatingBadges.add(explorerId);
                ParxViewModel.setUpdateBadgeList(updatingBadges);
                // Increment appal badge
                incrementBadges.add(appalId);
                incrementBadges.add(unbridledId);
                ParxViewModel.setIncrementBadgeList(incrementBadges);
                break;
            case "07resort03":
                // Carter Caves State Resort Park
                // Update explorer badge
                updatingBadges.add(explorerId);
                ParxViewModel.setUpdateBadgeList(updatingBadges);
                // Increment appal & wildflower badges
                incrementBadges.add(appalId);
                incrementBadges.add(sadieId);
                incrementBadges.add(unbridledId);
                ParxViewModel.setIncrementBadgeList(incrementBadges);
                break;
            case "08park04":
                // Columbus-Belmont State Park
                // Update explorer badge
                updatingBadges.add(explorerId);
                ParxViewModel.setUpdateBadgeList(updatingBadges);
                // Increment compass, ccc, & tva badges
                incrementBadges.add(cccId);
                incrementBadges.add(compassId);
                incrementBadges.add(tvaId);
                incrementBadges.add(unbridledId);
                ParxViewModel.setIncrementBadgeList(incrementBadges);
                break;
            case "09resort04":
                // Cumberland Falls State Resort Park
                // Update explorer badge
                updatingBadges.add(explorerId);
                ParxViewModel.setUpdateBadgeList(updatingBadges);
                // Increment ccc badge
                incrementBadges.add(cccId);
                incrementBadges.add(unbridledId);
                ParxViewModel.setIncrementBadgeList(incrementBadges);
                break;
            case "10resort05":
                // Dale Hollow Lake State Resort Park
                // Update explorer badge
                updatingBadges.add(explorerId);
                ParxViewModel.setUpdateBadgeList(updatingBadges);
                // Increment compass & tva badges
                incrementBadges.add(compassId);
                incrementBadges.add(tvaId);
                incrementBadges.add(unbridledId);
                ParxViewModel.setIncrementBadgeList(incrementBadges);
                break;
            case "11park05":
                // Dawkins Line Rail Trail
                // Update explorer badge
                updatingBadges.add(explorerId);
                ParxViewModel.setUpdateBadgeList(updatingBadges);
                // Increment unbridled badge only
                incrementBadges.add(unbridledId);
                ParxViewModel.setIncrementBadgeList(incrementBadges);
                break;
            case "12hist02":
                // Dr. Thomas Walker State Historic Site
                // Update Appal & History badges
                // Update explorer badge
                updatingBadges.add(explorerId);
                ParxViewModel.setUpdateBadgeList(updatingBadges);
                // Increment CCC badge
                incrementBadges.add(cccId);
                incrementBadges.add(unbridledId);
                ParxViewModel.setIncrementBadgeList(incrementBadges);
                break;
            case "13park06":
                // E.P. 'Tom' Sawyer State Park
                // Update explorer badge
                updatingBadges.add(explorerId);
                ParxViewModel.setUpdateBadgeList(updatingBadges);
                // Increment unbridled badge only
                incrementBadges.add(unbridledId);
                ParxViewModel.setIncrementBadgeList(incrementBadges);
                break;
            case "14park07":
                // Fort Boonesborough State Park
                // Update Sheltowee & History badges
                // Update explorer badge
                updatingBadges.add(explorerId);
                ParxViewModel.setUpdateBadgeList(updatingBadges);
                // Increment sheltowee badge
                incrementBadges.add(sheltoweeId);
                incrementBadges.add(unbridledId);
                ParxViewModel.setIncrementBadgeList(incrementBadges);
                break;
            case "15park08":
                // General Burnside Island State Park
                // Update explorer badge
                updatingBadges.add(explorerId);
                ParxViewModel.setUpdateBadgeList(updatingBadges);
                // Increment unbridled badge only
                incrementBadges.add(unbridledId);
                ParxViewModel.setIncrementBadgeList(incrementBadges);
                break;
            case "16resort06":
                // General Butler State Resort Park
                // Update CCC & History badges
                break;
            case "17park09":
                // Grayson Lake State Park
                // Update Appal Badge
                break;
            case "18park10":
                // Green River Lake State Park
                //
                break;
            case "19resort07":
                // Greenbo Lake State Resort Park
                // Update Appal badge
                break;
            case "20hist03":
                // Isaac Shelby Cemetery State Historic Site
                //
                break;
            case "21hist04":
                // Jefferson Davis State Historic Site
                // Update TVA & History badges
                break;
            case "22resort08":
                // Jenny Wiley State Resort Park
                // Update Appal badge
                break;
            case "23park11":
                // John James Audubon State Park
                // Update CCC & Wildflower badges
                break;
            case "24resort09":
                // Kenlake State Resort Park
                // Update TVA badge
                break;
            case "25resort10":
                // Kentucky Dam Village State Resort Park
                // Update TVA & Wildflower badges
                break;
            case "26park12":
                // Kincaid Lake State Park
                //
                break;
            case "27park13":
                // Kingdom Come State Park
                // Update Appal badge
                break;
            case "28resort11":
                // Lake Barkley State Resort Park
                // Update TVA & Wildflower badges
                break;
            case "29resort12":
                // Lake Cumberland State Resort Park
                //
                break;
            case "30park14":
                // Lake Malone State Park
                // Update TVA badge
                break;
            case "31park15":
                // Levi Jackson Wilderness Road State Park
                // Update Sheltowee & Appal badges
                break;
            case "32park16":
                // Lincoln Homestead State Park
                // Update History badge
                break;
            case "33park17":
                // Mineral Mound State Park
                // Update TVA badge
                break;
            case "34park18":
                // My Old Kentucky Home
                // Update History badge
                break;
            case "35resort13":
                // Natural Bridge State Resort Park
                // Update Appal & Wildflower badges
                break;
            case "36park19":
                // Nolin Lake State Park
                // Update TVA badge
                break;
            case "37park20":
                // Old Fort Harrod State Park
                // Update Sheltowee badge
                break;
            case "38hist05":
                // Old Mulkey Meetinghouse State Historic Site
                // Update TVA & History badges
                break;
            case "39park21":
                // Paintsville Lake State Park
                // Update Appal badge
                break;
            case "40resort14":
                // Pennyrile Forest State Resort Park
                // Update TVA & Wildflower badges
                break;
            case "41hist06":
                // Perryville Battlefield State Historic Site
                // Update History badge
                break;
            case "42resort15":
                // Pine Mountain State Resort Park
                // Update CCC, Appal & Wildflower badges
                break;
            case "43park22":
                // Pine Mountain State Scenic Trail
                //
                break;
            case "44resort16":
                // Rough River Dam State Resort Park
                //
                break;
            case "45park23":
                // Taylorsville Lake State Park
                //
                break;
            case "46hist07":
                // Waveland State Historic Site
                // Update History badge
                break;
            case "47hist08":
                // White Hall State Historic Site
                // Update History badge
                break;
            case "48hist09":
                // Wickliffe Mounds State Historic Site
                // Update History badge
                break;
            case "49hist10":
                // William Whitley House State Historic Site
                // Update History badge
                break;
            case "50park11":
                // Yatesville Lake State Park
                // Update Appal badge
                break;
        }
    }
}
