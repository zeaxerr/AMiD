package me.zeaxerr.customcircleview;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout layout = new FrameLayout(this);

        CustomCircleView customCircleView = new CustomCircleView(this);
        CustomRectangleView customRectangleView = new CustomRectangleView(this);

        layout.addView(customCircleView);
        layout.addView(customRectangleView);

        setContentView(layout);
    }
}
