package com.example.ass2;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    private Button mButtonCount;
    private Button mButtonZero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShowCount = findViewById(R.id.show_count);
        mButtonCount = findViewById(R.id.button_count);
        mButtonZero = findViewById(R.id.button_zero);

        if (savedInstanceState != null) {
            mCount = savedInstanceState.getInt("count", 0);
            mShowCount.setText(String.valueOf(mCount));
            updateColors();
        }
    }

    public void showToast(View view) {
        Toast.makeText(this, "Hello Toast!", Toast.LENGTH_SHORT).show();
    }

    public void showCount(View view) {
        mCount++;
        mShowCount.setText(String.valueOf(mCount));
        updateColors();
    }

    public void showZero(View view) {
        mCount = 0;
        mShowCount.setText(String.valueOf(mCount));
        updateColors();
    }

    private void setTint(Button button, int colorRes) {
        button.setBackgroundTintList(
                ColorStateList.valueOf(ContextCompat.getColor(this, colorRes)));
    }

    private void updateColors() {
        // زر Zero: رمادي إذا العداد 0، وإلا برتقالي
        setTint(mButtonZero, mCount == 0 ? R.color.gray : R.color.orange);

        // زر Count: أخضر للفردي، أزرق للزوجي
        setTint(mButtonCount, mCount % 2 == 0 ? R.color.blue : R.color.green);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", mCount);
    }
}