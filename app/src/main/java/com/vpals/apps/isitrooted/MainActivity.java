package com.vpals.apps.isitrooted;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import eu.chainfire.libsuperuser.Shell;


public class MainActivity extends AppCompatActivity {

    Button btnCheck;
    boolean suAvailable = false;
    TextView resultText;
    String resultStr = "No it is not1 :(";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button btnCheck = (Button) findViewById(R.id.btnCheck);
        resultText = (TextView) findViewById(R.id.resultText);
        resultStr = "No it is not! :(";
        btnCheck.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                suAvailable = Shell.SU.available();
                if (suAvailable)
                    resultStr = "Yes it is! :)";
                resultText.setText(resultStr);
            }
        } );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_reset) {
            resultText = (TextView) findViewById(R.id.resultText);
            resultText.setText("");
        }

        return super.onOptionsItemSelected(item);
    }
}
