package com.github.anastr.speedview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import com.github.anastr.speedviewlib.PointerSpeedometer;
import java.util.Locale;

public class FuelActivity extends AppCompatActivity {

    PointerSpeedometer pointerSpeedometer;
    SeekBar seekBarSpeed;
    Button ok;
    TextView textSpeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel);

        pointerSpeedometer = (PointerSpeedometer) findViewById(R.id.pointerSpeedometer);
        seekBarSpeed = (SeekBar) findViewById(R.id.seekBarSpeed);
        ok = (Button) findViewById(R.id.ok);
        textSpeed = (TextView) findViewById(R.id.textSpeed);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pointerSpeedometer.speedTo(seekBarSpeed.getProgress());
            }
        });

        seekBarSpeed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textSpeed.setText(String.format(Locale.getDefault(), "%d", progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
