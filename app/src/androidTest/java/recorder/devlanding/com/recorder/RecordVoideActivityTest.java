package recorder.devlanding.com.recorder;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

/**
 * Created by ted on 12/2/16.
 */

public class RecordVoideActivityTest {

    @Rule
    ActivityTestRule<RecordVoiceActivity> activity =
    new ActivityTestRule<>(RecordVoiceActivity.class);

    @Test
    public void testThatRecordCreatesRecordFile(){
    }
}
