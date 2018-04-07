package com.example.user.myapplication;
import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;
import android.content.Intent;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.Target;

public class ActivityC extends Activity implements View.OnClickListener{

    private ShowCaseTutoriel tutoCurrent;
    private ShowCaseScreen screenCurrent;

    private int compteur;
    private ShowcaseView scView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainc);

        Button butAC = findViewById(R.id.butAC);
        Button butDC = findViewById(R.id.butDC);
        ImageButton imageButtonC= findViewById(R.id.imageButtonC);

        tutoCurrent = ShowCaseTutorielSingleton.getInstance().getCurrentTutoriel();
        screenCurrent = tutoCurrent.getScreenWithName("ActivityC");

        ShowCaseTarget swTarget = screenCurrent.getTarget(0);
        scView = swTarget.create(this)
                .setTarget(Target.NONE)
                .setStyle(R.style.Transparencia)
                .setOnClickListener(this)
                .build();

        compteur = 0;

        butAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivityA();
            }
        });
        butDC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivityD();
            }
        });
        imageButtonC.setOnClickListener(new View.OnClickListener() {
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
    private void launchActivityA() {
        Intent intent = new Intent(this, ActivityA.class);
        startActivity(intent);
    }

    private void launchActivityD() {
        Intent intent = new Intent(this, ActivityD.class);
        startActivityForResult(intent, 0);
    }

    private void launchActivityImage() {
        Intent intent = new Intent(this, ActivityList.class);
        startActivityForResult(intent, 0);
    }

}
