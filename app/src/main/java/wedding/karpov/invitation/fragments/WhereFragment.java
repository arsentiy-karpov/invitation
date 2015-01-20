package wedding.karpov.invitation.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import wedding.karpov.invitation.InvitationApplication;
import wedding.karpov.invitation.Main;
import wedding.karpov.invitation.R;

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

}
