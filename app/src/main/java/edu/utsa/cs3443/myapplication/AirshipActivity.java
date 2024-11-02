package edu.utsa.cs3443.myapplication;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import edu.utsa.cs3443.myapplication.model.Fleet;
import edu.utsa.cs3443.myapplication.model.Wizard;

/**
 * Receives data from main activity to display a specific airship and ArrayList of wizards and dynamically loads
 * the wizards onto a scrollview
 *
 * @author mathewrobillard
 */
public class AirshipActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airship);

        TextView airshipInfo = findViewById(R.id.textView6);

        String airshipNameText = getIntent().getStringExtra(MainActivity.decodeIntentAirshipName());
        String airshipRegistryText = getIntent().getStringExtra(MainActivity.decodeIntentAirshipRegistry());
        String airshipInfoText = airshipNameText + " " + airshipRegistryText;
        int airshipIndex = getIntent().getIntExtra("myInt", 0);
        airshipInfo.setText(airshipInfoText);
        dynamicSetup(MainActivity.getFleet().getAirship(airshipIndex).getWizards());

    }

    /**
     * Dynamically displays the wizards specific to their airship
     *
     * @param wizards, ArrayList of wizards of type wizard
     */
    private void dynamicSetup(ArrayList<Wizard> wizards){

        if(wizards == null){
            return;
        }
        //dynamically add the imageView of each wizard and the textView containing their info
        LinearLayout verticalLayout = findViewById(R.id.Root_LL);

        for(Wizard wizard: wizards){

            LinearLayout horizontalLayout = new LinearLayout(this);
            horizontalLayout.setOrientation(LinearLayout.HORIZONTAL);
            horizontalLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
            horizontalLayout.setPadding(0, 10, 10, 50);
            horizontalLayout.setGravity(Gravity.LEFT);

            ImageView imageView = new ImageView(this);
            int imageResource = getResources().getIdentifier(wizard.getImageFile(), "drawable", getPackageName());
            imageView.setImageResource(imageResource);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(200, 200));
            imageView.setPadding(0, 0, 0, 0);

            //add a linear layout to the horizontal view so that both text views can be nested within it
            LinearLayout verticalLayout2 = new LinearLayout(this);
            verticalLayout2.setOrientation(LinearLayout.VERTICAL);
            verticalLayout2.setLayoutParams(new ViewGroup.LayoutParams(450, ViewGroup.LayoutParams.MATCH_PARENT));
            verticalLayout2.setPadding(75, 0, 0, 0);

            TextView textView = new TextView(this);
            textView.setText(wizard.getName());
            textView.setTextColor(Color.BLUE);
            textView.setTextSize(14);
            textView.setPadding(50,0,10,0);
            textView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1));

            TextView textView2 = new TextView(this);
            textView2.setText(wizard.getRank());
            textView2.setTextColor(Color.BLUE);
            textView2.setTypeface(Typeface.DEFAULT_BOLD);
            textView2.setTextSize(18);
            textView2.setPadding(50,0,10,0);
            textView2.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1));

            //adding the textview to the nested vertical linear layout
            verticalLayout2.addView(textView2);
            verticalLayout2.addView(textView);

            //adding the imageview and linear layout to the horizontal layout
            horizontalLayout.addView(imageView);
            horizontalLayout.addView(verticalLayout2);

            //adding the horizontal layout to the root vertical linear layout
            verticalLayout.addView(horizontalLayout);

        }

    }

}