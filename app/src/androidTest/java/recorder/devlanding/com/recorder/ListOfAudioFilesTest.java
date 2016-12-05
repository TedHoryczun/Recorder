package recorder.devlanding.com.recorder;

import android.app.Instrumentation;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import recorder.devlanding.com.recorder.ListOfAudioFiles.ListOfAudioFiles;
import recorder.devlanding.com.recorder.RecordVoice.RecordVoiceActivity;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
/**
 * Created by ted on 12/2/16.
 */

public class ListOfAudioFilesTest {

    @Rule
    public ActivityTestRule<ListOfAudioFiles> activity =
            new ActivityTestRule<>(ListOfAudioFiles.class);
    @Test
    public void doesCreateNewAudioStartRecordActivity(){
        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(RecordVoiceActivity.class.getName(), null, false);
        Espresso.onView(ViewMatchers.withId(R.id.fab)).perform(ViewActions.click());

        RecordVoiceActivity nextActivity = (RecordVoiceActivity) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);

        Assert.assertNotNull("RecordVoidActivity not launched", nextActivity);
    }
}
