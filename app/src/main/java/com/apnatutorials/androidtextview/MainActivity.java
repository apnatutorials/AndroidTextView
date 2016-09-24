package com.apnatutorials.androidtextview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvTextStyling, tvClickableSpan, tvHtmlFormatting;
    public static String FIRST_WORD = "Section of text styling demo - ";
    public static String FIRST_WORD_2 = "Clickable span demo";
    public static String SECOND_WORD = "Strike text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTextStyling = (TextView) findViewById(R.id.tvTextStyling);
        tvClickableSpan = (TextView) findViewById(R.id.tvClickableSpan);
        tvHtmlFormatting = (TextView) findViewById(R.id.tvHtmlFormatting);
        styleSectionOfText();
        handleClickableSpan();
        demonstrateHtmlFormatting();
    }

    /**
     * Method demonstrate html formatting
     */
    private void demonstrateHtmlFormatting() {
        String formattedText = "<b><i>Html</i> formatting <u>demo</u></b> by <a href='http://www.apnatutorials.com'>Apna tutorials</a>";
        tvHtmlFormatting.setText(Html.fromHtml(formattedText));
    }

    /**
     * Demonstrate how we can format section of text
     */
    private void styleSectionOfText() {
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#303F9F"));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(FIRST_WORD);
        spannableStringBuilder.setSpan(colorSpan, 0, spannableStringBuilder.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringBuilder.append(" ");

        //
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        spannableStringBuilder.append(SECOND_WORD);
        spannableStringBuilder.setSpan(strikethroughSpan, spannableStringBuilder.length() - SECOND_WORD.length(), spannableStringBuilder.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        tvTextStyling.setText(spannableStringBuilder);

    }

    /**
     * Demonstrate how we can make clickable span
     */
    private void handleClickableSpan() {

        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(FIRST_WORD_2);
        ClickableSpan clickableStrikeSpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "You clicked strike text", Toast.LENGTH_SHORT).show();
            }
        };

        ClickableSpan clickableNormalSpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "You clicked normal text", Toast.LENGTH_SHORT).show();
            }
        };
        spannableStringBuilder.setSpan(clickableNormalSpan, 0, FIRST_WORD_2.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringBuilder.append(" ");

        //
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        spannableStringBuilder.append(SECOND_WORD);
        spannableStringBuilder.setSpan(strikethroughSpan, spannableStringBuilder.length() - SECOND_WORD.length(), spannableStringBuilder.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringBuilder.setSpan(clickableStrikeSpan, spannableStringBuilder.length() - SECOND_WORD.length(), spannableStringBuilder.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvClickableSpan.setText(spannableStringBuilder);
        tvClickableSpan.setTextColor(Color.BLUE);
        tvClickableSpan.setMovementMethod(LinkMovementMethod.getInstance());
        tvClickableSpan.setHighlightColor(Color.CYAN);
    }


}
