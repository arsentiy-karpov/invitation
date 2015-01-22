package wedding.karpov.invitation.guests;

import com.parse.ParseObject;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;

import wedding.karpov.invitation.R;
import wedding.karpov.invitation.objects.CustomTypefaceSpan;

/**
 * Created by arsenitykarpov on 14/01/15.
 */
public abstract class AbstarctGuest implements Guest {

    private Context mContext;

    private boolean mIsApproved = false;

    protected AbstarctGuest(Context context) {
        mContext = context;
    }

    @Override
    public CharSequence getWelcomeText() {
        SpannableStringBuilder text = SpannableStringBuilder.valueOf(getStylingName());
        text.append("\n");
        text.append(getStylingWelcomeText());
        return text;
    }

    protected CharSequence getStylingName() {
        SpannableString builder = new SpannableString(getName() + "!");
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(
                mContext.getResources().getColor(
                        R.color.guest_name_color));
        StyleSpan styleSpan = new StyleSpan(Typeface.NORMAL);
        Typeface font = Typeface.createFromAsset(mContext.getAssets(), "Lora/Lora-Bold.ttf");
        Typeface font2 = Typeface
                .createFromAsset(mContext.getAssets(), "Marck_Script/MarckScript-Regular.ttf");
        Typeface font3 = Typeface
                .createFromAsset(mContext.getAssets(), "Neucha/Neucha.ttf");
        Typeface font4 = Typeface
                .createFromAsset(mContext.getAssets(), "Ruslan_Display/RuslanDisplay.ttf");
        Typeface font5 = Typeface
                .createFromAsset(mContext.getAssets(), "Seymour_One/SeymourOne-Regular.ttf");
        CustomTypefaceSpan typefaceSpan = new CustomTypefaceSpan("", font2);
        builder.setSpan(styleSpan, 0, builder.length(), Spanned.SPAN_COMPOSING);
        builder.setSpan(foregroundColorSpan, 0, builder.length(), Spanned.SPAN_COMPOSING);
//        builder.setSpan(typefaceSpan, 0, builder.length(), Spanned.SPAN_COMPOSING);
        builder.setSpan(new RelativeSizeSpan(1.8f), 0, builder.length(),
                Spanned.SPAN_COMPOSING);
        return builder;
    }

    protected CharSequence getStylingWelcomeText() {
        SpannableString builder = new SpannableString(mContext.getString(getResourceId()));
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(
                mContext.getResources().getColor(
                        R.color.guest_name_color));
        StyleSpan styleSpan = new StyleSpan(Typeface.NORMAL);
        Typeface font = Typeface.createFromAsset(mContext.getAssets(), "Lora/Lora-Bold.ttf");
        Typeface font2 = Typeface
                .createFromAsset(mContext.getAssets(), "Marck_Script/MarckScript-Regular.ttf");
        Typeface font3 = Typeface
                .createFromAsset(mContext.getAssets(), "Neucha/Neucha.ttf");
        Typeface font4 = Typeface
                .createFromAsset(mContext.getAssets(), "Ruslan_Display/RuslanDisplay.ttf");
        Typeface font5 = Typeface
                .createFromAsset(mContext.getAssets(), "Seymour_One/SeymourOne-Regular.ttf");
        CustomTypefaceSpan typefaceSpan = new CustomTypefaceSpan("", font);
        builder.setSpan(styleSpan, 0, builder.length(), Spanned.SPAN_COMPOSING);
//        builder.setSpan(foregroundColorSpan, 0, builder.length(), Spanned.SPAN_COMPOSING);
//        builder.setSpan(typefaceSpan, 0, builder.length(), Spanned.SPAN_COMPOSING);
//        builder.setSpan(new RelativeSizeSpan(f), 0, builder.length(),
//                Spanned.SPAN_COMPOSING);
        return builder;
    }

    @Override
    public void approve(OnApproveListener listener) {
        mIsApproved = true;
        listener.onApprove();
    }

    @Override
    public boolean isApproved() {
        return mIsApproved;
    }

    protected abstract int getResourceId();

    public static interface OnApproveListener {
        void onApprove();
    }

}
