package in.co.presentsoft.android.demo.DemoHybridApplication;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import in.co.presentsoft.android.demo.api.bridge.YesNoDialogBridge;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        WebView webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);

        webView.addJavascriptInterface(new YesNoDialogBridge(this,webView),"yes_no_dialog_bridge");

        webView.loadUrl("file:///android_asset/index.html");

    }
}
