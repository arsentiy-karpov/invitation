package wedding.karpov.invitation.fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
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

import java.util.ArrayList;

import wedding.karpov.invitation.InvitationApplication;
import wedding.karpov.invitation.Main;
import wedding.karpov.invitation.R;
import wedding.karpov.invitation.objects.CustomTypefaceSpan;

/**
 * Created by akarpov on 1/14/15.
 */
public class WhereFragment extends Fragment{

    TextView mWhereTW;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_where, container, false);
        mWhereTW = (TextView) v.findViewById(R.id.where_text);
        return v;
    }



    @Override
    public void onStart() {
        super.onStart();
        SpannableStringBuilder builder = new SpannableStringBuilder();
        builder.append(getIssueDateText());
        builder.append(getStylingText(getString(R.string.about_kolomna_1)))
                .append("\n\n")
                .append(getStylingText(getString(R.string.about_kolomna_2)))
                .append("\n\n")
                .append(getStylingText(getString(R.string.about_kolomna_3)))
                .append("\n\n")
                .append(getStylingText(getString(R.string.about_kolomna_4)))
                .append("\n\n")
                .append(getStylingText(getString(R.string.about_kolomna_5)))
                .append("\n\n")
                .append(getStylingText(getString(R.string.about_kolomna_6)));
        mWhereTW.setText(builder);
    }

    private CharSequence getIssueDateText() {
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(
                getResources().getColor(
                        R.color.guest_name_color));
        SpannableStringBuilder builder = new SpannableStringBuilder(getString(R.string.where_text));
        builder.setSpan(foregroundColorSpan, 0, builder.length(), Spanned.SPAN_COMPOSING);
        builder.setSpan(new RelativeSizeSpan(1.3f), 0, builder.length(),
                Spanned.SPAN_COMPOSING);
        return builder;
    }

    private CharSequence getStylingText(CharSequence text) {
        SpannableString builder = new SpannableString(text);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(
                getResources().getColor(
                        R.color.guest_name_color));
        StyleSpan styleSpan = new StyleSpan(Typeface.NORMAL);
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "Lora/Lora-Bold.ttf");
        Typeface font2 = Typeface
                .createFromAsset(getActivity().getAssets(), "Marck_Script/MarckScript-Regular.ttf");
        Typeface font3 = Typeface
                .createFromAsset(getActivity().getAssets(), "Neucha/Neucha.ttf");
        Typeface font4 = Typeface
                .createFromAsset(getActivity().getAssets(), "Ruslan_Display/RuslanDisplay.ttf");
        Typeface font5 = Typeface
                .createFromAsset(getActivity().getAssets(), "Seymour_One/SeymourOne-Regular.ttf");

        CustomTypefaceSpan typefaceSpan = new CustomTypefaceSpan("", font3);
        builder.setSpan(styleSpan, 0, 1, Spanned.SPAN_COMPOSING);
        builder.setSpan(foregroundColorSpan, 0, 1, Spanned.SPAN_COMPOSING);
        builder.setSpan(typefaceSpan, 0, 1, Spanned.SPAN_COMPOSING);
        builder.setSpan(new RelativeSizeSpan(1.8f), 0, 1,
                Spanned.SPAN_COMPOSING);
        builder.setSpan(new RelativeSizeSpan(1.3f), 1, builder.length(),
                Spanned.SPAN_COMPOSING);
        return builder;
    }
}
