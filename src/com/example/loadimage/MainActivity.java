package com.example.loadimage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;
import org.json.JSONTokener;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



import com.example.loadimage.InstagramApp.OAuthAuthenticationListener;
import com.example.loadimage.InstagramDialog.OAuthDialogListener;



public class MainActivity extends Activity implements OnClickListener {
    private InstagramApp instaObj;
    public static final String CLIENT_ID = "299b538b485246ab9d60029577a7d5cf";
    public static final String CLIENT_SECRET = "de6c2fd4396a4ccf913c01362b2b50a2";
    public static final String CALLBACK_URL = "http://localhost";
    private OAuthAuthenticationListener listener;
    TextView text;
    ImageView imageview;
    Button btauthor,check;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

                instaObj = new InstagramApp(this, CLIENT_ID,CLIENT_SECRET, CALLBACK_URL);
                instaObj.setListener(listener);
                //Toast.makeText(this, instaObj.getUserPicture(), Toast.LENGTH_LONG).show();

                /*OAuthAuthenticationListener listener = new OAuthAuthenticationListener() {

                @Override
                public void onSuccess() {

                    Log.e("Userid123", instaObj.getId());
                    Log.e("Name", instaObj.getName());
                    Log.e("UserName", instaObj.getUserName());
        			Class ourClass;
        			try {
        				ourClass = Class.forName("com.example.LoadImage.InstagramLoad");
        				Intent ourIntent = new Intent(MainActivity.this, ourClass);
        				//ourIntent.putExtra("incaritem1", incaritem);
        				startActivity(ourIntent);
        			} catch (ClassNotFoundException e) {
        				e.printStackTrace();
        			}
                }

                @Override
                public void onFail(String error) {
                    Toast.makeText(MainActivity.this, error, Toast.LENGTH_LONG).show();
                }

            };
            

            text= (TextView)findViewById(R.id.textView1);
            text.setText(instaObj.getUserPicture().toString());
            imageview=(ImageView)findViewById(R.id.imageview1);*/

            text= (TextView)findViewById(R.id.textView1);
            btauthor=(Button)findViewById(R.id.btAuthor);
            check=(Button)findViewById(R.id.btcheck);

            btauthor.setOnClickListener(this);
            instaObj.resetAccessToken();
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()){
		case R.id.btAuthor:
	        instaObj.authorize();  //add this in your button click or wherever you need to call the instagram api
	        break;
		case R.id.btcheck:
			text.setText(instaObj.getAccessToken());
			break;
		}
/*        Toast.makeText(MainActivity.this, "Test", Toast.LENGTH_LONG).show();
        if(instaObj.hasAccessToken()){
        	Class ourClass;
    		try {
    			ourClass = Class.forName("com.example.loadimage.InstagramLoad");
    			Intent ourIntent = new Intent(MainActivity.this, ourClass);
    			//ourIntent.putExtra("incaritem1", incaritem);
    			startActivity(ourIntent);
    		} catch (ClassNotFoundException e) {
    			e.printStackTrace();
    		}	
        }
        Toast.makeText(MainActivity.this, "11111Test", Toast.LENGTH_LONG).show();
*/		
	}
    


}


