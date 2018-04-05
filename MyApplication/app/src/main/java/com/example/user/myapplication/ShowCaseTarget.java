package com.example.user.myapplication;

import android.app.Activity;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ViewTarget;

/**
 * Created by User on 14/03/2018.
 */

public class ShowCaseTarget {
    private final int identifiant;
    private final String title;
    private final String description;

    private ShowCaseTarget(Builder builder) {
        this.identifiant = builder.identifiant;
        this.title = builder.title;
        this.description = builder.description;
    }

    public int getIdentifiant() {
        return identifiant;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public ShowcaseView.Builder create(Activity activity) {
        return new ShowcaseView.Builder(activity);
    }

    public void updateShowcaseView(Activity activity, ShowcaseView scView) {
        scView.setShowcase(new ViewTarget(identifiant, activity), true);
        scView.setContentTitle(title);
        scView.setContentText(description);
    }

    public String toString() {
        return "target " + this.getIdentifiant();
    }

    public static class Builder {
        private int identifiant;
        private String title;
        private String description;

        public ShowCaseTarget.Builder setId(int id) {
            this.identifiant = id;
            return this;
        }

        public ShowCaseTarget.Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public ShowCaseTarget.Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public ShowCaseTarget build() {
            return new ShowCaseTarget(this);
        }
    }
}
