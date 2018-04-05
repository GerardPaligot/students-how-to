package com.example.user.myapplication;

import android.app.Activity;
import android.content.Intent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by User on 15/02/2018.
 */

public class ShowCaseScreen {
    private final String name;
    private final List<ShowCaseTarget> targets;

    private ShowCaseScreen(Builder builder) {
        this.name = builder.name;
        this.targets = builder.targets;
    }

    public String getName() {
        return name;
    }

    public ShowCaseTarget getTarget(int i) {
        return Collections.unmodifiableList(targets).get(i);
    }

    public int getTargetSize() {
        return targets.size();
    }

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

    public static class Builder {
        private String name;
        private List<ShowCaseTarget> targets = new ArrayList<ShowCaseTarget>();

        public ShowCaseScreen.Builder setName(String name) {
            this.name = name;
            return this;
        }

        public ShowCaseScreen.Builder addTarget(ShowCaseTarget target) {
            this.targets.add(target);
            return this;
        }

        public ShowCaseScreen build() {
            return new ShowCaseScreen(this);
        }
    }
}
