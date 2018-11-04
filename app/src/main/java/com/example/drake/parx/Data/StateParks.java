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
    private static LatLng coordBarrenRiver = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.barren_river_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.barren_river_long)));
    private static MarkerOptions markBarrenRiverLakeResort = new MarkerOptions()
            .position(coordBarrenRiver)
            .title(MainActivity.parxContext.getString(R.string.park_barren_river))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Big Bone Lick State Historic Site
    private static LatLng coordBigBoneLick = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.big_bone_lick_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.big_bone_lick_long)));
    private static MarkerOptions markBigBoneLickPark = new MarkerOptions()
            .position(coordBigBoneLick)
            .title(MainActivity.parxContext.getString(R.string.park_big_bone_lick))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Blue Lick Battlefield State Resort Park
    private static LatLng coordBlueLick = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.blue_lick_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.blue_lick_long)));
    private static MarkerOptions markBlueLickBattlefield = new MarkerOptions()
            .position(coordBlueLick)
            .title(MainActivity.parxContext.getString(R.string.park_blue_licks))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Breaks Interstate Park
    private static LatLng coordBreaksInterstate = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.breaks_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.breaks_long)));
    private static MarkerOptions markBreaksInterstatePark = new MarkerOptions()
            .position(coordBreaksInterstate)
            .title(MainActivity.parxContext.getString(R.string.park_breaks_interstate))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Buckhorn Lake State Resort Park
    private static LatLng coordBuckhornLake = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.buckhorn_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.buckhorn_long)));
    private static MarkerOptions markBuckhornLakeResort = new MarkerOptions()
            .position(coordBuckhornLake)
            .title(MainActivity.parxContext.getString(R.string.park_buckhorn_lake))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Carr Creek State Park
    private static LatLng coordCarrCreek = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.carr_creek_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.carr_creek_long)));
    private static MarkerOptions markCarrCreekPark = new MarkerOptions()
            .position(coordCarrCreek)
            .title(MainActivity.parxContext.getString(R.string.park_carr_creek))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Carter Caves State Park
    private static LatLng coordCarterCaves = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.carter_caves_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.carter_caves_long)));
    private static MarkerOptions markCarterCavesPark = new MarkerOptions()
            .position(coordCarterCaves)
            .title(MainActivity.parxContext.getString(R.string.park_carter_caves))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Columbus-Belmont State Park
    private static LatLng coordColumbusBelmont = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.columbus_belmont_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.columbus_belmont_long)));
    private static MarkerOptions markColumbusBelmontPark = new MarkerOptions()
            .position(coordColumbusBelmont)
            .title(MainActivity.parxContext.getString(R.string.park_columbus_belmont))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Cumberland Falls State Resort Park
    private static LatLng coordCumberlandFalls = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.cumberland_falls_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.cumberland_falls_long)));
    private static MarkerOptions markCumberlandFallsResort = new MarkerOptions()
            .position(coordCumberlandFalls)
            .title(MainActivity.parxContext.getString(R.string.park_cumberland_falls))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Dale Hollow Lake State Park
    private static LatLng coordDaleHollow = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.dale_hollow_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.dale_hollow_long)));
    private static MarkerOptions markDaleHollowLakePark = new MarkerOptions()
            .position(coordDaleHollow)
            .title(MainActivity.parxContext.getString(R.string.park_dale_hollow))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Dawkins Line Rail Trail
    private static LatLng coordDawkinsLine = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.dawkins_line_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.dawkins_line_long)));
    private static MarkerOptions markDawkinsLineRailTrail = new MarkerOptions()
            .position(coordDawkinsLine)
            .title(MainActivity.parxContext.getString(R.string.park_dawkins_line))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Dr. Thomas Walker State Historic Site
    private static LatLng coordDrTomWalker = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.dr_thomas_walker_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.dr_thomas_walker_long)));
    private static MarkerOptions markDrThomasWalkerPark = new MarkerOptions()
            .position(coordDrTomWalker)
            .title(MainActivity.parxContext.getString(R.string.park_thomas_walker))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for E.P. "Tom" Sawyer State Park
    private static LatLng coordEPTomSawyer = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.e_p_tom_sawyer_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.e_p_tom_sawyer_long)));
    private static MarkerOptions markEPTomSawyerPark = new MarkerOptions()
            .position(coordEPTomSawyer)
            .title(MainActivity.parxContext.getString(R.string.park_ep_tom_sawyer))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Fort Boonesborough State Park
    private static LatLng coordFortBoones = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.ft_boonesborough_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.ft_boonesborough_long)));
    private static MarkerOptions markFortBoonsboroughPark = new MarkerOptions()
            .position(coordFortBoones)
            .title(MainActivity.parxContext.getString(R.string.park_fort_boonesborough))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Old Fort Harrod State Park
    private static LatLng coordFtHarrod = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.ft_harrod_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.ft_harrod_long)));
    private static MarkerOptions markOldFortHarrod = new MarkerOptions()
            .position(coordFtHarrod)
            .title(MainActivity.parxContext.getString(R.string.park_fort_harrod))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for General Burnside State Park
    private static LatLng coordGeneralBurnside = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.gen_burnside_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.gen_burnside_long)));
    private static MarkerOptions markGeneralBurnsidePark = new MarkerOptions()
            .position(coordGeneralBurnside)
            .title(MainActivity.parxContext.getString(R.string.park_general_burnside))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for General Butler State Resort Park
    private static LatLng coordGeneralButlerResort = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.gen_butler_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.gen_butler_long)));
    private static MarkerOptions markGeneralButlerResort = new MarkerOptions()
            .position(coordGeneralButlerResort)
            .title(MainActivity.parxContext.getString(R.string.park_general_butler))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Grayson Lake State Park
    private static LatLng coordGraysonLake = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.grayson_lake_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.grayson_lake_long)));
    private static MarkerOptions markGraysonLakePark = new MarkerOptions()
            .position(coordGraysonLake)
            .title(MainActivity.parxContext.getString(R.string.park_grayson_lake))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Green River Lake State Park
    private static LatLng coordGreenRiver = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.green_river_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.green_river_long)));
    private static MarkerOptions markGreenRiverLakePark = new MarkerOptions()
            .position(coordGreenRiver)
            .title(MainActivity.parxContext.getString(R.string.park_green_river))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Greenbo Lake State Resort Park
    private static LatLng coordGreenboLake = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.greenbo_lake_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.greenbo_lake_long)));
    private static MarkerOptions markGreenboLakeResort = new MarkerOptions()
            .position(coordGreenboLake)
            .title(MainActivity.parxContext.getString(R.string.park_greenbo_lake))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Isaac Shelby Cemetery State Historic Site
    private static LatLng coordIsaacShelby = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.isaac_shelby_cemetery_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.isaac_shelby_cemetery_long)));
    private static MarkerOptions markIsaacShelbyHistoric = new MarkerOptions()
            .position(coordIsaacShelby)
            .title(MainActivity.parxContext.getString(R.string.park_isaac_Shelby))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Jefferson Davis State Historic Site
    private static LatLng coordJeffersonDavis = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.jefferson_davis_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.jefferson_davis_long)));
    private static MarkerOptions markJeffersonDavisHistoric = new MarkerOptions()
            .position(coordJeffersonDavis)
            .title(MainActivity.parxContext.getString(R.string.park_jefferson_davis))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Jenny Wiley State Resort Park
    private static LatLng coordJennyWiley = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.jenny_wiley_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.jenny_wiley_long)));
    private static MarkerOptions markJennyWileyResort = new MarkerOptions()
            .position(coordJennyWiley)
            .title(MainActivity.parxContext.getString(R.string.park_jenny_wiley))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for John James Audubon State Park
    private static LatLng coordJJAudubon = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.jj_audubon_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.jj_audubon_long)));
    private static MarkerOptions markJohnJamesAudubonPark = new MarkerOptions()
            .position(coordJJAudubon)
            .title(MainActivity.parxContext.getString(R.string.park_j_j_audubon))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Kincaid Lake State Park
    private static LatLng coordKincaidLake = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.kincaid_lake_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.kincaid_lake_long)));
    private static MarkerOptions markKincaidLakePark = new MarkerOptions()
            .position(coordKincaidLake)
            .title(MainActivity.parxContext.getString(R.string.park_kincaid_lake))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Kenlake State Resort Park
    private static LatLng coordKenlake = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.kenlake_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.kenlake_long)));
    private static MarkerOptions markKenlakeResort = new MarkerOptions()
            .position(coordKenlake)
            .title(MainActivity.parxContext.getString(R.string.park_kenlake))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Kentucky Dam Village State Resort Park
    private static LatLng coordKyDamVillage = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.ky_dam_village_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.ky_dam_village_long)));
    private static MarkerOptions markKyDamVillageResort = new MarkerOptions()
            .position(coordKyDamVillage)
            .title(MainActivity.parxContext.getString(R.string.park_ky_dam_village))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Kingdom Come State Park
    private static LatLng coordKingdomCome = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.kingdom_come_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.kingdom_come_long)));
    private static MarkerOptions markKingdomComePark = new MarkerOptions()
            .position(coordKingdomCome)
            .title(MainActivity.parxContext.getString(R.string.park_kingdom_come))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Lake Barkley State Resort Park
    private static LatLng coordLakeBarkley = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.lake_barkley_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.lake_barkley_long)));
    private static MarkerOptions markLakeBarkleyResort = new MarkerOptions()
            .position(coordLakeBarkley)
            .title(MainActivity.parxContext.getString(R.string.park_lake_barkley))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Lake Cumberland State Resort Park
    private static LatLng coordLakeCumberland = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.lake_cumberland_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.lake_cumberland_long)));
    private static MarkerOptions markLakeCumberlandResort = new MarkerOptions()
            .position(coordLakeCumberland)
            .title(MainActivity.parxContext.getString(R.string.park_lake_cumberland))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Lake Malone State Park
    private static LatLng coordLakeMalone = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.lake_malone_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.lake_malone_long)));
    private static MarkerOptions markLakeMalonePark = new MarkerOptions()
            .position(coordLakeMalone)
            .title(MainActivity.parxContext.getString(R.string.park_lake_malone))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Levi Jackson Wilderness Road State Park
    private static LatLng coordLeviJackson = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.levi_jackson_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.levi_jackson_long)));
    private static MarkerOptions markLeviJacksonPark = new MarkerOptions()
            .position(coordLeviJackson)
            .title(MainActivity.parxContext.getString(R.string.park_levi_jackson))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Lincoln Homestead State Historic Site
    private static LatLng coordLincolnHomestead = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.lincoln_homestead_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.lincoln_homestead_long)));
    private static MarkerOptions markLincolnHomesteadHistoric = new MarkerOptions()
            .position(coordLincolnHomestead)
            .title(MainActivity.parxContext.getString(R.string.park_lincoln_homestead))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Mineral Mound State Park
    private static LatLng coordMineralMound = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.mineral_mound_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.mineral_mound_long)));
    private static MarkerOptions markMineralMoundPark = new MarkerOptions()
            .position(coordMineralMound)
            .title(MainActivity.parxContext.getString(R.string.park_mineral_mound))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for My Old Kentucky Home State Park
    private static LatLng coordMyOldKyHome = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.my_old_ky_home_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.my_old_ky_home_long)));
    private static MarkerOptions markMyOldKyHomePark = new MarkerOptions()
            .position(coordMyOldKyHome)
            .title(MainActivity.parxContext.getString(R.string.park_old_ky_home))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Natural Bridge State Resort Park
    private static LatLng coordNaturalBridge = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.natural_bridge_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.natural_bridge_long)));
    private static MarkerOptions markNaturalBridgeResort = new MarkerOptions()
            .position(coordNaturalBridge)
            .title(MainActivity.parxContext.getString(R.string.park_natural_bridge))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Nolin Lake State Park
    private static LatLng coordNolinLake = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.nolin_lake_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.nolin_lake_long)));
    private static MarkerOptions markNolinLakePark = new MarkerOptions()
            .position(coordNolinLake)
            .title(MainActivity.parxContext.getString(R.string.park_nolin_lake))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Old Mulkey Meetinghouse State Historic Site
    private static LatLng coordOldMulkey = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.old_mulkey_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.old_mulkey_long)));
    private static MarkerOptions markOldMulkeyMeetinghouse = new MarkerOptions()
            .position(coordOldMulkey)
            .title(MainActivity.parxContext.getString(R.string.park_old_mulkey))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Paintsville Lake State Park
    private static LatLng coordPaintsville = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.paintsville_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.paintsville_long)));
    private static MarkerOptions markPaintsvilleLakePark = new MarkerOptions()
            .position(coordPaintsville)
            .title(MainActivity.parxContext.getString(R.string.park_paintsville_lake))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Pennyrile Forest State Resort Park
    private static LatLng coordPennyrile = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.pennyrile_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.pennyrile_long)));
    private static MarkerOptions markPennyrileForestResort = new MarkerOptions()
            .position(coordPennyrile)
            .title(MainActivity.parxContext.getString(R.string.park_pennyrile_forest))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Perryville Battlefield State Historic Site
    private static LatLng coordPerryville = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.perryville_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.perryville_long)));
    private static MarkerOptions markPerryvilleHistoric = new MarkerOptions()
            .position(coordPerryville)
            .title(MainActivity.parxContext.getString(R.string.park_perryville_battlefield))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Pine Mountain State Resort Park
    private static LatLng coordPineMountain = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.pine_mountain_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.pine_mountain_long)));
    private static MarkerOptions markPineMountainResort = new MarkerOptions()
            .position(coordPineMountain)
            .title(MainActivity.parxContext.getString(R.string.park_pine_mtn))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Pine Mountain Trail State Park
    private static LatLng coordPineMtnTrl = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.pine_mtn_trail_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.pine_mtn_trail_long)));
    private static MarkerOptions markPineMtnTrail = new MarkerOptions()
            .position(coordPineMtnTrl)
            .title(MainActivity.parxContext.getString(R.string.park_pint_mtn_trail))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Rough River Dam State Resort Park
    private static LatLng coordRoughRiver = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.rough_river_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.rough_river_long)));
    private static MarkerOptions markRoughRiverDamResort = new MarkerOptions()
            .position(coordRoughRiver)
            .title(MainActivity.parxContext.getString(R.string.park_rough_river_dam))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Taylorsville Lake State Park
    private static LatLng coordTaylorsville = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.taylorsville_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.taylorsville_long)));
    private static MarkerOptions markTaylorsvilleLakePark = new MarkerOptions()
            .position(coordTaylorsville)
            .title(MainActivity.parxContext.getString(R.string.park_taylorsville_lake))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Waveland State Historic Site
    private static LatLng coordWaveland = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.waveland_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.waveland_long)));
    private static MarkerOptions markWavelandHistoric = new MarkerOptions()
            .position(coordWaveland)
            .title(MainActivity.parxContext.getString(R.string.park_waveland))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for White Hall State Historic Site
    private static LatLng coordWhiteHall = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.white_hall_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.white_hall_long)));
    private static MarkerOptions markWhiteHallHistoric = new MarkerOptions()
            .position(coordWhiteHall)
            .title(MainActivity.parxContext.getString(R.string.park_white_hall))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Wickliffe Mounds State Historic Site
    private static LatLng coordWickliffeMounds = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.wickliffe_mounds_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.wickliffe_mounds_long)));
    private static MarkerOptions markWickliffeMoundsHistoric = new MarkerOptions()
            .position(coordWickliffeMounds)
            .title(MainActivity.parxContext.getString(R.string.park_wickliffe_mounds))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for William Whitley House State Historic Site
    private static LatLng coordWilliamWhitley = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.william_whitley_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.william_whitley_long)));
    private static MarkerOptions markWilliamWhitleyHistoric = new MarkerOptions()
            .position(coordWilliamWhitley)
            .title(MainActivity.parxContext.getString(R.string.park_william_whitley))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));

    // Marker and Info Window Data for Yatesville Lake State Park
    private static LatLng coordYatesville = new LatLng(
            Double.parseDouble(MainActivity.parxContext.getString(R.string.yatesville_lat)),
            Double.parseDouble(MainActivity.parxContext.getString(R.string.yatesville_long)));
    private static MarkerOptions markYatesvilleLakePark = new MarkerOptions()
            .position(coordYatesville)
            .title(MainActivity.parxContext.getString(R.string.park_yatesville_lake))
            .snippet(MainActivity.parxContext.getString(R.string.earn_badges_here));
}
