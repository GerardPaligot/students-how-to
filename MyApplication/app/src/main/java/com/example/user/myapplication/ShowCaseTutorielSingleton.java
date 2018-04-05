package com.example.user.myapplication;

/**
 * Created by User on 15/02/2018.
 */

public class ShowCaseTutorielSingleton {
    private static ShowCaseTutorielSingleton INSTANCE = null;
    private ShowCaseTutoriel tuto = null;

    public static ShowCaseTutorielSingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ShowCaseTutorielSingleton();
        }
        return INSTANCE;
    }

    private ShowCaseTutorielSingleton() {
    }

    public ShowCaseTutoriel getCurrentTutoriel() {
        return this.tuto;
    }

    public void setCurrentTutoriel(ShowCaseTutoriel tuto) {
        this.tuto = tuto;
    }
}
