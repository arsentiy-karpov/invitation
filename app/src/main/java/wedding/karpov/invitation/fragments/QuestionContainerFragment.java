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
public class QuestionContainerFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question_container, container, false);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        getChildFragmentManager().executePendingTransactions();
        getChildFragmentManager().beginTransaction()
                .addToBackStack(QuestionCategoryFragment.class.getName()).replace(R.id.container,
                QuestionCategoryFragment
                        .newInstance(new QuestionCategoryFragment.SwitchFragmentListener() {
                            @Override
                            public void onSwitchToConcreteQuestionFragment() {
                                getChildFragmentManager().beginTransaction()
                                        .addToBackStack(ConcreteQuestionFragment.class.getName())
                                        .replace(R.id.container,
                                                ConcreteQuestionFragment.newInstane())
                                        .commitAllowingStateLoss();
                            }
                        })).commitAllowingStateLoss();
    }
}
