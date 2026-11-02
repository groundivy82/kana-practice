package app.kanapractice;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.Locale;

/**
 * 가나 연습: assets/index.html 을 WebView 로 띄우고,
 * 일본어 소리는 폰의 TextToSpeech(일본어)로 낸다. 네트워크는 쓰지 않는다.
 */
public class MainActivity extends Activity implements TextToSpeech.OnInitListener {

    private WebView web;
    private TextToSpeech tts;
    private volatile boolean ttsReady = false;
    private volatile boolean japaneseOk = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tts = new TextToSpeech(this, this);

        web = new WebView(this);
        setContentView(web);

        WebSettings s = web.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);
        s.setAllowFileAccess(true);

        web.addJavascriptInterface(new Bridge(), "AndroidTTS");
        web.setWebViewClient(new WebViewClient());
        web.loadUrl("file:///android_asset/index.html");
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int r = tts.setLanguage(Locale.JAPAN);
            japaneseOk = r >= TextToSpeech.LANG_AVAILABLE;
            tts.setSpeechRate(0.8f);
            ttsReady = true;
        }
    }

    @Override
    protected void onDestroy() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        if (web != null) {
            web.destroy();
        }
        super.onDestroy();
    }

    /** JS 에서 window.AndroidTTS 로 부르는 다리 */
    private class Bridge {
        @JavascriptInterface
        public void speak(String text) {
            if (!ttsReady || !japaneseOk) return;
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "kana");
        }

        @JavascriptInterface
        public boolean hasJapanese() {
            return ttsReady && japaneseOk;
        }
    }
}
