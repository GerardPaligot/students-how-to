package com.example.user.myapplication;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 28/01/2018.
 */


public class ActivityList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_listview);
        ListView listView = findViewById(R.id.listView);

        final List<ShowCaseTutoriel> listTutoriel = new ArrayList<ShowCaseTutoriel>();
        listTutoriel.add(createTuto1());
        listTutoriel.add(createTuto2());
        listTutoriel.add(createTuto3());



        List<String> listNameTutorial = new ArrayList<String>();
        for (int i = 0; i < listTutoriel.size(); i++) {
            listNameTutorial.add(listTutoriel.get(i).getName());
        }

        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listNameTutorial));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ShowCaseTutoriel tutoSelected = listTutoriel.get(position);
                ShowCaseTutorielSingleton.getInstance().setCurrentTutoriel(tutoSelected);
                tutoSelected.getScreens().get(0).start(ActivityList.this);
            }
        });
    }

    private ShowCaseTutoriel createTuto1() {
        return new ShowCaseTutoriel.Builder()
                .setName("Tuto1")
                .addScreen(new ShowCaseScreen.Builder()
                        .setName("ActivityA")
                        .addTarget(new ShowCaseTarget.Builder()
                                .setId(R.id.bt_launch_activity)
                                .setTitle("Bouton B")
                                .setDescription("Passez à l'acitivité B")
                                .build())
                        .addTarget(new ShowCaseTarget.Builder()
                                .setId(R.id.imageButton)
                                .setTitle("Bouton Home")
                                .setDescription("Revenez au menu")
                                .build())
                        .build())
                .addScreen(new ShowCaseScreen.Builder()
                        .setName("ActivityB")
                        .addTarget(new ShowCaseTarget.Builder()
                                .setId(R.id.butAB)
                                .setTitle("Bouton A")
                                .setDescription("Passez à l'activité précédente A")
                                .build())
                        .addTarget(new ShowCaseTarget.Builder()
                                .setId(R.id.butCB)
                                .setTitle("Bouton C")
                                .setDescription("Passez à l'activité C")
                                .build())
                        .addTarget(new ShowCaseTarget.Builder()
                                .setId(R.id.imageButtonB)
                                .setTitle("Bouton Home")
                                .setDescription("Revenez au menu")
                                .build())
                        .build())
                .addScreen(new ShowCaseScreen.Builder()
                        .setName("ActivityC")
                        .addTarget(new ShowCaseTarget.Builder()
                                .setId(R.id.butAC)
                                .setTitle("Bouton A ")
                                .setDescription("Passez à l'activité A")
                                .build())
                        .addTarget(new ShowCaseTarget.Builder()
                                .setId(R.id.butDC)
                                .setTitle("Bouton D ")
                                .setDescription("Passez à l'activité D")
                                .build())
                        .addTarget(new ShowCaseTarget.Builder()
                                .setId(R.id.imageButtonC)
                                .setTitle("Bouton Home")
                                .setDescription("Revenez au menu")
                                .build())
                        .build())
                .addScreen(new ShowCaseScreen.Builder()
                        .setName("ActivityD")
                        .addTarget(new ShowCaseTarget.Builder()
                                .setId(R.id.butC)
                                .setTitle("Bouton C ")
                                .setDescription("Passez à l'acitivité C")
                                .build())
                        .addTarget(new ShowCaseTarget.Builder()
                                .setId(R.id.imageButton)
                                .setTitle("Bouton Home")
                                .setDescription("Revenez au menu")
                                .build())
                        .build())
                .build();
    }

    private ShowCaseTutoriel createTuto2() {
        return new ShowCaseTutoriel.Builder()
                .setName("Tuto2")
                .addScreen(new ShowCaseScreen.Builder()
                        .setName("ActivityC")
                        .addTarget(new ShowCaseTarget.Builder()
                                .setId(R.id.butAC)
                                .setTitle("Bouton A ")
                                .setDescription("Passez à l'activité A")
                                .build())
                        .addTarget(new ShowCaseTarget.Builder()
                                .setId(R.id.butDC)
                                .setTitle("Bouton D ")
                                .setDescription("Passez à l'activité D")
                                .build())
                        .addTarget(new ShowCaseTarget.Builder()
                                .setId(R.id.imageButtonC)
                                .setTitle("Bouton Home")
                                .setDescription("Revenez au menu")
                                .build())
                        .build())
                .addScreen(new ShowCaseScreen.Builder()
                        .setName("ActivityD")
                        .addTarget(new ShowCaseTarget.Builder()
                                .setId(R.id.butC)
                                .setTitle("Bouton C ")
                                .setDescription("Passez à l'acitivité C")
                                .build())
                        .addTarget(new ShowCaseTarget.Builder()
                                .setId(R.id.imageButton)
                                .setTitle("Bouton Home")
                                .setDescription("Revenez au menu")
                                .build())
                        .build())
                .build();
    }

    private ShowCaseTutoriel createTuto3() {
        return new ShowCaseTutoriel.Builder()
                .setName("Tuto3")
                .addScreen(new ShowCaseScreen.Builder()
                        .setName("ActivityB")
                        .addTarget(new ShowCaseTarget.Builder()
                                .setId(R.id.butAB)
                                .setTitle("Bouton A")
                                .setDescription("Passez à l'activité précédente A")
                                .build())
                        .addTarget(new ShowCaseTarget.Builder()
                                .setId(R.id.butCB)
                                .setTitle("Bouton C")
                                .setDescription("Passez à l'activité C")
                                .build())
                        .addTarget(new ShowCaseTarget.Builder()
                                .setId(R.id.imageButtonB)
                                .setTitle("Bouton Home")
                                .setDescription("Revenez au menu")
                                .build())
                        .build())
                .addScreen(new ShowCaseScreen.Builder()
                        .setName("ActivityC")
                        .addTarget(new ShowCaseTarget.Builder()
                                .setId(R.id.butAC)
                                .setTitle("Bouton A ")
                                .setDescription("Passez à l'activité A")
                                .build())
                        .addTarget(new ShowCaseTarget.Builder()
                                .setId(R.id.butDC)
                                .setTitle("Bouton D ")
                                .setDescription("Passez à l'activité D")
                                .build())
                        .addTarget(new ShowCaseTarget.Builder()
                                .setId(R.id.imageButtonC)
                                .setTitle("Bouton Home")
                                .setDescription("Revenez au menu")
                                .build())
                        .build())
                .addScreen(new ShowCaseScreen.Builder()
                        .setName("ActivityD")
                        .addTarget(new ShowCaseTarget.Builder()
                                .setId(R.id.butC)
                                .setTitle("Bouton C ")
                                .setDescription("Passez à l'acitivité C")
                                .build())
                        .addTarget(new ShowCaseTarget.Builder()
                                .setId(R.id.imageButton)
                                .setTitle("Bouton Home")
                                .setDescription("Revenez au menu")
                                .build())
                        .build())
                .build();
    }
}
