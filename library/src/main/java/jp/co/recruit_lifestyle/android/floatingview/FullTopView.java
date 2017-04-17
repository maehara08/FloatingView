package jp.co.recruit_lifestyle.android.floatingview;

import android.content.Context;
import android.view.KeyEvent;
import android.widget.FrameLayout;

public class FullTopView extends FrameLayout {

    private DispatchKeyEventListener mKeyEventListener;

    public FullTopView(Context context, DispatchKeyEventListener listener) {
        super(context);
        this.mKeyEventListener = listener;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        switch (event.getAction()) {
            case KeyEvent.ACTION_UP:
                if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
                    mKeyEventListener.onBackKeyDown();
                    return true;
                }
        }
        return false;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }

    interface DispatchKeyEventListener {
        void onBackKeyDown();
    }
}