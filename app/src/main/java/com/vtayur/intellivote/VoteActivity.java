package com.vtayur.intellivote;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class VoteActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);

        String position = getIntent().getStringExtra("position");
        String thumbId = getIntent().getStringExtra("thumbId");

        ImageView image = (ImageView) findViewById(R.id.image_place_holder);
        image.setImageDrawable(getResources().getDrawable(Integer.parseInt(thumbId)));

        TextView tv = (TextView) findViewById(R.id.tvProgramName);
        tv.setText("Channel " + position + " - Program " + (position + 1) + "\n" + "(" + "100k votes)");

        Button btn = (Button) findViewById(R.id.buttonVoteSubmit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(VoteActivity.this, "Your vote was registered. Thank You!", Toast.LENGTH_SHORT).show();
                setResult(Activity.RESULT_OK);
                finish();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
