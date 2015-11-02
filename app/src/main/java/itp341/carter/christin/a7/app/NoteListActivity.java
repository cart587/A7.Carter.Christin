package itp341.carter.christin.a7.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import itp341.carter.christin.a7.app.model.Note;
import itp341.carter.christin.a7.app.model.NoteSingleton;
import itp341.carter.christin.a7.app.model.customArrayAdapter;

public class NoteListActivity extends Activity{

    private customArrayAdapter noteAdapter;
    private ListView listViewNotes;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noteAdapter = new customArrayAdapter(this, NoteSingleton.getInstance(this).getNotes());
        listViewNotes = (ListView) findViewById(R.id.listViewNotes);
        btnAdd = (Button) findViewById(R.id.btnAdd);

        listViewNotes.setAdapter(noteAdapter);
        setListeners();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            noteAdapter.notifyDataSetChanged();
        }
    }

    private void setListeners(){
        listViewNotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(),NoteEditActivity.class);
                i.putExtra(NoteEditActivity.EXTRA_POSITION,position);
                startActivityForResult(i,0);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),NoteEditActivity.class);
                startActivityForResult(i,0);
            }
        });
    }

}