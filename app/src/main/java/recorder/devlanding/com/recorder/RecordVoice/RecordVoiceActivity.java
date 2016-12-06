package recorder.devlanding.com.recorder.RecordVoice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import recorder.devlanding.com.recorder.R;

public class RecordVoiceActivity extends AppCompatActivity implements RecordVoiceMVP.view {
    @BindView(R.id.onRecord)
    ImageView onRecordButton;

    @BindView(R.id.onStop)
    ImageView onStopButton;

    @BindView(R.id.timer)
    TextView timerText;
    private RecordVoicePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_voice);
        ButterKnife.bind(this);
        presenter = new RecordVoicePresenter(this);
    }

    @OnClick(R.id.onRecord)
    public void recordVoice(){
        presenter.setRecordbuttonInvisible();
        presenter.setStopButtonVisible();
        presenter.startTimer();
        RedRecorder recorder = new RedRecorder();
        Date date = new Date(System.currentTimeMillis());
        try {
            recorder.startRecording(date.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.onStop)
    public void stopRecordingVoice(){
        presenter.setStopButtonInvisible();
        presenter.setRecordButtonVisible();
        presenter.stopTimer();
    }

    @Override
    public void setRecordbuttonInvisible() {
        onRecordButton.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setRecordButtonVisible() {
        onRecordButton.setVisibility(View.VISIBLE);
    }

    @Override
    public void setStopButtonInvisible() {
        onStopButton.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setStopButtonVisible() {
        onStopButton.setVisibility(View.VISIBLE);
    }

    @Override
    public void incrementTimerBy1Second(int second) {
        String formattedSeconds;
        if(second >=60){
            formattedSeconds = String.format("%02d", second % 60);
            String minutes = String.format("%02d", second / 60);
            timerText.setText("00:" + minutes + ":" + formattedSeconds);

        }else{
            formattedSeconds = String.format("%02d", second);
            timerText.setText("00:00:" + formattedSeconds);

        }
    }

    @Override
    public void stopTimer() {
        timerText.setText("00:00:00");
    }
}
