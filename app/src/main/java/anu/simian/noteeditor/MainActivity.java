package anu.simian.noteeditor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> notes = new ArrayList<>();
    int pointer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clear(View view) {
        TextView tv = (TextView) findViewById(R.id.editText);
        notes.add(tv.getText().toString());
        tv.setText("This is my note application !");
    }

    public void next(View view) {
        TextView tv = (TextView) findViewById(R.id.editText);
        if (pointer == notes.size() - 1) {
            String show = notes.get(0);
            tv.setText(show);
            pointer = 0;
        } else {
            String show = notes.get(pointer);
            tv.setText(show);
            pointer ++;
        }
    }

    public void delete(View view) {
        TextView tv = (TextView) findViewById(R.id.editText);
        if (notes.size() == 0) {
            return;
        } else {
            if (pointer == 0) {
                if (notes.size() == 1) {
                    tv.setText("This is my note application !");
                    notes.remove(pointer);
                } else {
                    tv.setText(notes.get(pointer + 1));
                    notes.remove(pointer);
                }
            } else {
                tv.setText(notes.get(pointer - 1));
                notes.remove(pointer);
                pointer --;
            }
        }
    }
}
