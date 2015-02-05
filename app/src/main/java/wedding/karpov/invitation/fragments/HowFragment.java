package wedding.karpov.invitation.fragments;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import wedding.karpov.invitation.R;

/**
 * Created by akarpov on 2/5/15.
 */
public class HowFragment extends Fragment {

    TextView mHowTW;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        android.view.View v = inflater.inflate(R.layout.fragment_how, container, false);
        mHowTW = (TextView) v.findViewById(R.id.how_text);
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        SpannableStringBuilder builder = new SpannableStringBuilder();
        builder.append(getStylingText(getString(R.string.how_text)));
        mHowTW.setText(builder);
    }

    private CharSequence getStylingText(CharSequence text) {
        SpannableString builder = new SpannableString(text);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(
                getResources().getColor(
                        R.color.guest_name_color));
        StyleSpan styleSpan = new StyleSpan(Typeface.NORMAL);
        builder.setSpan(styleSpan, 0, 1, Spanned.SPAN_COMPOSING);
        builder.setSpan(foregroundColorSpan, 0, 1, Spanned.SPAN_COMPOSING);
        builder.setSpan(new RelativeSizeSpan(1.8f), 0, 1,
                Spanned.SPAN_COMPOSING);
        builder.setSpan(new RelativeSizeSpan(1.2f), 1, builder.length(),
                Spanned.SPAN_COMPOSING);
        return builder;
    }

}