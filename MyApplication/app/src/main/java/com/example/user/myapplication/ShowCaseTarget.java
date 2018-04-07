package com.example.user.myapplication;

import android.app.Activity;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ViewTarget;

/**
 * Created by User on 14/03/2018.
 */

/**
 * This class permits to build a target containing the explanation and showing the component
 */
public class ShowCaseTarget {
    private final int identifiant;
    private final String title;
    private final String description;

    /**
     * Build a target and this constructor is called by the method build of Builder class
     * @param builder a builder of target
     */
    private ShowCaseTarget(Builder builder) {
        this.identifiant = builder.identifiant;
        this.title = builder.title;
        this.description = builder.description;
    }

    /**
     * Give the identifiant of target. It permits to target on a component with this identifiant
     * @return the identifiant of target
     */
    public int getIdentifiant() {
        return identifiant;
    }

    /**
     * Give the title of target
     * @return the title of target
     */
    public String getTitle() {
        return title;
    }

    /**
     * Give the description of target. It permit to explain the role of the targeted component
     * @return the description of target
     */
    public String getDescription() {
        return description;
    }

    /**
     * Create a showcaseview related to the activity
     * @param activity the current activity
     * @return the showcaseview
     */
    public ShowcaseView.Builder create(Activity activity) {
        return new ShowcaseView.Builder(activity);
    }

    /**
     * Update all the data of target in showcaseview related to the activity
     * @param activity the current activity
     * @param scView the showcaseview updated
     */
    public void updateShowcaseView(Activity activity, ShowcaseView scView) {
        scView.setShowcase(new ViewTarget(identifiant, activity), true);
        scView.setContentTitle(title);
        scView.setContentText(description);
    }


    /**
     * This class Builder permits to build an ShowCaseTarget containing all data.
     */
    public static class Builder {
        private int identifiant;
        private String title;
        private String description;

        /**
         * Set an identifiant of showcasetarget
         * @param id the identifiant
         * @return a builder showcasetarget after setting the identifiant
         */
        public ShowCaseTarget.Builder setId(int id) {
            this.identifiant = id;
            return this;
        }

        /**
         * Set a title in showcasetarget
         * @param title a description
         * @return a builder showcasetarget after setting a title
         */
        public ShowCaseTarget.Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        /**
         * Set a description in showcasetarget
         * @param description a description
         * @return a builder showcasetarget after setting a description
         */
        public ShowCaseTarget.Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        /**
         * Build a showcasetarget with all the data defined
         * @return a showcasetarget containing all the data defined
         */
        public ShowCaseTarget build() {
            return new ShowCaseTarget(this);
        }
    }
}
