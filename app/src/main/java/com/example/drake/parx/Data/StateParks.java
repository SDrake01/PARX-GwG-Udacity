package com.example.drake.parx.Data;

import com.example.drake.parx.R;
import com.example.drake.parx.UI.MainActivity;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class StateParks {

    public static void addParks(GoogleMap thisMap){

        Marker markBarrenRiver = thisMap.addMarker(markBarrenRiverLakeResort);
        Marker markBigBoneLick = thisMap.addMarker(markBigBoneLickPark);
        Marker markBlueLick = thisMap.addMarker(markBlueLickBattlefield);
        Marker markBreaks = thisMap.addMarker(markBreaksInterstatePark);
        Marker markBuckhorn = thisMap.addMarker(markBuckhornLakeResort);
        Marker markCarrCreek = thisMap.addMarker(markCarrCreekPark);
        Marker markCarterCaves = thisMap.addMarker(markCarterCavesPark);
        Marker markColumbusBelmont = thisMap.addMarker(markColumbusBelmontPark);
        Marker markCumberlandFalls = thisMap.addMarker(markCumberlandFallsResort);
        Marker markDaleHollow = thisMap.addMarker(markDaleHollowLakePark);
        Marker markDawkinsLine = thisMap.addMarker(markDawkinsLineRailTrail);
        Marker markDrThomasWalker = thisMap.addMarker(markDrThomasWalkerPark);
        Marker markEPTomSawyer = thisMap.addMarker(markEPTomSawyerPark);
        Marker markFtBoonesborough = thisMap.addMarker(markFortBoonsboroughPark);
        Marker markFtHarrod = thisMap.addMarker(markOldFortHarrod);
        Marker markGenBurnside = thisMap.addMarker(markGeneralBurnsidePark);
        Marker markGenButler = thisMap.addMarker(markGeneralButlerResort);
        Marker markGraysonLake = thisMap.addMarker(markGraysonLakePark);
        Marker markGreenRiverLake = thisMap.addMarker(markGreenRiverLakePark);
        Marker markGreenboLake = thisMap.addMarker(markGreenboLakeResort);
        Marker markIsaacShelby = thisMap.addMarker(markIsaacShelbyHistoric);
        Marker markJeffersonDavis = thisMap.addMarker(markJeffersonDavisHistoric);
        Marker markJennyWiley = thisMap.addMarker(markJennyWileyResort);
        Marker markJJAudubon = thisMap.addMarker(markJohnJamesAudubonPark);
        Marker markKenlake = thisMap.addMarker(markKenlakeResort);
        Marker markKyDamVillage = thisMap.addMarker(markKyDamVillageResort);
        Marker markKincaidLake = thisMap.addMarker(markKincaidLakePark);
        Marker markKingdomCome = thisMap.addMarker(markKingdomComePark);
        Marker markLakeBarkley = thisMap.addMarker(markLakeBarkleyResort);
        Marker markLakeCumberland = thisMap.addMarker(markLakeCumberlandResort);
        Marker markLakeMalone = thisMap.addMarker(markLakeMalonePark);
        Marker markLeviJackson = thisMap.addMarker(markLeviJacksonPark);
        Marker markLincolnHomestead = thisMap.addMarker(markLincolnHomesteadHistoric);
        Marker markMineralMound = thisMap.addMarker(markMineralMoundPark);
        Marker markMyOldKyHome = thisMap.addMarker(markMyOldKyHomePark);
        Marker markNaturalBridge = thisMap.addMarker(markNaturalBridgeResort);
        Marker markNolinLake = thisMap.addMarker(markNolinLakePark);
        Marker markOldMulkey = thisMap.addMarker(markOldMulkeyMeetinghouse);
        Marker markPaintsvilleLake = thisMap.addMarker(markPaintsvilleLakePark);
        Marker markPennyrileForest = thisMap.addMarker(markPennyrileForestResort);
        Marker markPerryville = thisMap.addMarker(markPerryvilleHistoric);
        Marker markPineMountain = thisMap.addMarker(markPineMountainResort);
        Marker markPineMountainTrail = thisMap.addMarker(markPineMtnTrail);
        Marker markRoughRiverDam = thisMap.addMarker(markRoughRiverDamResort);
        Marker markTaylorsvilleLake = thisMap.addMarker(markTaylorsvilleLakePark);
        Marker markWaveland = thisMap.addMarker(markWavelandHistoric);
        Marker markWhiteHall = thisMap.addMarker(markWhiteHallHistoric);
        Marker markWickliffe = thisMap.addMarker(markWickliffeMoundsHistoric);
        Marker markWilliamWhitley = thisMap.addMarker(markWilliamWhitleyHistoric);
        Marker markYatesvilleLake = thisMap.addMarker(markYatesvilleLakePark);

    }

    // Marker and Info Window Data for Barren River Lake State Resort Park
    private static LatLng coordBarrenRiver = new LatLng(36.865011, -86.069094);
    private static MarkerOptions markBarrenRiverLakeResort = new MarkerOptions()
            .position(coordBarrenRiver)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_barren_river))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Big Bone Lick State Historic Site
    private static LatLng coordBigBoneLick = new LatLng(38.884040, -84.752442);
    private static MarkerOptions markBigBoneLickPark = new MarkerOptions()
            .position(coordBigBoneLick)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_big_bone_lick))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Blue Lick Battlefield State Resort Park
    private static LatLng coordBlueLick = new LatLng(38.432394, -83.995528);
    private static MarkerOptions markBlueLickBattlefield = new MarkerOptions()
            .position(coordBlueLick)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_blue_licks))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Breaks Interstate Park
    private static LatLng coordBreaksInterstate = new LatLng(37.286368, -82.294548);
    private static MarkerOptions markBreaksInterstatePark = new MarkerOptions()
            .position(coordBreaksInterstate)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_breaks_interstate))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Buckhorn Lake State Resort Park
    private static LatLng coordBuckhornLake = new LatLng(37.306502, -83.446001);
    private static MarkerOptions markBuckhornLakeResort = new MarkerOptions()
            .position(coordBuckhornLake)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_buckhorn_lake))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Carr Creek State Park
    private static LatLng coordCarrCreek = new LatLng(37.232300, -83.001149);
    private static MarkerOptions markCarrCreekPark = new MarkerOptions()
            .position(coordCarrCreek)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_carr_creek))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Carter Caves State Park
    private static LatLng coordCarterCaves = new LatLng(38.369625, -83.123696);
    private static MarkerOptions markCarterCavesPark = new MarkerOptions()
            .position(coordCarterCaves)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_carter_caves))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Columbus-Belmont State Park
    private static LatLng coordColumbusBelmont = new LatLng(36.765685, -89.110792);
    private static MarkerOptions markColumbusBelmontPark = new MarkerOptions()
            .position(coordColumbusBelmont)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_columbus_belmont))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Cumberland Falls State Resort Park
    private static LatLng coordCumberlandFalls = new LatLng(36.837741, -84.343672);
    private static MarkerOptions markCumberlandFallsResort = new MarkerOptions()
            .position(coordCumberlandFalls)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_cumberland_falls))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Dale Hollow Lake State Park
    private static LatLng coordDaleHollow = new LatLng(36.638973, -85.298629);
    private static MarkerOptions markDaleHollowLakePark = new MarkerOptions()
            .position(coordDaleHollow)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_dale_hollow))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Dawkins Line Rail Trail
    private static LatLng coordDawkinsLine = new LatLng(37.777780, -82.802175);
    private static MarkerOptions markDawkinsLineRailTrail = new MarkerOptions()
            .position(coordDawkinsLine)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_dawkins_line))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Dr. Thomas Walker State Historic Site
    private static LatLng coordDrTomWalker = new LatLng(36.839712, -83.919291);
    private static MarkerOptions markDrThomasWalkerPark = new MarkerOptions()
            .position(coordDrTomWalker)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_thomas_walker))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for E.P. "Tom" Sawyer State Park
    private static LatLng coordEPTomSawyer = new LatLng(38.286374, -85.557418);
    private static MarkerOptions markEPTomSawyerPark = new MarkerOptions()
            .position(coordEPTomSawyer)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_ep_tom_sawyer))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Fort Boonesborough State Park
    private static LatLng coordFortBoones = new LatLng(37.893792, -84.270606);
    private static MarkerOptions markFortBoonsboroughPark = new MarkerOptions()
            .position(coordFortBoones)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_fort_boonesborough))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Old Fort Harrod State Park
    private static LatLng coordFtHarrod = new LatLng(37.761862, -84.846334);
    private static MarkerOptions markOldFortHarrod = new MarkerOptions()
            .position(coordFtHarrod)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_fort_harrod))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for General Burnside State Park
    private static LatLng coordGeneralBurnside = new LatLng(36.972579, -84.598021);
    private static MarkerOptions markGeneralBurnsidePark = new MarkerOptions()
            .position(coordGeneralBurnside)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_general_burnside))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for General Butler State Resort Park
    private static LatLng coordGeneralButlerResort = new LatLng(38.670761, -85.154373);
    private static MarkerOptions markGeneralButlerResort = new MarkerOptions()
            .position(coordGeneralButlerResort)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_general_butler))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Grayson Lake State Park
    private static LatLng coordGraysonLake = new LatLng(38.202236, -83.028227);
    private static MarkerOptions markGraysonLakePark = new MarkerOptions()
            .position(coordGraysonLake)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_grayson_lake))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Green River Lake State Park
    private static LatLng coordGreenRiver = new LatLng(37.273379, -85.316753);
    private static MarkerOptions markGreenRiverLakePark = new MarkerOptions()
            .position(coordGreenRiver)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_green_river))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Greenbo Lake State Resort Park
    private static LatLng coordGreenboLake = new LatLng(38.480928, -82.873414);
    private static MarkerOptions markGreenboLakeResort = new MarkerOptions()
            .position(coordGreenboLake)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_greenbo_lake))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Isaac Shelby Cemetery State Historic Site
    private static LatLng coordIsaacShelby = new LatLng(37.566354, -84.8783756);
    private static MarkerOptions markIsaacShelbyHistoric = new MarkerOptions()
            .position(coordIsaacShelby)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_isaac_Shelby))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Jefferson Davis State Historic Site
    private static LatLng coordJeffersonDavis = new LatLng(36.841966, -87.3000070);
    private static MarkerOptions markJeffersonDavisHistoric = new MarkerOptions()
            .position(coordJeffersonDavis)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_jefferson_davis))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Jenny Wiley State Resort Park
    private static LatLng coordJennyWiley = new LatLng(37.692827, -82.725660);
    private static MarkerOptions markJennyWileyResort = new MarkerOptions()
            .position(coordJennyWiley)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_jenny_wiley))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for John James Audubon State Park
    private static LatLng coordJJAudubon = new LatLng(37.882356, -87.557387);
    private static MarkerOptions markJohnJamesAudubonPark = new MarkerOptions()
            .position(coordJJAudubon)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_j_j_audubon))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Kincaid Lake State Park
    private static LatLng coordKincaidLake = new LatLng(38.724492, -84.282887);
    private static MarkerOptions markKincaidLakePark = new MarkerOptions()
            .position(coordKincaidLake)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_kincaid_lake))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Kenlake State Resort Park
    private static LatLng coordKenlake = new LatLng(36.759774, -88.138662);
    private static MarkerOptions markKenlakeResort = new MarkerOptions()
            .position(coordKenlake)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_kenlake))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Kentucky Dam Village State Resort Park
    private static LatLng coordKyDamVillage = new LatLng(36.998699, -88.290722);
    private static MarkerOptions markKyDamVillageResort = new MarkerOptions()
            .position(coordKyDamVillage)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_ky_dam_village))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Kingdom Come State Park
    private static LatLng coordKingdomCome = new LatLng(36.989369, -82.984579);
    private static MarkerOptions markKingdomComePark = new MarkerOptions()
            .position(coordKingdomCome)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_kingdom_come))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Lake Barkley State Resort Park
    private static LatLng coordLakeBarkley = new LatLng(36.849366, -87.932055);
    private static MarkerOptions markLakeBarkleyResort = new MarkerOptions()
            .position(coordLakeBarkley)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_lake_barkley))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Lake Cumberland State Resort Park
    private static LatLng coordLakeCumberland = new LatLng(36.930202, -85.040820);
    private static MarkerOptions markLakeCumberlandResort = new MarkerOptions()
            .position(coordLakeCumberland)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_lake_cumberland))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Lake Malone State Park
    private static LatLng coordLakeMalone = new LatLng(37.079564, -87.035399);
    private static MarkerOptions markLakeMalonePark = new MarkerOptions()
            .position(coordLakeMalone)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_lake_malone))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Levi Jackson Wilderness Road State Park
    private static LatLng coordLeviJackson = new LatLng(37.081966, -84.046188);
    private static MarkerOptions markLeviJacksonPark = new MarkerOptions()
            .position(coordLeviJackson)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_levi_jackson))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Lincoln Homestead State Historic Site
    private static LatLng coordLincolnHomestead = new LatLng(37.760735, -85.214731);
    private static MarkerOptions markLincolnHomesteadHistoric = new MarkerOptions()
            .position(coordLincolnHomestead)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_lincoln_homestead))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Mineral Mound State Park
    private static LatLng coordMineralMound = new LatLng(37.062824, -88.087648);
    private static MarkerOptions markMineralMoundPark = new MarkerOptions()
            .position(coordMineralMound)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_mineral_mound))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for My Old Kentucky Home State Park
    private static LatLng coordMyOldKyHome = new LatLng(37.806462, -85.454648);
    private static MarkerOptions markMyOldKyHomePark = new MarkerOptions()
            .position(coordMyOldKyHome)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_old_ky_home))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Natural Bridge State Resort Park
    private static LatLng coordNaturalBridge = new LatLng(37.777759, -83.680316);
    private static MarkerOptions markNaturalBridgeResort = new MarkerOptions()
            .position(coordNaturalBridge)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_natural_bridge))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Nolin Lake State Park
    private static LatLng coordNolinLake = new LatLng(37.297261, -86.212412);
    private static MarkerOptions markNolinLakePark = new MarkerOptions()
            .position(coordNolinLake)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_nolin_lake))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Old Mulkey Meetinghouse State Historic Site
    private static LatLng coordOldMulkey = new LatLng(36.677753, -85.707155);
    private static MarkerOptions markOldMulkeyMeetinghouse = new MarkerOptions()
            .position(coordOldMulkey)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_old_mulkey))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Paintsville Lake State Park
    private static LatLng coordPaintsville = new LatLng(37.842495, -82.878918);
    private static MarkerOptions markPaintsvilleLakePark = new MarkerOptions()
            .position(coordPaintsville)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_paintsville_lake))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Pennyrile Forest State Resort Park
    private static LatLng coordPennyrile = new LatLng(37.072855, -87.663465);
    private static MarkerOptions markPennyrileForestResort = new MarkerOptions()
            .position(coordPennyrile)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_pennyrile_forest))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Perryville Battlefield State Historic Site
    private static LatLng coordPerryville = new LatLng(37.674558, -84.970345);
    private static MarkerOptions markPerryvilleHistoric = new MarkerOptions()
            .position(coordPerryville)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_perryville_battlefield))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Pine Mountain State Resort Park
    private static LatLng coordPineMountain = new LatLng(36.735805, -83.737825);
    private static MarkerOptions markPineMountainResort = new MarkerOptions()
            .position(coordPineMountain)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_pine_mtn))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Pine Mountain Trail State Park
    private static LatLng coordPineMtnTrl = new LatLng(37.155703, -82.633371);
    private static MarkerOptions markPineMtnTrail = new MarkerOptions()
            .position(coordPineMtnTrl)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_pint_mtn_trail))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Rough River Dam State Resort Park
    private static LatLng coordRoughRiver = new LatLng(37.610417, -86.502052);
    private static MarkerOptions markRoughRiverDamResort = new MarkerOptions()
            .position(coordRoughRiver)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_rough_river_dam))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Taylorsville Lake State Park
    private static LatLng coordTaylorsville = new LatLng(38.025064, -85.264680);
    private static MarkerOptions markTaylorsvilleLakePark = new MarkerOptions()
            .position(coordTaylorsville)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_taylorsville_lake))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Waveland State Historic Site
    private static LatLng coordWaveland = new LatLng(37.971392, -84.536701);
    private static MarkerOptions markWavelandHistoric = new MarkerOptions()
            .position(coordWaveland)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_waveland))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for White Hall State Historic Site
    private static LatLng coordWhiteHall = new LatLng(37.833201, -84.352270);
    private static MarkerOptions markWhiteHallHistoric = new MarkerOptions()
            .position(coordWhiteHall)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_white_hall))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Wickliffe Mounds State Historic Site
    private static LatLng coordWickliffeMounds = new LatLng(36.970782, -89.092619);
    private static MarkerOptions markWickliffeMoundsHistoric = new MarkerOptions()
            .position(coordWickliffeMounds)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_wickliffe_mounds))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for William Whitley House State Historic Site
    private static LatLng coordWilliamWhitley = new LatLng(37.468384, -84.549474);
    private static MarkerOptions markWilliamWhitleyHistoric = new MarkerOptions()
            .position(coordWilliamWhitley)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_william_whitley))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Yatesville Lake State Park
    private static LatLng coordYatesville = new LatLng(38.096871, -82.683705);
    private static MarkerOptions markYatesvilleLakePark = new MarkerOptions()
            .position(coordYatesville)
            .title(MainActivity.PARX_CONTEXT.getString(R.string.park_yatesville_lake))
            .snippet(MainActivity.PARX_CONTEXT.getString(R.string.earn_badges_here));
}
