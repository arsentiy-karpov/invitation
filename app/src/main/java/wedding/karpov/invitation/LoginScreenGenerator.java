package wedding.karpov.invitation;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import wedding.karpov.invitation.guests.Guest;
import wedding.karpov.invitation.guests.helpers.GuestFactory;

/**
 * Created by akarpov on 1/13/15.
 */
public class LoginScreenGenerator implements OverlappingScreen.InformationScreenGenerator {

    @Override
    public View getView(final OverlappingScreen overlappingInformationScreen) {
        LayoutInflater layoutInflater = overlappingInformationScreen.getActivity()
                .getLayoutInflater();
        final View v = layoutInflater.inflate(R.layout.view_login, null);
        v.findViewById(R.id.login_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Guest guest = GuestFactory
                        .getGuestByCode(((EditText) v.findViewById(R.id.code)).getText().toString(),
                                overlappingInformationScreen.getActivity());
                if (guest != null) {
                    ((InvitationApplication) (overlappingInformationScreen.getActivity()
                            .getApplication())).setGuest(guest);
                    ((Main)overlappingInformationScreen.getActivity()).showGuestContent();
                    overlappingInformationScreen.detach();
                } else {
                    Toast.makeText(overlappingInformationScreen.getActivity(),
                            overlappingInformationScreen.getActivity()
                                    .getString(R.string.login_wrong_code), Toast.LENGTH_LONG)
                            .show();
                }
            }
        });
        return v;
    }

}
