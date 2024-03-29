/*
 *   @author:Keisha Ching
 *   Class: CS 301
 *   Homework 2
 *   Date: 10/01/2019
 *
 */

package com.example.homework2;

import android.app.Activity;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SeekBar;

public class FaceController extends Activity implements AdapterView.OnItemSelectedListener, SeekBar.OnSeekBarChangeListener, View.OnClickListener {

    private Face myFace;

    //constructor
    public FaceController(Face face)
    {

        myFace = face;
    }

    //Spinner: user can change hairstyle depending on spinner option chosen
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        /*
        External Citation
        Date: 25 September 2019
        Problem: Did not know how to use spinner

        Resource:
        https://stackoverflow.com/questions/13377361/
        how-to-create-a-drop-down-list
        Solution: I used the example code from this post.
        */

        switch (i) {
            case 0:
                myFace.hairStyle = 0;
                myFace.invalidate();
                break;
            case 1:
                myFace.hairStyle = 1;
                myFace.invalidate();
                break;
            case 2:
                myFace.hairStyle = 2;
                myFace.invalidate();
                break;
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) { }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    //Seekbar: r/g/b color changes depending on user input
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        switch (seekBar.getId())
        {
            case R.id.redSeekBar:
                myFace.redColor = progress;
                myFace.invalidate();
                break;
            case R.id.blueSeekBar:
                myFace.blueColor = progress;
                myFace.invalidate();
                break;
            case R.id.greenSeekBar:
                myFace.greenColor = progress;
                myFace.invalidate();
                break;
        }
    }

    public void onStartTrackingTouch(SeekBar seekBar) { }

    public void onStopTrackingTouch(SeekBar seekBar) { }

    //radio button and random button
    public void onClick(View view) {
        /*
        External Citation
        Date: 25 September 2019
        Problem: Did not know how to use multiple buttons

        Resource:
        https://stackoverflow.com/questions/25905086/
        multiple-buttons-onclicklistener-android
        Solution: I used the example code from this post.
        */

        switch(view.getId()){
            case R.id.button:   //random face button: creates random face when pushed
                myFace.randomize();
                myFace.invalidate();
                break;

            case R.id.hairButton:
                //only lets hair color be changed
                myFace.hairChecked = true;
                myFace.eyesChecked = false;
                myFace.skinChecked = false;

                /*
                 External Citation
                 Date: 27 September 2019
                 Problem: Could not figure out how to get r/g/b color ints

                 Resource:
                 https://stackoverflow.com/questions/42336425/get-red-blue
                 -or-green-channel-from-android-color-object
                 Solution: I used the example code from this post.
                 */

                //gets color value based on previous hair color
                int red = Color.red(myFace.finalHairColor.getColor());
                int green = Color.green(myFace.finalHairColor.getColor());
                int blue = Color.blue(myFace.finalHairColor.getColor());

                /*
                 External Citation
                 Date: 27 September 2019
                 Problem: Did not know how to call a method from MainActivity

                 Resource:
                 https://stackoverflow.com/questions/17315842/how-to-call-a-method-in-mainactivity-from-another-class
                 Solution: I used the example code from this post.
                 */

                //sets corresponding seek bar to r/g/b hair color value
                MainActivity.getInstance().redSeekBar.setProgress(red);
                MainActivity.getInstance().greenSeekBar.setProgress(green);
                MainActivity.getInstance().blueSeekBar.setProgress(blue);

                myFace.invalidate();
                break;

            case R.id.eyesButton:
                //only lets eye color be changed
                myFace.eyesChecked = true;
                myFace.hairChecked = false;
                myFace.skinChecked = false;

                int red1 = Color.red(myFace.finalEyeColor.getColor());
                int green1 = Color.green(myFace.finalEyeColor.getColor());
                int blue1 = Color.blue(myFace.finalEyeColor.getColor());

                MainActivity.getInstance().redSeekBar.setProgress(red1);
                MainActivity.getInstance().greenSeekBar.setProgress(green1);
                MainActivity.getInstance().blueSeekBar.setProgress(blue1);

                myFace.invalidate();
                break;

            case R.id.skinButton:
                //only lets skin color be changed
                myFace.skinChecked = true;
                myFace.eyesChecked = false;
                myFace.hairChecked = false;

                int red2 = Color.red(myFace.finalSkinColor.getColor());
                int green2 = Color.green(myFace.finalSkinColor.getColor());
                int blue2 = Color.blue(myFace.finalSkinColor.getColor());

                MainActivity.getInstance().redSeekBar.setProgress(red2);
                MainActivity.getInstance().greenSeekBar.setProgress(green2);
                MainActivity.getInstance().blueSeekBar.setProgress(blue2);

                myFace.invalidate();
                break;
        }
    }
}
