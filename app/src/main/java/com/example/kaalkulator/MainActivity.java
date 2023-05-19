package com.example.kaalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.kaalkulator.R;
import com.google.android.material.button.MaterialButton;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView result,solution;
    MaterialButton bc,bbo,bbc, bac;
    MaterialButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0;
    MaterialButton div,mul,add,sub,bp,eq;
    MaterialButton sin,cos,tan,log,sininv,cosinv,taninv,mod, root,pi, be,ln ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result);
        solution = findViewById(R.id.solution);

        assignId(b0, R.id.b0);
        assignId(b1, R.id.b1);
        assignId(b2, R.id.b2);
        assignId(b3, R.id.b3);
        assignId(b4, R.id.b4);
        assignId(b5, R.id.b5);
        assignId(b6, R.id.b6);
        assignId(b7, R.id.b7);
        assignId(b8, R.id.b8);
        assignId(b9, R.id.b9);
        assignId(bc, R.id.bc);
        assignId(bbo, R.id.bbo);
        assignId(bbc, R.id.bbc);
        assignId(div, R.id.div);
        assignId(mul, R.id.mul);
        assignId(sub, R.id.sub);
        assignId(add, R.id.add);
        assignId(eq, R.id.eq);
        assignId(bp, R.id.bp);
        assignId(bac, R.id.bac);







    }

    void assignId(MaterialButton btn,int id){
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        MaterialButton button =(MaterialButton) view;
        String buttonText = button.getText().toString();
        String dataToCalculate = solution.getText().toString();

        if(buttonText.equals("Ac")){
            solution.setText("");
            result.setText("");
            return;
        }
        if(buttonText.equals("=")){
            solution.setText(result.getText());
            return;
        }
        if(buttonText.equals("C")){
            if(dataToCalculate.length()>1){
                dataToCalculate = dataToCalculate.substring(0,dataToCalculate.length()-1);
            }else{
                solution.setText("");
                result.setText("");
                return;
            }
        }







        else{
            dataToCalculate = dataToCalculate+buttonText;
        }
        solution.setText(dataToCalculate);

        String finalResult = getResult(dataToCalculate);

        if(!finalResult.equals("Err")){
            result.setText(finalResult);
        }

    }
    String getResult(String data){
        try{
            Context context  = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initStandardObjects();
            String finalResult =  context.evaluateString(scriptable,data,"Javascript",1,null).toString();
            if(finalResult.endsWith(".0")){
                finalResult = finalResult.replace(".0","");
            }
            return finalResult;
        }catch (Exception e){
            return "Err";
        }
    }

}