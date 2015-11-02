package itp341.carter.christin.a7.app.model;

import android.content.ContentProviderClient;
import android.content.Context;

import java.util.ArrayList;

/**
 * Created by Chris on 10/27/2015.
 */
public class NoteSingleton {
    private ArrayList<Note> noteArrayList;
    private static NoteSingleton noteSingleton;
    private Context appContext;

    private NoteSingleton(Context c){
        this.appContext = c;
        noteArrayList = new ArrayList<>();

        for(int i = 0; i <10; i++){
            addNote(new Note("Note "+ i,"I am the "+ i +" note created."));
        }
    }

    public static NoteSingleton getInstance(Context c){
        if(noteSingleton ==  null){
            noteSingleton = new NoteSingleton(c.getApplicationContext());
        }
        return noteSingleton;
    }

    //Data Retrieval Methods
    public ArrayList<Note> getNotes(){
        return noteArrayList;
    }

    public Note getNotes(int index){
        return noteArrayList.get(index);
    }

    public void addNote(Note n){
        noteArrayList.add(n);
    }

    public void updateNote(int position, Note n){
        noteArrayList.set(position, n);
    }

    public void removeNote(int position){
        if(position >= 0 && position <noteArrayList.size()){
            noteArrayList.remove(position);
        }
    }
}
