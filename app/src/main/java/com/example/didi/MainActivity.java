package com.example.didi;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button urlbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //타이틀바, 안테나(배터리) 상태바 숨기기
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //액션바 숨기기
        ActionBar actionbar = getSupportActionBar();
        actionbar.hide();
        //-------------------------------->

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 여기서 부터 실질적인 메인 임.
        Log.d("ACTIVITY_LC", "MainActivity의 onCreate 호출됨." );
        editText = (EditText) findViewById(R.id.urlText);
        urlbtn = (Button) findViewById(R.id.urlBtn);
        urlbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // subActivity 로 URL을 넘김
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                String url = editText.getText().toString();
                intent.putExtra("URL", url);
                Toast.makeText(getApplicationContext(), url, Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

    }
}