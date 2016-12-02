package recorder.devlanding.com.recorder.ListOfAudioFiles;


/**
 * Created by ted on 12/2/16.
 */

public class ListOfAudioPresenter implements ListOfAudioFilesMVP.presenter {
    private final ListOfAudioFilesMVP.view view;

    public ListOfAudioPresenter(ListOfAudioFilesMVP.view view) {
        this.view = view;
    }

    public void launchRecordVoiceActivity() {
        view.startRecordVoiceActivity();
    }

}
