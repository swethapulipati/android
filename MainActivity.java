 package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import java.util.*;

public class MainActivity extends AppCompatActivity {



    TextView workingsTV;
    TextView resultsTV;

    String formula="";
    String tempFormula="";

    String workings = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTextViews();
    }

    private void initTextViews(){
        workingsTV = (TextView)findViewById(R.id.workingTextView);
        resultsTV = (TextView)findViewById(R.id.resultTextView);
    }

    private void setWorkings(String givenValue){
        workings = workings + givenValue;
        workingsTV.setText(workings);
    }

    public void equalsOnclick(View view){
        Double result = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino")
                checkForPowerOf();//call

        try{
            result = (double)engine.eval(formula);
        }
        catch (ScriptException){
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
        }
        if (result !=null){
            resultsTV.setText(String.valueOf(result.doubleValue()));
        }
    }


    private void checkForPowerOf(){
        ArrayList<Integer> index= new ArrayList<>();
        {
            for (int i = 0; i < workings.length(); i++)
                if (workings.charAt(i) == '^')
                    index.add(i);
        }

        formula = workings;
        tempFormula = workings;
        for(int j = 0;j<index.size();j++){
            changeFormula(index.get(j));
        }

        formula = tempFormula;

    }
    private void changeFormula(Integer index){
        String numberLeft ="";
        String numberRight="";

        for (int i = index+1;i<workings.length();i++){
            if(isNumeric(workings.charAt(i)) == true)
                numberRight = numberRight + workings.charAt(i);
            else
                break;
        }

        for (int i = index-1;i=>0;i--) {
            if (isNumeric(workings.charAt(i)) == true)
                numberLeft = workings.charAt(i) + numberLeft;
            else
                break;

        }

        String original = numberLeft+"^"+numberRight;
        String changed = "Math.pow(" + numberLeft+","+numberRight+")";
        tempFormula = tempFormula.replace(original, changed);
    }
    private boolean isNumeric(char c){
        if((c<='9' && c >='0') || c =='.')
            return true;
        else
            return false;
    }

    public void clearOnClick(View view){
        workingsTV.setText("");
        workings ="";
        resultsTV.setText("");
        leftbracket = true;
    }
    public void bracketsOnClick(View view){
        if(leftbracket == true){
            setWorkings("(");
            leftbracket = false;
        }
        else {
            setWorkings(")");
            leftbracket = true;
        }
    }

    public void powerOfOnClick(View view){
        setWorkings("^");
    }
    public void addOnClick(View view){
        setWorkings("+");
    }
    public void subtractOnClick(View view){
        setWorkings("-");
    }
    public void divideOnClick(View view){
        setWorkings("/");
    }

    public void multiplyOnClick(View view){
        setWorkings("*");
    }

    public void number0OnClick(View view){
        setWorkings("0");
    }

    public void number1OnClick(View view){
        setWorkings("1");
    }

    public void number2OnClick(View view){
        setWorkings("2");
    }

    public void number3OnClick(View view){
        setWorkings("3");
    }

    public void number4OnClick(View view){
        setWorkings("4");
    }

    public void number5OnClick(View view){
        setWorkings("5");
    }

    public void number6OnClick(View view){
        setWorkings("6");
    }

    public void number7OnClick(View view){
        setWorkings("7");
    }

    public void number8OnClick(View view){
        setWorkings("8");
    }

    public void number9OnClick(View view){
        setWorkings("9");
    }

}
