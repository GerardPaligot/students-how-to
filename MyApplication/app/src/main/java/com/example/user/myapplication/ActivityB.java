package com.example.user.myapplication;

/**
 * Created by User on 27/01/2018.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.Target;

public class ActivityB extends Activity implements View.OnClickListener {

    private ShowCaseTutoriel tutoCurrent;
    private ShowCaseScreen screenCurrent;

    private int compteur;
    private ShowcaseView scView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainb);

        Button butAB = findViewById(R.id.butAB);
        Button butCB = findViewById(R.id.butCB);
        ImageButton buttonMenuB = findViewById(R.id.imageButtonB);

        tutoCurrent = ShowCaseTutorielSingleton.getInstance().getCurrentTutoriel();
        screenCurrent = tutoCurrent.getScreenWithName(this);

        ShowCaseTarget swTarget = screenCurrent.getTarget(0);
        scView = swTarget.create(this)
                .setTarget(Target.NONE)
                .setStyle(R.style.Transparencia)
                .setOnClickListener(this)
                .build();

        compteur = 0;

        buttonMenuB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivityImage();
            }
        });
        butAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivityA();
            }
        });
        butCB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivityC();
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
        startActivityForResult(intent, 0);
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
