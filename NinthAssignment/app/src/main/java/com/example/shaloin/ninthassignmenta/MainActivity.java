package com.example.shaloin.ninthassignmenta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import static com.example.shaloin.ninthassignmenta.R.styleable.View;

public class MainActivity extends AppCompatActivity {

    private EditText message;
    private Button save_button,check_button;
    static final int READ_BLOCK_SIZE=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        message=(EditText)findViewById(R.id.messageEditID);
        save_button=(Button)findViewById(R.id.saveButton);
        check_button=(Button)findViewById(R.id.checkButton);
    }

    public void save(View v){
        try{
            FileOutputStream fileout=openFileOutput("mytextfile.txt",MODE_PRIVATE);
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileout);
            outputStreamWriter.write(message.getText().toString());
            outputStreamWriter.close();

            Toast.makeText(getApplicationContext(),"File Saved",Toast.LENGTH_LONG).show();
        }catch (Exception e){
            e.printStackTrace();
        }

    }






    public void check(View v) throws IOException {

        try{

        FileInputStream fileIn=openFileInput("mytextfile.txt");
        InputStreamReader InputRead=new InputStreamReader(fileIn);
        char[] inputbuffer=new char[READ_BLOCK_SIZE];
        String s="";
        int charRead;
        while((charRead=InputRead.read(inputbuffer))>0){
            String readString=String.copyValueOf(inputbuffer,0,charRead);
            s+=readString;

        }
        InputRead.close();
        Toast.makeText(getBaseContext(),s,Toast.LENGTH_LONG).show();}
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
