package com.vtayur.intellivote;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.vtayur.intellivote.menu.EditProfileActivity;
import com.vtayur.intellivote.menu.EditSettings;

public class HomeActivity extends ActionBarActivity {
    private static String TAG = "HomeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        final Context context = this.getApplicationContext();

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
//                Toast.makeText(HomeActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, VoteActivity.class);

                ProgramView pgmView = (ProgramView) v;

                intent.putExtra("position", Integer.toString(position));
                intent.putExtra("thumbId", Integer.toString(pgmView.getThumbId()));

                startActivity(intent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent intent = new Intent(this, EditSettings.class);
                Log.d(TAG, "Launching Settings Activity");
                startActivity(intent);
                break;

            case R.id.action_UserProfile:
                intent = new Intent(this, EditProfileActivity.class);
                Log.d(TAG, "Launching Profile edit Activity");
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
