package com.vtayur.intellivote;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
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

        final Activity voteAct = this;

        Button btn = (Button) findViewById(R.id.buttonVoteSubmit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(VoteActivity.this, "Your vote was registered. Thank You!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(voteAct, PollTrendActivity.class);
                Log.d("VoteActivity", "Launching Settings Activity");
                startActivity(intent);
                finish();
//                setResult(Activity.RESULT_OK);
//                finish();
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
        return super.onOptionsItemSelected(item);
    }
}
