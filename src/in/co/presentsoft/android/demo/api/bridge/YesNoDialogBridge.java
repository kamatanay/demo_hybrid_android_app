package in.co.presentsoft.android.demo.api.bridge;

import android.app.Activity;
import android.webkit.WebView;
import in.co.presentsoft.android.demo.dialogs.OnDialogOptionSelected;
import in.co.presentsoft.android.demo.dialogs.YesNoDialog;

/**
 * Created with IntelliJ IDEA.
 * User: anay
 * Date: 16/10/12
 * Time: 12:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class YesNoDialogBridge {

    private Activity mainActivity;
    private WebView webView;

    public YesNoDialogBridge(Activity mainActivity, WebView webView) {
        this.mainActivity = mainActivity;
        this.webView = webView;
    }

    public void showDialog(String message, final String elementId){

        final YesNoDialog yesNoDialog = new YesNoDialog(message);
        yesNoDialog.setOnYesSelectedListener(new OnDialogOptionSelected() {
            @Override
            public void executeTask() {
                webView.loadUrl("javascript:execute_event('"+elementId+"','on_yes');");
            }
        });

        yesNoDialog.setOnNoSelectedListener(new OnDialogOptionSelected() {
            @Override
            public void executeTask() {
                webView.loadUrl("javascript:execute_event('" + elementId + "','on_no');");
            }
        });

        this.mainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                yesNoDialog.show(mainActivity.getFragmentManager(),"yes_no_dialog");
            }
        });

    }


}
