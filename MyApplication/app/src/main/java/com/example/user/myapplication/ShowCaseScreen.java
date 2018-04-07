package com.example.user.myapplication;

import android.app.Activity;
import android.content.Intent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by User on 15/02/2018.
 */

/**
 * This class permit to build a screen contains all composants (button, image button ... )
 */
public class ShowCaseScreen {
    private final String name;
    private final List<ShowCaseTarget> targets;

    /**Build a screen and this constructor is called by the method build of Builder class
     *
     * @param builder a builder of screen
     */
    private ShowCaseScreen(Builder builder) {
        this.name = builder.name;
        this.targets = builder.targets;
    }

    /**
     * Give the name of the screen
     * @return the name of this screen
     */
    public String getName() {
        return name;
    }

    /**
     * Give a target contained in a list of targets
     * @param i the index of list of targets
     * @return the target i in list of targets
     */
    public ShowCaseTarget getTarget(int i) {
        return Collections.unmodifiableList(targets).get(i);
    }

    /**
     * Give the number of targets in total in this screen
     * @return the number of targets
     */
    public int getTargetSize() {
        return targets.size();
    }

    /**
     * Start the next activity that is start the activity after the current activity
     * @param activity the current activity
     */
    public void start(Activity activity) {
        switch (name) {
            case "ActivityA":
                activity.startActivity(new Intent(activity, ActivityA.class));
                break;
            case "ActivityB":
                activity.startActivity(new Intent(activity, ActivityB.class));
                break;
            case "ActivityC":
                activity.startActivity(new Intent(activity, ActivityC.class));
                break;
            case "ActivityD":
                activity.startActivity(new Intent(activity, ActivityD.class));
                break;
        }
    }

    /**
     * This class Builder permits to build a ShowCaseScreen containing all data.
     */
    public static class Builder {
        private String name;
        private List<ShowCaseTarget> targets = new ArrayList<ShowCaseTarget>();

        /**
         * Set a name of showcasescreen
         * @param name the screen name
         * @return a builder showcasescreen after setting the name
         */
        public ShowCaseScreen.Builder setName(String name) {
            this.name = name;
            return this;
        }

        /**
         * Add a target in showcasescreen
         * @param target a target to add
         * @return a builder showcasescreen after adding a target
         */
        public ShowCaseScreen.Builder addTarget(ShowCaseTarget target) {
            this.targets.add(target);
            return this;
        }

        /**
         * Build a showcasescreen with all the data defined
         * @return a showcasescreen containing all the data defined
         */
        public ShowCaseScreen build() {
            return new ShowCaseScreen(this);
        }
    }
}
