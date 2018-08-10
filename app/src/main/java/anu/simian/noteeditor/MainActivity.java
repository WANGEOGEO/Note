package anu.simian.noteeditor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/*
    @author u6165791
    all codes are written by Simian Wang. u6165791
 */

public class MainActivity extends AppCompatActivity {
    List<String> notes = new ArrayList<>();
    int pointer = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clear(View view) {
        TextView tv = (TextView) findViewById(R.id.editText);
        notes.add(tv.getText().toString());
        tv.setText("");
    }

    public void next(View view) {
        TextView tv = (TextView) findViewById(R.id.editText);
        if (notes.size()==0) {
            return;
        }
        if (0 == notes.size() - 1) {
            String show = notes.get(pointer);
            tv.setText(show);
            pointer = -1;
        } else {
            pointer ++;
            if (pointer == notes.size()) {
                pointer = 0;
            } else {
                String show = notes.get(pointer);
                tv.setText(show);
            }
        }
    }

    public void delete(View view) {
        TextView tv = (TextView) findViewById(R.id.editText);
        if (notes.size() == 0) {
            return;
        } else {
            tv.setText(notes.get(pointer - 1));
            notes.remove(pointer);
            pointer --;
        }
    }
}
