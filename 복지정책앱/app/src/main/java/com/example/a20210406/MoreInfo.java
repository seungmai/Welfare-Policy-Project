package com.example.a20210406;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

public class MoreInfo extends AppCompatActivity {

    public String id;
    public String key = "JUmCqi82GL8KMJTfC%2B474upkTunXBlZSInKPPLCcXRPk5LBt6tSjc%2B1BmHz5kOFlo2Yq2blkuAuVhW77u0d8rQ%3D%3D";
    String data3, data2, data_service_name, data_service_explain, data_service_support, data_service_howToApply;
    String dial1, dial2, Apply1,Apply1_2 ,Apply2, Apply2_2,  Apply3, Apply3_2, Apply4, Apply4_2, Apply5;
    String sumdial2, sumdial3;
    TextView text, text_service_target, moreinfo_textview_num, moreinfo_textview_service_name, moreinof_textview_service_explanation, moreinof_textview_service_support, moreinof_textview_service_howToApply, moreinfo_textview2_num;
    TextView moreinof_textview_service_howToApply1_1, moreinof_textview_service_howToApply1_2, moreinof_textview_service_howToApply2_1, moreinof_textview_service_howToApply2_2, moreinof_textview_service_howToApply3_1, moreinof_textview_service_howToApply3_2, moreinof_textview_service_howToApply4_1, moreinof_textview_service_howToApply4_2;
    ImageView call1, call2;
    XmlPullParser xpp;
    LinearLayout apply1_layout2, apply1_layout3, apply1_layout4;
    public boolean Boolean_layout2, Boolean_layout3, Boolean_layout4;
    public int count;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_home:
                MovetoMain();
                return true;
            case R.id.menu_info:
                MovetoMemberInfo();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moreinfo_service);
        text = (TextView) findViewById(R.id.moreinfo_textview);
        text_service_target = (TextView) findViewById(R.id.moreinof_service_target_);

        moreinfo_textview_service_name = (TextView) findViewById(R.id.moreinof_service_name);
        moreinof_textview_service_explanation = (TextView) findViewById(R.id.moreinof_service_explanation);
        moreinof_textview_service_support = (TextView) findViewById(R.id.moreinof_service_support);
        //moreinof_textview_service_howToApply = (TextView) findViewById(R.id.moreinof_service_howToApply);
        moreinof_textview_service_howToApply1_1 = (TextView) findViewById(R.id.moreinof_service_howToApply1_1);
        moreinof_textview_service_howToApply1_2 = (TextView) findViewById(R.id.moreinof_service_howToApply1_2);
        moreinof_textview_service_howToApply2_1 = (TextView) findViewById(R.id.moreinof_service_howToApply2_1);
        moreinof_textview_service_howToApply2_2 = (TextView) findViewById(R.id.moreinof_service_howToApply2_2);
        moreinof_textview_service_howToApply3_1 = (TextView) findViewById(R.id.moreinof_service_howToApply3_1);
        moreinof_textview_service_howToApply3_2 = (TextView) findViewById(R.id.moreinof_service_howToApply3_2);
        moreinof_textview_service_howToApply4_1 = (TextView) findViewById(R.id.moreinof_service_howToApply4_1);
        moreinof_textview_service_howToApply4_2 = (TextView) findViewById(R.id.moreinof_service_howToApply4_2);
        moreinfo_textview2_num = (TextView) findViewById(R.id.moreinfo_textview2);
        call1 = (ImageView)findViewById(R.id.imageView6);
        call2 = (ImageView)findViewById(R.id.imageView5);
        Toolbar tb = (Toolbar) findViewById(R.id.toolbar3);
        apply1_layout2 = (LinearLayout)findViewById(R.id.apply2_layout);
        apply1_layout3 = (LinearLayout)findViewById(R.id.apply3_layout);
        apply1_layout4 = (LinearLayout)findViewById(R.id.apply4_layout);

        setSupportActionBar(tb);

        Intent intent = getIntent();
        id = intent.getStringExtra("moreinfo");

        Toast.makeText(getApplicationContext(), "????????? id : " + id, Toast.LENGTH_SHORT).show();




        //?????? ???????????? ???????????? ????????? ?????? ??????
        call1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String[] array_dial2 = dial1.split("-");
