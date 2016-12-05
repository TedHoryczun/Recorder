package recorder.devlanding.com.recorder.RecordVoice;

/**
 * Created by ted on 12/5/16.
 */

public class RecordVoiceMVP {
    interface view{
        void setRecordbuttonInvisible();
        void setRecordButtonVisible();

        void setStopButtonInvisible();
        void setStopButtonVisible();
    }
    interface presenter{
        void setRecordbuttonInvisible();
        void setRecordButtonVisible();

        void setStopButtonInvisible();
        void setStopButtonVisible();
    }
}
