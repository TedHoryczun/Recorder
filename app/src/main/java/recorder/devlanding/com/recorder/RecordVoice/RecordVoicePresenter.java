package recorder.devlanding.com.recorder.RecordVoice;

/**
 * Created by ted on 12/5/16.
 */

public class RecordVoicePresenter implements RecordVoiceMVP.presenter{
    private final RecordVoiceMVP.view view;

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
}
