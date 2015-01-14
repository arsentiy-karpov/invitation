package wedding.karpov.invitation.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import wedding.karpov.invitation.InvitationApplication;
import wedding.karpov.invitation.R;

/**
 * Created by akarpov on 1/14/15.
 */
public class WhoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_who, container, false);
        return inflater.inflate(R.layout.fragment_who, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (((InvitationApplication) getActivity().getApplication()).getGuest() != null) {
            ((TextView) getView().findViewById(R.id.welcome_text)).setText(
                    ((InvitationApplication) getActivity().getApplication()).getGuest()
                            .getWelcomeText());
        }
    }
}
