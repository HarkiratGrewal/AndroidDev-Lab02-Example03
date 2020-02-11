package com.example.exercise_2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.text.DecimalFormat;

public class DisplayMainActivity extends AppCompatActivity {

  public static final String Message = "message";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.display_main);
    //  Result Button
    Button btnResult = (Button) findViewById(R.id.btnRestart);

    btnResult.setOnClickListener(new View.OnClickListener(){
      @Override
      public void onClick(View view){
        Intent intent = new Intent(view.getContext(), DisplayResultActiviy.class);
        //  Problem with displayMessage
        String message = displayMessage();
        intent.putExtra(Message, message);
        startActivity(intent);
      } //  onClick
    }); //  btnResult

    Button btnReset = (Button) findViewById(R.id.btnReset);
    btnReset.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        clearTextBoxes();
      } //  onClick
    }); //  btnReset

  } //  onCreate

  public String displayMessage(){
    String rtnMessage;
    EditText FirstName = (EditText) findViewById(R.id.etFirstName);
    EditText LastName = (EditText) findViewById(R.id.etLastName);
    EditText Weight = (EditText) findViewById(R.id.etWeight);
    double weight = Double.parseDouble(Weight.getText().toString());
    double IdealWeight = idealWeight();
    DecimalFormat df = new DecimalFormat("###.##"); //  Change pattern to add more decimal spaces
    if(weight > IdealWeight){
      rtnMessage = "Hello " + FirstName.getText().toString() + " " + LastName.getText().toString() + ", you need to " + getResources().getString(R.string.over) + " " + df.format(weight-IdealWeight) + " kgs.";
    } //  greater
    else if (weight < IdealWeight){
      rtnMessage = "Hello " + FirstName.getText().toString() + " " + LastName.getText().toString() + ", you need to " + getResources().getString(R.string.below) + " " + df.format(weight-IdealWeight) + " kgs.";
    } //  lesser
    else{
      rtnMessage = "Hello " + FirstName.getText().toString() + " " + LastName.getText().toString() + ", you are in perfect shape.";
    } //  equal
    return rtnMessage;
  } //  displayMessage

  public double idealWeight(){
    double weight;
    RadioButton GenderMale = (RadioButton) findViewById(R.id.rbMale);
    RadioButton GenderFemale = (RadioButton) findViewById(R.id.rbFemale);
    EditText Height = (EditText) findViewById(R.id.etHeight);
    double height = Double.parseDouble(Height.getText().toString());
    if(GenderMale.isChecked()){
      weight = (height-100)-((height-150)/2.5);
    } else if(GenderFemale.isChecked()){
      weight = (height-100)-((height-150)/4);
    } //  Gender ifElse
    else{
      weight = 0;
    } //  notSelectedAny
    return weight;
  } //  calculateIdealWeight

  public void clearTextBoxes(){
    EditText FirstName = (EditText) findViewById(R.id.etFirstName);
    EditText LastName = (EditText) findViewById(R.id.etLastName);
    EditText Height = (EditText) findViewById(R.id.etHeight);
    EditText Weight = (EditText) findViewById(R.id.etWeight);
    RadioGroup rbgGender = (RadioGroup) findViewById(R.id.rbgGender);
    FirstName.setText("");
    LastName.setText("");
    Height.setText("");
    Weight.setText("");
    FirstName.setHint(R.string.firstName_Hint);
    LastName.setHint(R.string.lastName_Hint);
    Height.setHint(R.string.height_Hint);
    Weight.setHint(R.string.weight_Hint);
    rbgGender.clearCheck();
  } //  clearTextBoxes
} //  DisplayMainActivity
