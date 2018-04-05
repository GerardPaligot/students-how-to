package com.example.user.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.Target;
import com.github.amlcurran.showcaseview.targets.ViewTarget;


public class ActivityA extends AppCompatActivity implements View.OnClickListener {

    private ShowCaseTutoriel tutoCurrent;
    private ShowCaseScreen screenCurrent;
    private int compteur;
    private ShowcaseView scView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maina);

        Button bouton1 = findViewById(R.id.bt_launch_activity);
        ImageButton bouton2 = findViewById(R.id.imageButton);

        tutoCurrent = ShowCaseTutorielSingleton.getInstance().getCurrentTutoriel();
        screenCurrent = tutoCurrent.getScreenWithName(this);

        ShowCaseTarget swTarget = screenCurrent.getTarget(0);
        scView = swTarget.create(this)
                .setTarget(Target.NONE)
                .setStyle(R.style.Transparencia)
                .setOnClickListener(this)
                .build();

        compteur = 0;

        bouton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivity();
            }
        });
        bouton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivity1();
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

    private void launchActivity() {
        Intent intent = new Intent(this, ActivityB.class);
        startActivityForResult(intent, 0);
    }

    private void launchActivity1() {
        Intent intent = new Intent(this, ActivityList.class);
        startActivityForResult(intent, 0);
    }
}