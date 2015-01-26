package wedding.karpov.invitation.fragments;

import com.parse.ParseObject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import wedding.karpov.invitation.InvitationApplication;
import wedding.karpov.invitation.R;

/**
 * Created by akarpov on 1/22/15.
 */
public class QuestionFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_question, container, false);
        view.findViewById(R.id.accept_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseObject testObject = new ParseObject("Guests");
                testObject.put("name",
                        ((InvitationApplication) getActivity().getApplication()).getGuest()
                                .getName());
                EditText editText = (EditText) view.findViewById(R.id.answer_field);
                if (editText.getText() != null && editText.getText().toString().length() > 0) {
                    testObject.put("answer", editText.getText().toString());
                }
                testObject.saveEventually();
            }
        });
        return view;
    }
}
