package xwpeng.com.titerator.recevier;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class FirstReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int limit = intent.getIntExtra("limit", -1001);
        if (limit == 1000) {
            String msg = intent.getStringExtra("msg");
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
            abortBroadcast();
        } else {
            Bundle b = new Bundle();
            b.putString("msg", "Message from FirstReceiver");
            setResultExtras(b);
        }
    }
}
