package wedding.karpov.invitation;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by akarpov on 1/13/15.
 */
public class LoginScreenGenerator implements OverlappingScreen.InformationScreenGenerator {

    @Override
    public View getView(Context context, final OverlappingScreen overlappingInformationScreen) {
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layoutInflater.inflate(R.layout.view_login, null);
        v.findViewById(R.id.login_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                overlappingInformationScreen.detach();
            }
        });
//        Drawable background = context.getResources().getDrawable(R.drawable.login_background);
//        background.setAlpha(80);
//        ((ImageView)v.findViewById(R.id.login_background)).setBackgroundDrawable(background);
        return v;
    }

}
