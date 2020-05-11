package sg.edu.rp.c346.id18011651.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    TextView totalbill;
    TextView eachpays;
    ToggleButton svs;
    ToggleButton gst;
    Button split;
    Button reset;
    EditText amountInput;
    EditText paxInput;
    EditText discountInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalbill =  findViewById(R.id.billDisplay);
        eachpays = findViewById(R.id.payDisplay);
        svs = findViewById(R.id.svsButton);
        gst = findViewById(R.id.gstButton);
        split = findViewById(R.id.splitButton);
        reset = findViewById(R.id.resetButton);
        amountInput = findViewById(R.id.amountInput);
        paxInput = findViewById(R.id.paxInput);
        discountInput = findViewById(R.id.discountInput);

        split.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Code for the action
                Integer amount=Integer.parseInt(amountInput.getText().toString());
                Integer pax=Integer.parseInt(paxInput.getText().toString());
                Float discount=Float.parseFloat(discountInput.getText().toString());
                if(svs.isChecked() && gst.isChecked()){
                    Double total=(amount+(amount*0.17))*((100-discount)/100);
                    Double each=(total/pax);
                    String totalformat=String.format("$%.2f",total);
                    String eachformat=String.format("$%.2f",each);
                    totalbill.setText(totalformat);
                    eachpays.setText(eachformat);
                }else if(svs.isChecked()&& !gst.isChecked()){
                    Double total=(amount+(amount*0.1))*((100-discount)/100);
                    Double each=(total/pax);
                    String totalformat=String.format("$%.2f",total);
                    String eachformat=String.format("$%.2f",each);
                    totalbill.setText(totalformat);
                    eachpays.setText(eachformat);
                }else if(gst.isChecked() && !svs.isChecked()){
                    Double total=(amount+(amount*0.07))*((100-discount)/100);
                    Double each=(total/pax);
                    String totalformat=String.format("$%.2f",total);
                    String eachformat=String.format("$%.2f",each);
                    totalbill.setText(totalformat);
                    eachpays.setText(eachformat);
                }else{
                    Float total=amount*((100-discount)/100);
                    Float each=(total/pax);
                    String totalformat=String.format("$%.2f",total);
                    String eachformat=String.format("$%.2f",each);
                    totalbill.setText(totalformat);
                    eachpays.setText(eachformat);
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Code for the action
                amountInput.setText("");
                paxInput.setText("");
                discountInput.setText("");
                totalbill.setText("");
                eachpays.setText("");
                svs.setChecked(false);
                gst.setChecked(false);
            }
        });
    }
}