//                for(int i=0; i<array_dial2.length; i++){
//                    sumdial3 = sumdial3 + array_dial2[i];
//                }
                Intent intent_dial1 = new Intent();
                intent_dial1.setAction(Intent.ACTION_DIAL);
                intent_dial1.setData(Uri.parse("tel:"+dial1));
                Log.e("",""+dial1);
                startActivity(intent_dial1);
                sumdial3 = null;
            }
        });
        //?????? ???????????? ???????????? ????????? ?????? ??????
        call2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String[] array_dial2 = dial2.split("-");
//                for(int i=0; i<array_dial2.length; i++){
//                     sumdial2 = sumdial2 + array_dial2[i];
//                }
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" +dial2));
                startActivity(intent);
                sumdial2 = null;

            }
        });

        new Thread(new Runnable() {


            @Override

            public void run() {

                // TODO Auto-generated method stub

                data3 = getXmlData_num(); //?????? ???????????? ???????????? XML data??? ???????????? String ????????? ????????????
                data2 = getXmlData2();
                data_service_name = getXmlData_name();
                data_service_explain = getXmlData_expalain();
                data_service_support = getXmlData_support();
                data_service_howToApply = getXmlData_howToApply();

                //??????????????? ?????? ???????????? "/"??? ?????????.
                String[] array_num = data3.split("/");

                Split_Apply();




                Log.e("????????????", "??????" + data3);


                //UI Thread(Main Thread)??? ????????? ?????? Thread??? ????????? ????????? ??? ???????????????

                //runOnUiThread()??? ???????????? UI Thread??? TextView ?????? ??????????????? ???

                runOnUiThread(new Runnable() {


                    @Override

                    public void run() {

                        // TODO Auto-generated method stub




                        //?????? ??????????????? ?????? ????????? ???????????? ??????????????? ???????????? ?????????, ??????????????? ?????????.
                        for(int i = 0; i<array_num.length; i++){
                            if(i ==0){
                                dial1 = array_num[i];
                                text.setText(array_num[0]);
                                moreinfo_textview2_num.setEnabled(false);
                                call1.setVisibility(View.VISIBLE);


                            }
                            if(i ==1){
                                moreinfo_textview2_num.setEnabled(true);
                                dial2 = array_num[i];

                                moreinfo_textview2_num.setText(array_num[1]);
                                call2.setVisibility(View.VISIBLE);





                            }


                        }





                        //TextView??? ?????????  data ??????
                        text_service_target.setText(data2);  //TextView??? ?????????  data ??????
                        moreinfo_textview_service_name.setText(data_service_name);
                        moreinof_textview_service_explanation.setText(data_service_explain);
                        moreinof_textview_service_support.setText(data_service_support);
                        //moreinof_textview_service_howToApply.setText(data_service_howToApply);
                        moreinof_textview_service_howToApply1_1.setText(Apply1);
                        moreinof_textview_service_howToApply1_2.setText(Apply1_2);
                        moreinof_textview_service_howToApply2_1.setText(Apply2);
                        moreinof_textview_service_howToApply2_2.setText(Apply2_2);
                        moreinof_textview_service_howToApply3_1.setText(Apply3);
                        moreinof_textview_service_howToApply3_2.setText(Apply3_2);

                        moreinof_textview_service_howToApply4_1.setText(Apply4);
                        moreinof_textview_service_howToApply4_2.setText(Apply4_2);

                        //?????? ????????? ????????? ??????????????? ??????????????? ????????? ??????.
                        if(Boolean_layout4 ==true){
                            apply1_layout4.setVisibility(View.VISIBLE);
                        }
                        if(Boolean_layout3 ==true){
                            apply1_layout3.setVisibility(View.VISIBLE);
                        }
                        if(Boolean_layout2 ==true){
                            apply1_layout2.setVisibility(View.VISIBLE);
                        }


                    }

                });


            }

        }).start();


    }

    private void MovetoMemberInfo() {
        Intent intent = new Intent(this, MemberinfoActivity.class);
        startActivity(intent);
    }

    private void MovetoMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //??????????????? ?????? ??????
    String getXmlData_num() {
        StringBuffer buffer = new StringBuffer();

        String query = "%EC%A0%84%EB%A0%A5%EB%A1%9C";

        String queryUrl = "http://www.bokjiro.go.kr/openapi/rest/gvmtWelSvc?crtiKey=" + key
                + "&callTp=D"
                + "&servId=" + id;
        try {
            URL url = new URL(queryUrl);//???????????? ??? ?????? url??? URL ????????? ??????.
            InputStream is = url.openStream(); //url????????? ??????????????? ??????

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();//xml????????? ??????
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new InputStreamReader(is, "UTF-8")); //inputstream ???????????? xml ????????????

            String tag;

            xpp.next();
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        buffer.append("?????? ??????...\n\n");
                        break;

                    case XmlPullParser.START_TAG:
                        tag = xpp.getName();//?????? ?????? ????????????

                        Log.e("????????? ??????", "????????? ????????? : moreinfo  data3");
                        if (tag.equals("inqplCtadrList")) {
                            Log.e("", "tag " + tag);

                            count = 1;
                        }
                        if (count == 1) {
                            if (tag.equals("servSeDetailLink")) {

                                xpp.next();
                                buffer.append(xpp.getText());
                                buffer.append("/");
                                Log.e("data3", "?????????" + xpp.getText());
                                count = 2;
                            }
                        } else
                            Log.e("", "---------------------------------");

                        // ????????? ????????????

                        break;


                    case XmlPullParser.TEXT:
                        break;

                    case XmlPullParser.END_TAG:
                        tag = xpp.getName(); //?????? ?????? ????????????

                        if (tag.equals("inqplCtadrList")) ;// ????????? ??????????????????..?????????
                        break;

                }

                eventType = xpp.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return buffer.toString();
        //StringBuffer ????????? ?????? ??????


    }

    //????????? ????????? ?????? ??????
    String getXmlData_name() {
        StringBuffer buffer = new StringBuffer();

        String query = "%EC%A0%84%EB%A0%A5%EB%A1%9C";

        String queryUrl = "http://www.bokjiro.go.kr/openapi/rest/gvmtWelSvc?crtiKey=" + key
                + "&callTp=D"
                + "&servId=" + id;
        try {
            URL url = new URL(queryUrl);//???????????? ??? ?????? url??? URL ????????? ??????.
            InputStream is = url.openStream(); //url????????? ??????????????? ??????

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();//xml????????? ??????
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new InputStreamReader(is, "UTF-8")); //inputstream ???????????? xml ????????????

            String tag;

            xpp.next();
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:

                        break;

                    case XmlPullParser.START_TAG:
                        tag = xpp.getName();//?????? ?????? ????????????

                        Log.e("????????? ??????", "????????? ????????? : moreinfo  data3");
                        if (tag.equals("wantedDtl")) {
                            Log.e("", "tag " + tag);


                        }

                        if (tag.equals("servNm")) {

                            xpp.next();
                            buffer.append(xpp.getText());


                        } else
                            Log.e("", "---------------------------------");

                        // ????????? ????????????

                        break;


                    case XmlPullParser.TEXT:
                        break;

                    case XmlPullParser.END_TAG:
                        tag = xpp.getName(); //?????? ?????? ????????????

                        if (tag.equals("wantedDtl")) buffer.append("\n");// ????????? ??????????????????..?????????
                        break;

                }

                eventType = xpp.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return buffer.toString();
        //StringBuffer ????????? ?????? ??????


    }

    //????????? ????????? ?????? ??????
    String getXmlData_expalain() {
        StringBuffer buffer = new StringBuffer();

        String query = "%EC%A0%84%EB%A0%A5%EB%A1%9C";

        String queryUrl = "http://www.bokjiro.go.kr/openapi/rest/gvmtWelSvc?crtiKey=" + key
                + "&callTp=D"
                + "&servId=" + id;
        try {
            URL url = new URL(queryUrl);//???????????? ??? ?????? url??? URL ????????? ??????.
            InputStream is = url.openStream(); //url????????? ??????????????? ??????

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();//xml????????? ??????
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new InputStreamReader(is, "UTF-8")); //inputstream ???????????? xml ????????????

            String tag;

            xpp.next();
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:

                        break;

                    case XmlPullParser.START_TAG:
                        tag = xpp.getName();//?????? ?????? ????????????

                        Log.e("????????? ??????", "????????? ????????? : moreinfo  data3");
                        if (tag.equals("wantedDtl")) {
                            Log.e("", "tag " + tag);


                        }

                        if (tag.equals("servDgst")) {

                            xpp.next();
                            buffer.append(xpp.getText());


                        } else
                            Log.e("", "---------------------------------");

                        // ????????? ????????????

                        break;


                    case XmlPullParser.TEXT:
                        break;

                    case XmlPullParser.END_TAG:
                        tag = xpp.getName(); //?????? ?????? ????????????

                        if (tag.equals("wantedDtl")) buffer.append("\n");// ????????? ??????????????????..?????????
                        break;

                }

                eventType = xpp.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return buffer.toString();
        //StringBuffer ????????? ?????? ??????


    }

    //??????????????? ?????? ??????
    String getXmlData_support() {
        StringBuffer buffer = new StringBuffer();

        String query = "%EC%A0%84%EB%A0%A5%EB%A1%9C";

        String queryUrl = "http://www.bokjiro.go.kr/openapi/rest/gvmtWelSvc?crtiKey=" + key
                + "&callTp=D"
                + "&servId=" + id;
        try {
            URL url = new URL(queryUrl);//???????????? ??? ?????? url??? URL ????????? ??????.
            InputStream is = url.openStream(); //url????????? ??????????????? ??????

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();//xml????????? ??????
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new InputStreamReader(is, "UTF-8")); //inputstream ???????????? xml ????????????

            String tag;

            xpp.next();
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:

                        break;

                    case XmlPullParser.START_TAG:
                        tag = xpp.getName();//?????? ?????? ????????????

                        Log.e("????????? ??????", "????????? ????????? : moreinfo  data3");
                        if (tag.equals("wantedDtl")) {
                            Log.e("", "tag " + tag);


                        }

                        if (tag.equals("alwServCn")) {

                            xpp.next();
                            buffer.append(xpp.getText());


                        } else
                            Log.e("", "---------------------------------");

                        // ????????? ????????????

                        break;


                    case XmlPullParser.TEXT:
                        break;

                    case XmlPullParser.END_TAG:
                        tag = xpp.getName(); //?????? ?????? ????????????

                        if (tag.equals("wantedDtl")) buffer.append("\n");// ????????? ??????????????????..?????????
                        break;

                }

                eventType = xpp.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return buffer.toString();
        //StringBuffer ????????? ?????? ??????


    }

    //??????????????? ?????? ??????
    String getXmlData_howToApply() {
        StringBuffer buffer = new StringBuffer();

        String query = "%EC%A0%84%EB%A0%A5%EB%A1%9C";

        String queryUrl = "http://www.bokjiro.go.kr/openapi/rest/gvmtWelSvc?crtiKey=" + key
                + "&callTp=D"
                + "&servId=" + id;
        try {
            URL url = new URL(queryUrl);//???????????? ??? ?????? url??? URL ????????? ??????.
            InputStream is = url.openStream(); //url????????? ??????????????? ??????

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();//xml????????? ??????
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new InputStreamReader(is, "UTF-8")); //inputstream ???????????? xml ????????????

            String tag;

            xpp.next();
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        buffer.append("?????? ??????...\n\n");
                        break;

                    case XmlPullParser.START_TAG:
                        tag = xpp.getName();//?????? ?????? ????????????

                        Log.e("????????? ??????", "????????? ????????? : moreinfo  data3");
                        if (tag.equals("applmetList")) {
                            Log.e("", "tag " + tag);

                            count = 2;
                        }
                        if (count == 2) {
                            if (tag.equals("servSeDetailNm")) {

                                xpp.next();
                                buffer.append(xpp.getText());
                                buffer.append("\n");
                                Log.e("data3", "?????????" + xpp.getText());
                                count = 3;
                            }
                        } else
                            Log.e("", "---------------------------------");

                        // ????????? ????????????

                        break;


                    case XmlPullParser.TEXT:
                        break;

                    case XmlPullParser.END_TAG:
                        tag = xpp.getName(); //?????? ?????? ????????????

                        if (tag.equals("inqplCtadrList")) buffer.append("\n");// ????????? ??????????????????..?????????
                        break;

                }

                eventType = xpp.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return buffer.toString();
        //StringBuffer ????????? ?????? ??????


    }

    //???????????? ???????????? ?????? ??????
    String getXmlData2() {
        StringBuffer buffer = new StringBuffer();
        String query = "%EC%A0%84%EB%A0%A5%EB%A1%9C";

        String queryUrl = "http://www.bokjiro.go.kr/openapi/rest/gvmtWelSvc?crtiKey=" + key
                + "&callTp=D"
                + "&servId=" + id;
        try {
            URL url = new URL(queryUrl);//???????????? ??? ?????? url??? URL ????????? ??????.
            InputStream is = url.openStream(); //url????????? ??????????????? ??????

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();//xml????????? ??????
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new InputStreamReader(is, "UTF-8")); //inputstream ???????????? xml ????????????

            String tag;

            xpp.next();
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        buffer.append("?????? ??????...\n\n");
                        break;

                    case XmlPullParser.START_TAG:
                        tag = xpp.getName();//?????? ?????? ????????????

                        Log.e("????????? ??????", "????????? ????????? : moreinfo  data2");
                        if (tag.equals("wantedDtl")) ;// ????????? ????????????
                        else if (tag.equals("tgtrDtlCn")) {


                            xpp.next();
                            buffer.append(xpp.getText()+"?????? ???????????????");//servId ????????? TEXT ???????????? ?????????????????? ??????

                            buffer.append("\n"); //????????? ?????? ??????


                        }
//
                        break;

                    case XmlPullParser.TEXT:
                        break;

                    case XmlPullParser.END_TAG:
                        tag = xpp.getName(); //?????? ?????? ????????????

                        if (tag.equals("wantedDtl")) buffer.append("\n");// ????????? ??????????????????..?????????
                        break;
                }

                eventType = xpp.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return buffer.toString();//StringBuffer ????????? ?????? ??????


    }


    //???????????? ???????????? ????????? ?????? ?????? ??????????????? ???????????? ??????
    public void Split_Apply(){
        int idx1 = data_service_howToApply.indexOf("1");
        int idx2 = data_service_howToApply.indexOf("2");
        int idx3 = data_service_howToApply.indexOf("3");
        int idx4 = data_service_howToApply.indexOf("4");
        int idx5 = data_service_howToApply.indexOf("5");


        //1??? ?????????
        if(data_service_howToApply.indexOf("1")!=-1) {
            //?????? 2??? ????????? ????????? ????????? ????????? ????????? ??? ?????? ????????? ??????
            if(data_service_howToApply.indexOf("2")!=-1) {
                Apply1 = data_service_howToApply.substring(1, idx2-1);
                Log.e("apply1", "apply1 " + Apply1);

                //????????? "(" ??? ????????? ???????????? ????????? ??????
                if(Apply1.indexOf("(")!=-1){
                    int idx = Apply1.indexOf("(");
                    Apply1_2 = Apply1.substring(idx+1);
                    Apply1 = Apply1.substring(1, idx);

                    Log.e("apply1", "apply1 " + Apply1 +"   " +Apply1_2);
                }
                //????????? ":" ??? ????????? ???????????? ????????? ??????
                if(Apply1.indexOf(":")!=-1){
                    int idx = Apply1.indexOf(":");
                    Apply1_2 = Apply1.substring(idx+1);
                    Apply1 = Apply1.substring(1, idx);

                    Log.e("apply1", "apply1 " + Apply1 +"   " +Apply1_2);
                }

            }
            //?????? 2??? ????????? ??????
            else {
                Apply1 = data_service_howToApply.substring(1);
                if(Apply1.indexOf("(")!=-1){
                    int idx = Apply1.indexOf("(");
                    Apply1_2 = Apply1.substring(idx+1);
                    Apply1 = Apply1.substring(1, idx);

                    Log.e("apply1", "apply1 " + Apply1 +"   " +Apply1_2);
                }
                if(Apply1.indexOf(":")!=-1){
                    int idx = Apply1.indexOf(":");
                    Apply1_2 = Apply1.substring(idx+1);
                    Apply1 = Apply1.substring(1, idx);

                    Log.e("apply1", "apply1 " + Apply1 +"   " +Apply1_2);
                }
            }
        }else {

        }
        if(data_service_howToApply.indexOf("2")!=-1) {
            if(data_service_howToApply.indexOf("3")!=-1) {
                Apply2 = data_service_howToApply.substring(idx2+1, idx3-1);
                if(Apply2.indexOf("(")!=-1){
                    int idx = Apply2.indexOf("(");
                    Apply2_2 = Apply2.substring(idx+1);
                    Apply2 = Apply2.substring(1, idx);
                    Boolean_layout2 = true;


                    Log.e("apply2", "apply2 " + Apply2 +"   " +Apply2_2);
                }
                if(Apply2.indexOf(":")!=-1){
                    int idx = Apply2.indexOf(":");
                    Apply2_2 = Apply2.substring(idx+1);
                    Apply2 = Apply2.substring(1, idx);
                    Boolean_layout2 = true;
                    Log.e("apply2", "apply2 " + Apply2 +"   " +Apply2_2);
                }
            }
            else {
                Apply2 = data_service_howToApply.substring(idx2+1);
                if(Apply2.indexOf("(")!=-1){
                    int idx = Apply2.indexOf("(");
                    Apply2_2 = Apply2.substring(idx+1);
                    Apply2 = Apply2.substring(1, idx);
                    Boolean_layout2 = true;
                    Log.e("apply2", "apply2 " + Apply2 +"   " +Apply2_2);
                }
                if(Apply2.indexOf(":")!=-1){
                    int idx = Apply2.indexOf(":");
                    Apply2_2 = Apply2.substring(idx+1);
                    Apply2 = Apply2.substring(1, idx);
                    Boolean_layout2 = true;
                    Log.e("apply2", "apply2 " + Apply2 +"   " +Apply2_2);
                }
            }
        }else {

        }
        if(data_service_howToApply.indexOf("3")!=-1) {

            if(data_service_howToApply.indexOf("4")!=-1) {
                Apply3 = data_service_howToApply.substring(idx3+1, idx4-1);
                if(Apply3.indexOf("(")!=-1){
                    int idx = Apply3.indexOf("(");
                    Apply3_2 = Apply3.substring(idx+1);
                    Apply3 = Apply3.substring(1, idx);
                    Boolean_layout3 = true;
                    Log.e("apply3", "apply3 " + Apply3 +"   " +Apply3_2);
                }
                if(Apply3.indexOf(":")!=-1){
                    int idx = Apply3.indexOf(":");
                    Apply3_2 = Apply3.substring(idx+1);
                    Apply3 = Apply3.substring(1, idx);
                    Boolean_layout3 = true;
                    Log.e("apply3", "apply3 " + Apply3 +"   " +Apply3_2);
                }
            }
            else {
                Apply3 = data_service_howToApply.substring(idx3+1);
                if(Apply3.indexOf("(")!=-1){
                    int idx = Apply3.indexOf("(");
                    Apply3_2 = Apply3.substring(idx+1);
                    Apply3 = Apply3.substring(1, idx);
                    Boolean_layout3 = true;
                    Log.e("apply3", "apply3 " + Apply3 +"   " +Apply3_2);
                }
                if(Apply3.indexOf(":")!=-1){
                    int idx = Apply3.indexOf(":");
                    Apply3_2 = Apply3.substring(idx+1);
                    Apply3 = Apply3.substring(1, idx);
                    Boolean_layout3 = true;
                    Log.e("apply3", "apply3 " + Apply3 +"   " +Apply3_2);
                }
            }
        }else {

        }
        if(data_service_howToApply.indexOf("4")!=-1) {
            if(data_service_howToApply.indexOf("5")!=-1) {
                Apply4 = data_service_howToApply.substring(idx4+1, idx5-1);
                if(Apply4.indexOf("(")!=-1){
                    int idx = Apply4.indexOf("(");
                    Apply4_2 = Apply4.substring(idx+1);
                    Apply4 = Apply4.substring(1, idx);
                    Boolean_layout4 = true;
                    Log.e("apply4", "apply4 " + Apply4 +"   " +Apply4_2);
                }
                if(Apply4.indexOf(":")!=-1){
                    int idx = Apply4.indexOf(":");
                    Apply4_2 = Apply4.substring(idx+1);
                    Apply4 = Apply4.substring(1, idx);
                    Boolean_layout4 = true;
                    Log.e("apply4", "apply4 " + Apply4 +"   " +Apply4_2);
                }
            }
            else {
                Apply4 = data_service_howToApply.substring(idx4+1);
                if(Apply4.indexOf("(")!=-1){
                    int idx = Apply4.indexOf("(");
                    Apply4_2 = Apply4.substring(idx+1);
                    Apply4 = Apply4.substring(1, idx);
                    Boolean_layout4 = true;
                    Log.e("apply4", "apply4 " + Apply4 +"   " +Apply4_2);
                }else {}

                if(Apply4.indexOf(":")!=-1){
                    int idx = Apply4.indexOf(":");
                    Apply4_2 = Apply4.substring(idx+1);
                    Apply4 = Apply4.substring(1, idx);
                    Boolean_layout4 = true;
                    Log.e("apply4", "apply4 " + Apply4 +"   " +Apply4_2);
                } else {}
            }
        }else {

        }
        if(data_service_howToApply.indexOf("4")!=-1) {
            Apply5 = data_service_howToApply.substring(idx5+1);
            Log.e("????????????","???????????? 5");
        }
        else {
            Apply5 = data_service_howToApply.substring(idx5+1);
        }
       // Log.e("????????????", "????????????"+Apply1+"\n"+Apply2+"\n"+Apply3+"\n"+Apply4+"\n"+Apply5+"\n");
        Log.e("????????????", "????????????"+Apply1_2+" "+Apply2_2+" "+Apply3_2+" "+Apply4_2+" "+Apply5+"\n");


    }


}

