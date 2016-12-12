package recorder.devlanding.com.recorder;

import android.os.Environment;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import recorder.devlanding.com.recorder.RecordVoice.RecordVoiceActivity;
import recorder.devlanding.com.recorder.RecordVoice.RedRecorder;

/**
 * Created by ted on 12/2/16.
 */

public class RecordVoideActivityTest {

    @Rule
    public ActivityTestRule<RecordVoiceActivity> activity =
            new ActivityTestRule<>(RecordVoiceActivity.class);

    @Test
    public void testRecordButtonChangesImageToPause() {
        Espresso.onView(ViewMatchers.withId(R.id.onRecord)).perform(ViewActions.click()).
                check(ViewAssertions.matches(Matchers.not(ViewMatchers.isDisplayed())));
    }

    @Test
    public void testOnStopButtonIsDisplayedAfterOnRecordClicked() {
        Espresso.onView(ViewMatchers.withId(R.id.onRecord)).perform(ViewActions.click()).
                check(ViewAssertions.matches(Matchers.not(ViewMatchers.isDisplayed())));
        Espresso.onView(ViewMatchers.withId(R.id.onStop)).
                check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }


    @Test
    public void testIfRecordVoiceCreatesFile() {
        RedRecorder recorder = new RedRecorder();
        Date date = new Date(System.currentTimeMillis());
        try {
            recorder.startRecording(date.toString());
            TimeUnit.SECONDS.sleep(1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        recorder.stopRecording();

        String audioPath = Environment.getExternalStorageDirectory().getPath() + "/Music/" + date.toString();
        File file = new File(audioPath);
        Assert.assertTrue(file.exists());
    }

    @Test
    public void testIfRecordVoiceCreatesFileOnSecondRecord() throws InterruptedException {
        Espresso.onView(ViewMatchers.withId(R.id.onRecord)).perform(ViewActions.click());
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withId(R.id.onStop)).perform(ViewActions.click());
        Date date = new Date(System.currentTimeMillis());
        Espresso.onView(ViewMatchers.withId(R.id.onRecord)).perform(ViewActions.click());
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withId(R.id.onStop)).perform(ViewActions.click());

        String audioPath = Environment.getExternalStorageDirectory().getPath() + "/Music/" + date.toString();
        File file = new File(audioPath);
        Assert.assertTrue(file.exists());
    }

    @Test
    public void textViewCountsWhenStartRecord() throws InterruptedException {
        Espresso.onView(ViewMatchers.withId(R.id.onRecord)).perform(ViewActions.click());

        int second = 00;
        for (int i = 0; i < 62; i++) {


            if (second >= 60) {
                String minutes = String.format("%02d", second / 60);
                String seconds = String.format("%02d", second % 60);
                String timerText = "00:" + minutes + ":" + seconds;

                Espresso.onView(ViewMatchers.withId(R.id.timer)).
                        check(ViewAssertions.matches(ViewMatchers.withText(timerText)));
            } else {
                String timerText = "00:00:" + String.format("%02d", second);
                Espresso.onView(ViewMatchers.withId(R.id.timer)).
                        check(ViewAssertions.matches(ViewMatchers.withText(timerText)));
            }
            second++;
            TimeUnit.SECONDS.sleep(1);
        }
    }

}
