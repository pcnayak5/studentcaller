package com.example.prashanthc.call_activity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    String[] contacts = {"Medical Emergency\n04422578888", "Security\n04422579999", "Tele Counselling\n04422575555", "Lan Complaints\n04422575987",
            "Electrical Complaints\n04422578187", "CCW Office\n04422578504"};

    String[] phone = {"04422578888", "04422579999", "04422575555", "04422575987", "04422578187", "04422578504"};
    Integer[] imgid = {
            R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3,
            R.drawable.pic4,
            R.drawable.pic5,
            R.drawable.pic6
    };
    ListView lv;
    ListView lv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*lv = (ListView) findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.rows, R.id.textView, contacts
        );
        lv.setAdapter(adapter);*/

        CustomListAdapter adapt = new CustomListAdapter(this, contacts, imgid);
        lv1 = (ListView) findViewById(R.id.listview);
        lv1.setAdapter(adapt);

        // Set the touch listener
        final SwipeDetector swipeDetector = new SwipeDetector();
        lv1.setOnTouchListener(swipeDetector);


        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {


                if (swipeDetector.swipeDetected()) {
                    if (swipeDetector.getAction() == SwipeDetector.Action.LR) {

                        Intent tocall;

                        switch (position) {
                            case 0: {
                                tocall = new Intent(Intent.ACTION_DIAL);
                                tocall.setData(Uri.parse("tel:" + phone[0]));
                                //tocall.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                tocall.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_NO_USER_ACTION);

                                //if (mContext.checkSelfPermission(Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED)
                               /* if (ActivityCompat.checkSelfPermission(getBaseContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                    // TODO: Consider calling
                                    //    ActivityCompat#requestPermissions
                                    // here to request the missing permissions, and then overriding
                                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                    //                                          int[] grantResults)
                                    // to handle the case where the user grants the permission. See the documentation
                                    // for ActivityCompat#requestPermissions for more details.
                                    return;
                                }*/
                                startActivity(tocall);
                                break;}
                            case 1: {
                                tocall = new Intent(Intent.ACTION_DIAL);
                                tocall.setData(Uri.parse("tel:" + phone[1]));
                               // tocall.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                tocall.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_NO_USER_ACTION);
                                startActivity(tocall);
                                break;}
                            case 2: {
                                tocall = new Intent(Intent.ACTION_DIAL);
                                tocall.setData(Uri.parse("tel:" + phone[2]));
                               // tocall.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                tocall.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_NO_USER_ACTION);
                                startActivity(tocall);
                                break;}
                            case 3: {
                            tocall = new Intent(Intent.ACTION_DIAL);
                            tocall.setData(Uri.parse("tel:" + phone[3]));
                               // tocall.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                tocall.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_NO_USER_ACTION);
                            startActivity(tocall);
                            break;}
                            case 4: {
                                tocall = new Intent(Intent.ACTION_DIAL);
                                tocall.setData(Uri.parse("tel:" + phone[4]));
                               // tocall.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                tocall.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_NO_USER_ACTION);
                                startActivity(tocall);
                                break;}
                            case 5: {
                                tocall = new Intent(Intent.ACTION_DIAL);
                                tocall.setData(Uri.parse("tel:" + phone[5]));
                                //tocall.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                tocall.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_NO_USER_ACTION);
                                startActivity(tocall);
                                break;}

                        }



                    }
                    if (swipeDetector.getAction() == SwipeDetector.Action.RL) {

                        Toast.makeText(getApplicationContext(),
                                "Swipe Left to right", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });


    }

}



