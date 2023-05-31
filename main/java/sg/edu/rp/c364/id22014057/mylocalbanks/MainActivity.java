package sg.edu.rp.c364.id22014057.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button dbs;
    Button ocbc;
    Button uob;
    String wordClicked = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbs = findViewById(R.id.buttonDBS);
        ocbc = findViewById(R.id.buttonOCBC);
        uob = findViewById(R.id.buttonUOB);

        registerForContextMenu(dbs);
        registerForContextMenu(ocbc);
        registerForContextMenu(uob);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            dbs.setText("DBS");
            ocbc.setText("OCBC");
            uob.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            dbs.setText("星展银行");
            ocbc.setText("华侨银行");
            uob.setText("大华银行");
            return true;
        } else {
            dbs.setText("Error translation");
            ocbc.setText("Error translation");
            uob.setText("Error translation");
        }
        return false;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v == dbs) {
            wordClicked = "DBS";
        } else if (v == ocbc) {
            wordClicked = "OCBC";
        } else if (v == uob) {
            wordClicked = "UOB";
        }

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact No.");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("DBS")) {
            if (item.getItemId() == 0) {
                if (item.getItemId() == R.id.website) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                    startActivity(browserIntent);
                    return true;

                } else if (item.getItemId() == R.id.contact) {
                    Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18001111111"));
                    startActivity(callIntent);
                    return true;


                } else if (wordClicked.equalsIgnoreCase("ocbc")) {
                    if (item.getItemId() == R.id.website) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                        startActivity(browserIntent);
                        return true;

                    } else if (item.getItemId() == R.id.contact) {
                        Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18003633333"));
                        startActivity(callIntent);
                        return true;


                    } else if (wordClicked.equalsIgnoreCase("uob")) {
                        if (item.getItemId() == R.id.website) {
                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com"));
                            startActivity(browserIntent);
                            return true;

                        } else if (item.getItemId() == R.id.contact) {
                            Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18002222121"));
                            startActivity(callIntent);
                            return true;
                        }

                    }

                }

                return super.onContextItemSelected(item);
            }
        }
        return false;
    }
}
            