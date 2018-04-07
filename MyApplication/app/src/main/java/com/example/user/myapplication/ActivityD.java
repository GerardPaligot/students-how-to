package com.example.user.myapplication;
import android.app.Activity;
import android.os.Bundle;
/**
 * Created by User on 27/01/2018.
 */
import android.widget.*;
import android.view.View;
import android.content.Intent;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.Target;

public class ActivityD extends Activity implements View.OnClickListener{

    private ShowCaseTutoriel tutoCurrent;
    private ShowCaseScreen screenCurrent;

    private int compteur;
    private ShowcaseView scView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maind);
        Button butC = findViewById(R.id.butC);
        ImageButton bouton2= findViewById(R.id.imageButton);

        tutoCurrent = ShowCaseTutorielSingleton.getInstance().getCurrentTutoriel();
        screenCurrent = tutoCurrent.getScreenWithName("ActivityD");

        ShowCaseTarget swTarget = screenCurrent.getTarget(0);
        scView = swTarget.create(this)
                .setTarget(Target.NONE)
                .setStyle(R.style.Transparencia)
                .setOnClickListener(this)
                .build();

        compteur = 0;

        butC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivityC();
            }
        });
        bouton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivityImage();
            }
        });
    }


    @Override
    public void onClick(View view) {
        if (screenCurrent.getTargetSize() <= compteur) {
            final ShowCaseScreen nextScreenName = tutoCurrent.getNextScreenName(this);
            if (nextScreenName == null) {
                // Finish tutorial.
                return;
            }
            nextScreenName.start(this);
            return;
        }
        screenCurrent.getTarget(compteur).updateShowcaseView(this, scView);
        compteur++;
    }


    private void launchActivityC() {
       Intent intent = new Intent(this, ActivityC.class);
        startActivityForResult(intent, 0);
    }

    private void launchActivityImage() {
        Intent intent = new Intent(this, ActivityList.class);
        startActivityForResult(intent, 0);
    }

}
