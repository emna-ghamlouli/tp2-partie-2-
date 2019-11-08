package com.example.counterhomework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private int mCount = 0;
    private TextView Count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Count = (TextView) findViewById(R.id.show_count);
        Log.i(LOG_TAG, " avant d'implémenter onSaveInstanceState() L'EditText ne contient plus le texte que vous avez entré, mais le compteur est conservé");
        Log.i(LOG_TAG, "lorsqu'un changement de configuration de périphérique Android ferme immédiatement votre activité en appelant onStop(). Votre code doit redémarrer l'activité");
        Log.i(LOG_TAG," onSaveInstanceState() est appelée avant la méthode onResume()");
       Log.i(LOG_TAG,"onResume() ou onCreate()");
        if (savedInstanceState != null) {boolean isVisible =
                savedInstanceState.getBoolean("reply");

                if (isVisible) {
                  Count.setVisibility(View.VISIBLE);
                    Count.setText(savedInstanceState
                            .getString("msg"));
                    Count.setVisibility(View.VISIBLE);
                }
            }
        }

    public void countUp(View view) {
        mCount++;
        if (Count != null)
           Count.setText(Integer.toString(mCount));
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (Count.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply", true);
            outState.putString("msg", Count.getText().toString());
        }

    }

}
