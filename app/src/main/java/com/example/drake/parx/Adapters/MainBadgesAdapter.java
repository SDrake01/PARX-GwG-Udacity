package com.example.drake.parx.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.drake.parx.R;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.games.achievement.Achievement;

import java.util.List;

public class MainBadgesAdapter extends RecyclerView.Adapter<MainBadgesAdapter.BadgesViewHolder> {

    private Context context;

    public static List<Achievement> adapterBadgesList;

    public MainBadgesAdapter(Context context){
        LayoutInflater inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public BadgesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context holderContext = parent.getContext();
        int badgesCardLayoutId = R.layout.main_item_card_badges;
        LayoutInflater holderInflater = LayoutInflater.from(holderContext);
        View holderView = holderInflater.inflate(badgesCardLayoutId, parent, false);

        return new BadgesViewHolder(holderContext, holderView);
    }

    @Override
    public void onBindViewHolder(@NonNull BadgesViewHolder badgesHolder, int position) {
        badgesHolder.bind(position);
    }

    @Override
    public int getItemCount() {
        if (adapterBadgesList == null) {
            return 0;
        }else {
            return adapterBadgesList.size();
        }
    }

    class BadgesViewHolder extends RecyclerView.ViewHolder {

        final TextView badgesCardName;
        final ImageView badgesCardImage;
        final Context context;

        public BadgesViewHolder(Context context, View itemView) {
            super(itemView);

            badgesCardName = itemView.findViewById(R.id.tv_main_badges_card_name);
            badgesCardImage = itemView.findViewById(R.id.iv_main_badges_card_image);

            this.context = context;
            // Delete on click listener if not needed for the project
//            itemView.setOnClickListener(this);
        }

        void bind(int position) {
            ImageManager badgeManager = ImageManager.create(context);
            if (adapterBadgesList.get(position).getState() == Achievement.STATE_UNLOCKED){
                // The badge has been earned, show the full color image
                badgeManager.loadImage(badgesCardImage, adapterBadgesList.get(position).getUnlockedImageUri());
            }else {
                // The badge has not yet been earned, show the greyscale image
                badgeManager.loadImage(badgesCardImage, adapterBadgesList.get(position).getRevealedImageUri());
            }
            badgesCardName.setText(adapterBadgesList.get(position).getName());
        }
    }

    public void setBadges(List<Achievement> newBadgesList){
        adapterBadgesList = newBadgesList;
        notifyDataSetChanged();
    }
}
