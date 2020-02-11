package com.example.exercise_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class DisplayResultActiviy extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.display_result);
    TextView result = (TextView) findViewById(R.id.txtResult);
//    result.setText(getIntent().getStringExtra(DisplayMainActivity.Message));
    Intent intent = getIntent();
    String message = intent.getStringExtra(DisplayMainActivity.Message);
    result.setText(message);
  } //  onCreate
  public void displayMain(View view){
    Intent intent  = new Intent(this, DisplayMainActivity.class);
    startActivity(intent);
  } //  display_result

} //  DisplayActivity
