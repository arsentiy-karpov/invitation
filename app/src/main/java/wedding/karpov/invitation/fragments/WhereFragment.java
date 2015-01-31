package wedding.karpov.invitation.fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import wedding.karpov.invitation.InvitationApplication;
import wedding.karpov.invitation.Main;
import wedding.karpov.invitation.R;
import wedding.karpov.invitation.objects.CustomTypefaceSpan;

/**
 * Created by akarpov on 1/14/15.
 */
public class WhereFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_where, container, false);
        return v;
    }

    private void stylingText() {
        SpannableString builder = new SpannableString(getString(R.string.where_text));
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
        CustomTypefaceSpan typefaceSpan = new CustomTypefaceSpan("", font2);
        builder.setSpan(styleSpan, 0, builder.length(), Spanned.SPAN_COMPOSING);
        builder.setSpan(foregroundColorSpan, 0, builder.length(), Spanned.SPAN_COMPOSING);
        builder.setSpan(typefaceSpan, 0, builder.length(), Spanned.SPAN_COMPOSING);
        builder.setSpan(new RelativeSizeSpan(1.8f), 0, builder.length(),
                Spanned.SPAN_COMPOSING);
    }
}
