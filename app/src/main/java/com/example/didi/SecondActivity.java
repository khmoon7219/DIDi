package com.example.didi;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_second);

        //-- 여기서 부터 SecondActivity 메인 시작 ----------------->
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // main activiy 에서 넘겨 받은 URL을 webview 에 적용
        Intent intent = getIntent();
        Log.d("ACTIVITY_LC", intent.getStringExtra("URL"));
        String url = intent.getStringExtra("URL");
        Toast.makeText(getApplicationContext(), url, Toast.LENGTH_SHORT).show();

        //웹뷰(webview2) 기본설정
        WebView webview2 = (WebView) findViewById(R.id.webView2);
        webview2.setWebViewClient(new WebViewClient());  // 클릭 시 새창 안뜨게 함.
        //웹뷰(webview2) 세부 세팅
        WebSettings wbset = webview2.getSettings(); // 세부설정을 위한 객체 등록
        wbset.setJavaScriptEnabled(true);           // 웹에서 자바스크립트 동작 여부
        wbset.setSupportMultipleWindows(false);     // 새창띄우기 허용 여부
        wbset.setJavaScriptCanOpenWindowsAutomatically(false); // 자바스크립트 새창 띄우기(멀티뷰) 허용 여부
        wbset.setLoadWithOverviewMode(true);        // 메타태그 허용 여부
        wbset.setUseWideViewPort(true);             // 화면 사이즈 맞추기 허용 여부 //===> 확인 후 조치 필요
        wbset.setSupportZoom(false);                // 화면 줌 허용 여부
        wbset.setBuiltInZoomControls(false);        // 화면 확대 축소 허용 여부
        //wbset.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);  // 이전버전에는 있었으나 v8.0(ore) 버전에서는 사라진 듯..  //==> 에러 시 삭제 예정
        wbset.setCacheMode(WebSettings.LOAD_NO_CACHE);  // 브라우저 캐시 허용 여부
        wbset.setDomStorageEnabled(true);           // 로컬저장소 허용 여부
        webview2.loadUrl("https://" + url);
    }
}