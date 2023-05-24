package sg.edu.rp.c346.id21033293.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView btnDbs;
    TextView btnOcbc;
    TextView btnUob;
    String wordClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDbs = findViewById(R.id.DBS);
        btnOcbc = findViewById(R.id.OCBC);
        btnUob = findViewById(R.id.UOB);

        registerForContextMenu(btnDbs);
        registerForContextMenu(btnOcbc);
        registerForContextMenu(btnUob);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the Bank");

        if (v == btnDbs) {
            wordClicked = "dbs";
        } else if (v == btnOcbc) {
            wordClicked = "ocbc";
        } else if (v == btnUob) {
            wordClicked = "uob";
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("dbs")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dbs.com.sg/"));
                startActivity(intent);

            } else { //check if the selected menu item ID is 1
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 18001111111"));
                startActivity(intentCall);
            }
        } else if (wordClicked.equalsIgnoreCase("ocbc")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ocbc.com.sg/"));
                startActivity(intent);

            } else { //check if the selected menu item ID is 1
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 18003633333"));
                startActivity(intentCall);
            }
        } else if(wordClicked.equalsIgnoreCase("uob")) {
                if(item.getItemId()==0) { //check whether the selected menu item ID is 0
                    //code for action
                    Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("http://www.uob.com.sg/"));
                    startActivity(intent);

                } else { //check if the selected menu item ID is 1
                    //code for action
                    Intent intentCall = new Intent(Intent. ACTION_DIAL, Uri.parse("tel: 18002222121"));
                    startActivity(intentCall);
            }
            //pass menu item to the superclass implementation
        }
        return super.onContextItemSelected(item);

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

        if (id == R.id.englishSelection) {
            btnDbs.setText("DBS Bank");
            btnOcbc.setText("OCBC Bank");
            btnUob.setText("UOB Bank");
            return true;
        } else if (id == R.id.chineseSelection) {
            btnDbs.setText("星展银行");
            btnOcbc.setText("华侨银行");
            btnUob.setText("大华银行");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
