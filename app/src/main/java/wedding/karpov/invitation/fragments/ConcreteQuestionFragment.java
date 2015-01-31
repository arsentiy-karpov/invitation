package wedding.karpov.invitation.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import wedding.karpov.invitation.R;

/**
 * Created by arsenitykarpov on 31/01/15.
 */
public class ConcreteQuestionFragment extends Fragment {

    public static ConcreteQuestionFragment newInstane() {
        return new ConcreteQuestionFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.question_view_holder, container, false);
        return view;
    }
}
