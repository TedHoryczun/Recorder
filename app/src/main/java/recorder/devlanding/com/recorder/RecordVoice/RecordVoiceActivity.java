package recorder.devlanding.com.recorder.RecordVoice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

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
}
