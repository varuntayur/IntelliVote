package com.vtayur.intellivote.menu;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.vtayur.intellivote.R;
import com.vtayur.intellivote.util.Preferences;

/**
 * Created by vtayur on 10/15/2014.
 */
public class EditProfileActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        Button btn = (Button) findViewById(R.id.buttonSaveUserProfile);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EditProfileActivity.this, "Your changes were saved.", Toast.LENGTH_SHORT).show();
                setResult(Activity.RESULT_OK);
                finish();
            }
        });

        SharedPreferences settings = getSharedPreferences(Preferences.PREFS_NAME, 0);
        String savedUser = settings.getString(Preferences.USER_ID, "");
        String savedPasswd = settings.getString(Preferences.USER_PASSWORD, "");

        Log.d("EditProfile", "User:" + savedUser + " Pw:" + savedPasswd);

        if (!savedUser.isEmpty() && !savedPasswd.isEmpty()) {
            TextView tvUser = (TextView) findViewById(R.id.tvEmailAddress);
            tvUser.setText(savedUser);
            TextView tvPassword = (TextView) findViewById(R.id.tvPassword);
            tvPassword.setText(savedPasswd);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
