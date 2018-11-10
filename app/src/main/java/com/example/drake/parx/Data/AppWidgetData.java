package com.example.drake.parx.Data;

public class AppWidgetData {

    private static int widgetEarned;
    private static int widgetTotal;

    public static void setWidgetEarned(int earned){widgetEarned = earned;}

    public static int getWidgetEarned() {
        return widgetEarned;
    }

    public static void setWidgetTotal(int total){widgetTotal = total;}

    public static int getWidgetTotal(){
        return widgetTotal;
    }
}