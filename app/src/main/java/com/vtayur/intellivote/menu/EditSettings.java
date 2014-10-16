package com.vtayur.intellivote.menu;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.vtayur.intellivote.R;

/**
 * Created by vtayur on 10/15/2014.
 */
public class EditSettings extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button btn = (Button) findViewById(R.id.buttonSaveChannelSettings);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EditSettings.this, "Your changes were saved.", Toast.LENGTH_SHORT).show();
                setResult(Activity.RESULT_OK);
                finish();
            }
        });

//        final CheckedTextView ctv = (CheckedTextView) findViewById(R.id.ctvChannels);
//        ctv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (ctv.isChecked())
//                    ctv.setChecked(false);
//                else
//                    ctv.setChecked(true);
//
//            }
//        });

        final ListView lstChannels = (ListView) findViewById(R.id.listChannels);
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_settings_checkedtextview,
                new String[]{"Channel 1", "Channel 2", "Channel 3", "Channel 4", "Channel 5", "Channel 6", "Channel 7", "Channel 8", "Channel 9", "Channel 11", "Channel 12"});
        lstChannels.setAdapter(adapter);


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
