package edu.utsa.cs3443.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs3443.myapplication.model.Fleet;

/**
 * MainActivity for the app, displays the menu for the airships and passes data to the airshipActivity for filtering
 *
 * @author mathewrobillard
 */
public class MainActivity extends AppCompatActivity {

    private static Fleet fleet;
    private static final String airshipName = "airship name";
    private static final String airshipRegistry = "airship registry";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createFleet();

        Button airshsip1 = findViewById(R.id.button);
        Button airshsip2 = findViewById(R.id.button2);
        Button airshsip3 = findViewById(R.id.button3);
        Button airshsip4 = findViewById(R.id.button4);

        airshsip1.setText(displayButtonText(0));
        airshsip2.setText(displayButtonText(1));
        airshsip3.setText(displayButtonText(2));
        airshsip4.setText(displayButtonText(3));

        airshsip1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                launchActivity(0);
            }
        });

        airshsip2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                launchActivity(1);
            }
        });

        airshsip3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                launchActivity(2);
            }
        });

        airshsip4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                launchActivity(3);
            }
        });

    }

    /**
     * Gets the fleet object from the mainActivity
     *
     * @return returns the fleet object
     */
    public static Fleet getFleet(){
        return fleet;
    }

    /**
     * gets the airship name intent key
     *
     * @return returns the airship name
     */
    public static String decodeIntentAirshipName() {
        return airshipName;
    }

    /**
     * gets the airship registry intent key
     *
     * @return returns the airship registry
     */
    public static String decodeIntentAirshipRegistry() {
        return airshipRegistry;
    }

    /**
     * initializes the fleet object, reads the data from both csv files and loads it into the fleet
     */
    private void createFleet(){
        fleet = new Fleet("My Fleet");
        fleet.loadAirships(this);
    }

    /**
     * Launches the airship activity passing data about the airship to filter which airship will be displayed
     *
     * @param i, index of the airship in the ArrayList
     */
    private void launchActivity(int i){

        Intent intent = new Intent(this, AirshipActivity.class);
        String airship_name = fleet.getAirship(i).getName();
        String airship_registry = fleet.getAirship(i).getRegistry();

        intent.putExtra(airshipName, airship_name);
        intent.putExtra(airshipRegistry, airship_registry);
        intent.putExtra("myInt", i);

        startActivity(intent);
    }

    /**
     * Fills the button name with the correct airship name and registry
     *
     * @param airshipIdx, index of the airship in the ArrayList
     * @return returns the name of the airship and the registry
     */
    private String displayButtonText(int airshipIdx){
        return fleet.getAirship(airshipIdx).getName() + " " + fleet.getAirship(airshipIdx).getRegistry();
    }


}