package com.example.user.myapplication;

import android.app.Activity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by User on 15/02/2018.
 */

public class ShowCaseTutoriel {
    private final String name;
    private final List<ShowCaseScreen> listScreens;

    private ShowCaseTutoriel(Builder builder) {
        this.name = builder.name;
        this.listScreens = builder.listScreen;
    }

    public String getName() {
        return name;
    }

    public List<ShowCaseScreen> getScreens() {
        return Collections.unmodifiableList(listScreens);
    }

    public ShowCaseScreen getScreenWithName(String nameScreen) {
        for (ShowCaseScreen screen : listScreens) {
            if (nameScreen.equals(screen.getName())) {
                return screen;
            }
        }
        return null;
    }

    public ShowCaseScreen getScreenWithName(Activity activity) {
        return getScreenWithName(activity.getClass().getSimpleName());
    }

    public ShowCaseScreen getNextScreenName(Activity activity) {
        for (int i = 0; i < listScreens.size(); i++) {
            if (listScreens.get(i).getName().equals(activity.getClass().getSimpleName())) {
                if (i + 1 < listScreens.size()) {
                    return listScreens.get(i + 1);
                }
                return null;
            }
        }
        return null;
    }

    public static class Builder {
        private String name;
        private List<ShowCaseScreen> listScreen = new ArrayList<ShowCaseScreen>();

        public ShowCaseTutoriel.Builder setName(String name) {
            this.name = name;
            return this;
        }

        public ShowCaseTutoriel.Builder addScreen(ShowCaseScreen screen) {
            this.listScreen.add(screen);
            return this;
        }

        public ShowCaseTutoriel build() {
            return new ShowCaseTutoriel(this);
        }
    }
}



