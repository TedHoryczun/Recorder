package recorder.devlanding.com.recorder.ListOfAudioFiles;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import recorder.devlanding.com.recorder.R;
import recorder.devlanding.com.recorder.RecordVoiceActivity;

public class ListOfAudioFiles extends AppCompatActivity implements ListOfAudioFilesMVP.view {
    @BindView(R.id.fab)
    FloatingActionButton fab;
    private ListOfAudioPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_audio_files);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        presenter = new ListOfAudioPresenter(this);

    }

    @OnClick(R.id.fab)
    public void clickFabButton(){
        presenter.launchRecordVoiceActivity();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_of_audio_files, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void startRecordVoiceActivity() {
        Intent intent = new Intent(this, RecordVoiceActivity.class);
        startActivity(intent);
    }
}
