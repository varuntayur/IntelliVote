package com.vtayur.intellivote.detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.vtayur.intellivote.R;

/**
 * Created by vtayur on 10/8/2014.
 */
public class ProgramView extends FrameLayout {

    private Integer thumbId;

    public ProgramView(Context context, Integer mThumbId, int position) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.program_view, this, true);

        ImageView mImage = (ImageView) findViewById(R.id.image_place_holder);
        mImage.setImageDrawable(context.getResources().getDrawable(mThumbId));

        TextView caption = (TextView) findViewById(R.id.image_caption);
        caption.setText("Channel " + position + " - Program " + (position + 1) + "\n" + "(" + "100k votes)");
        thumbId = mThumbId;
    }

    public Integer getThumbId() {
        return thumbId;
    }
}
