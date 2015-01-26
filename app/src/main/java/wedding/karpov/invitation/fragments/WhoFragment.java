package wedding.karpov.invitation.fragments;

import com.parse.ParseObject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import wedding.karpov.invitation.InvitationApplication;
import wedding.karpov.invitation.R;
import wedding.karpov.invitation.guests.AbstarctGuest;

/**
 * Created by akarpov on 1/14/15.
 */
public class WhoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_who, container, false);
        v.findViewById(R.id.accept_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((InvitationApplication) getActivity().getApplication()).getGuest()
                        .approve(new AbstarctGuest.OnApproveListener() {
                            @Override
                            public void onApprove() {

                            }
                        });
            }
        });
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (((InvitationApplication) getActivity().getApplication()).getGuest() != null) {
            getView().findViewById(R.id.accept_btn).setVisibility(
                    ((InvitationApplication) getActivity().getApplication()).getGuest().isApproved()
                            ? View.GONE : View.VISIBLE);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        updateWelcomeText();
    }

    public void updateWelcomeText() {
        if (((InvitationApplication) getActivity().getApplication()).getGuest() != null) {
            ((TextView) getView().findViewById(R.id.welcome_text)).setText(
                    ((InvitationApplication) getActivity().getApplication()).getGuest()
                            .getWelcomeText());
        }
    }

}
