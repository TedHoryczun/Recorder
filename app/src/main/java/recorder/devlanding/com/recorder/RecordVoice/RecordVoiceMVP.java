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

        void incrementTimerBy1(int num);

        void stopTimer();
    }
    interface presenter{
        void setRecordbuttonInvisible();
        void setRecordButtonVisible();

        void setStopButtonInvisible();
        void setStopButtonVisible();

        void startTimer();
    }
}
