package life.jabs.calculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnAdd1, btnSub1, btnDiv1, btnMul1, btnMod1;
    private TextView tvResult;
    private EditText etFirstNumber, etSecondNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init()
    {
        btnAdd1 = (Button)findViewById(R.id.btnAdd);
        btnSub1 = (Button)findViewById(R.id.btnSub);
        btnDiv1 = (Button)findViewById(R.id.btnDiv);
        btnMul1 = (Button)findViewById(R.id.btnMul);
        btnMod1 = (Button)findViewById(R.id.btnMod);
        etFirstNumber = (EditText)findViewById(R.id.etFirstNumber);
        etSecondNumber = (EditText)findViewById(R.id.etSecondNumber);
        tvResult = (TextView)findViewById(R.id.tvResult);

        btnAdd1.setOnClickListener(this);
        btnSub1.setOnClickListener(this);
        btnDiv1.setOnClickListener(this);
        btnMul1.setOnClickListener(this);
        btnMod1.setOnClickListener(this);
    }

    public void onClick(View view)
    {
        String num1 = etFirstNumber.getText().toString();
        String num2 = etSecondNumber.getText().toString();
        int res;

        switch(view.getId()) {
            case R.id.btnAdd:
                res = Integer.parseInt(num1) + Integer.parseInt(num2);
                tvResult.setText(String.valueOf(res));
                break;
            case R.id.btnSub:
                res = Integer.parseInt(num1) - Integer.parseInt(num2);
                tvResult.setText(String.valueOf(res));
                break;
            case R.id.btnMod:
                res = Integer.parseInt(num1) % Integer.parseInt(num2);
                tvResult.setText(String.valueOf(res));
                break;
            case R.id.btnMul:
                try
                {
                    res = Integer.parseInt(num1) * Integer.parseInt(num2);
                    if (res > 1000)
                    {
                        tvResult.setText("Too large to multiply");
                    }
                    else {
                        tvResult.setText(String.valueOf(res));
                    }
                } catch (Exception e)
                {
                    tvResult.setText("Cannot multiply");
                }
                break;
            case R.id.btnDiv:
                try
                {
                    res = Integer.parseInt(num1) / Integer.parseInt(num2);
                    tvResult.setText(String.valueOf(res));
                } catch (Exception e)
                {
                    tvResult.setText("Cannot divide");
                }
                break;
        }
    }

}
