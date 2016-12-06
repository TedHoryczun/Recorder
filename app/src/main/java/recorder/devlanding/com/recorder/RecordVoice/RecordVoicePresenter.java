package recorder.devlanding.com.recorder.RecordVoice;

import android.os.Handler;

/**
 * Created by ted on 12/5/16.
 */

public class RecordVoicePresenter implements RecordVoiceMVP.presenter{
    private final RecordVoiceMVP.view view;
    private boolean mStopHandler;
    private int num;

    public RecordVoicePresenter(RecordVoiceMVP.view view){
        this.view = view;
    }

    @Override
    public void setRecordbuttonInvisible() {
        view.setRecordbuttonInvisible();

    }

    @Override
    public void setRecordButtonVisible() {
        view.setRecordButtonVisible();;
    }

    @Override
    public void setStopButtonInvisible() {
        view.setStopButtonInvisible();
    }

    @Override
    public void setStopButtonVisible() {
        view.setStopButtonVisible();
    }

    public void stopTimer() {
        view.stopTimer();
        mStopHandler = true;
    }

    @Override
    public void startTimer() {
        mStopHandler = false;
        final Handler handler = new Handler();
        num = 0;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(!mStopHandler){
                    view.incrementTimerBy1(num++);
                   handler.postDelayed(this, 1000);
                }
            }
        };
        handler.post(runnable);
    }
}
