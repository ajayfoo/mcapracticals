package vesit.ajayk57.mc.practical6;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageView targetImg;
    Button blinkBtn, rotateBtn, fadeBtn, moveBtn, slideBtn, resetBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        targetImg = findViewById(R.id.targetImg);
        blinkBtn = findViewById(R.id.blinkAniBtn);
        rotateBtn = findViewById(R.id.rotateAniBtn);
        fadeBtn = findViewById(R.id.fadeAniBtn);
        moveBtn = findViewById(R.id.moveAniBtn);
        slideBtn = findViewById(R.id.slideAniBtn);
        resetBtn = findViewById(R.id.resetBtn);
        Button expandAniBtn=findViewById(R.id.expandAniBtn);
        Button brightenBtn=findViewById(R.id.brightenBtn);
        Button darkenBtn=findViewById(R.id.darkenBtn);
        Button grayscaleBtn=findViewById(R.id.grayscaleBtn);
        moveBtn.setOnClickListener(v -> {
            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                    R.anim.move);
            targetImg.startAnimation(animation);
        });
        rotateBtn.setOnClickListener(v -> {
            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                    R.anim.rotate);
            targetImg.startAnimation(animation);
        });
        expandAniBtn.setOnClickListener(v -> {
            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                    R.anim.expand);
            targetImg.startAnimation(animation);
        });
        brightenBtn.setOnClickListener(v -> targetImg.setImageBitmap(
                ImageUtils.doBrightness(ImageUtils.imageViewToBitmap(targetImg))
        ));
        darkenBtn.setOnClickListener(v -> targetImg.setImageBitmap(
                ImageUtils.applyBlackFilter(ImageUtils.imageViewToBitmap(targetImg))
        ));
        grayscaleBtn.setOnClickListener(v -> targetImg.setImageBitmap(
                ImageUtils.doGreyscale(ImageUtils.imageViewToBitmap(targetImg))
        ));
        blinkBtn.setOnClickListener(v -> {
            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                    R.anim.blink);
            targetImg.startAnimation(animation);
        });

        fadeBtn.setOnClickListener(v -> {
            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                    R.anim.fade);
            targetImg.startAnimation(animation);
        });
        slideBtn.setOnClickListener(v -> {
            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                    R.anim.slide);
            targetImg.startAnimation(animation);
        });
        resetBtn.setOnClickListener(v -> resetTargetImage());
    }
    private void resetTargetImage(){
        targetImg.clearAnimation();
        targetImg.setImageResource(R.drawable.android_face);
    }
}