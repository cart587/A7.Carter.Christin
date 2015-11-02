package itp341.carter.christin.a7.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import itp341.carter.christin.a7.app.model.Note;
import itp341.carter.christin.a7.app.model.NoteSingleton;

/**
 * Created by Chris on 10/28/2015.
 */
public class NoteEditActivity extends Activity {
    public static final String EXTRA_POSITION = "itp341.carter.christin.a7.app.extra_position";

    private EditText editTextTitle;
    private EditText editTextContent;
    private Button btnSaveNote;
    private Button btnDeleteNote;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);

        findAllViews();
        setListeners();

        Intent i = getIntent();

        if(i != null){
            position = i.getIntExtra(EXTRA_POSITION,-1);
            if(position != -1){//Existing note
                Note n = NoteSingleton.getInstance(this).getNotes(position);
                loadViews(n);
            }else{//New note
                btnDeleteNote.setEnabled(false);
            }
        }
    }

    private Note saveNote(){
        return new Note(editTextTitle.getText().toString(),editTextContent.getText().toString());
    }
    private void loadViews(Note n){
        editTextContent.setText(n.getContent());
        editTextTitle.setText(n.getTitle());
    }
    private void findAllViews(){
        editTextTitle = (EditText) findViewById(R.id.editTextTitle);
        editTextContent = (EditText) findViewById(R.id.editTextContent);
        btnSaveNote = (Button) findViewById(R.id.btnSaveNote);
        btnDeleteNote = (Button) findViewById(R.id.btnDeleteNote);
    }

    private void setListeners(){
        //TODO
        btnSaveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Note savedNote = saveNote();
                NoteSingleton.getInstance(getApplicationContext()).updateNote(position,savedNote);
                setResult(RESULT_OK);
                finish();
            }
        });

        btnDeleteNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
