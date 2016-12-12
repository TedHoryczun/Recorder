package recorder.devlanding.com.recorder.RecordVoice;

import android.media.MediaRecorder;
import android.os.Environment;

import java.io.IOException;

/**
 * Created by ted on 12/5/16.
 */
public class RedRecorder {
    private static final String LOG_TAG = "RedRecorder";
    private MediaRecorder recorder;

    public void startRecording(String currentDate) throws IOException {
        recorder = new MediaRecorder();

        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        recorder.setOutputFile(Environment.getExternalStorageDirectory().getPath() + "/Music/" + currentDate);
        recorder.prepare();

        try{

            recorder.start();
        }catch(IllegalStateException e){
            e.printStackTrace();
        }

    }

    public void stopRecording() {
        try{
            recorder.stop();
        }catch(IllegalStateException e){
           e.printStackTrace();
        }

        recorder.release();
        recorder = null;
    }
}
