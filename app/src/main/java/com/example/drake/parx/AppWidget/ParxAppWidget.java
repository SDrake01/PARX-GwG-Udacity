package com.example.drake.parx.AppWidget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

import com.example.drake.parx.Data.AppWidgetData;
import com.example.drake.parx.R;

/**
 * Implementation of App Widget functionality.
 */
public class ParxAppWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        // These are hard-coded until I can get the values for them passed in
        int earned = AppWidgetData.getWidgetEarned();
        int total = AppWidgetData.getWidgetTotal();

        CharSequence widgetEarnedText = context.getString(R.string.appwidget_earned_text, earned, total);
        CharSequence widgetTitleText = context.getString(R.string.app_name);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.parx_app_widget);
        views.setTextViewText(R.id.tv_widget_earned_text, widgetEarnedText);
        views.setTextViewText(R.id.tv_widget_title, widgetTitleText);
        views.setImageViewResource(R.id.iv_widget_icon,R.mipmap.ic_launcher);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

