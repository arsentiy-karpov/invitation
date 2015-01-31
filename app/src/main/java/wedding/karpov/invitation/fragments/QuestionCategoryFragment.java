package wedding.karpov.invitation.fragments;

import com.parse.ParseObject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Calendar;
import java.util.TimeZone;

import wedding.karpov.invitation.InvitationApplication;
import wedding.karpov.invitation.R;
import wedding.karpov.invitation.adapters.QuestionsAdapter;
import wedding.karpov.invitation.objects.Question;
import wedding.karpov.invitation.viewholders.QuestionViewHolder;

/**
 * Created by akarpov on 1/22/15.
 */
public class QuestionCategoryFragment extends Fragment {

    private RecyclerView mRecyclerView;

    private QuestionsAdapter mAdapter;

    private static SwitchFragmentListener mListener;

    public interface SwitchFragmentListener
    {
        void onSwitchToConcreteQuestionFragment();
    }

    public static QuestionCategoryFragment newInstance(SwitchFragmentListener listener) {
        QuestionCategoryFragment fragment = new QuestionCategoryFragment();
        mListener = listener;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_question, container, false);
        view.findViewById(R.id.accept_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onSwitchToConcreteQuestionFragment();
            }
        });
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        initAdapter();
        return view;
    }

    private void initAdapter() {
        if (mAdapter == null) {
            QuestionsAdapter questionsAdapter = new QuestionsAdapter();
            questionsAdapter.addItem(new Question().setQuestionString("Евреи и тд?"));
            questionsAdapter.addItem(new Question().setQuestionString("Русские и тд?"));
            questionsAdapter.addItem(new Question().setQuestionString("Корейцы и тд?"));
            questionsAdapter.addItem(new Question().setQuestionString("Словаки и тд?"));
            questionsAdapter.addItem(new Question().setQuestionString("Поляки и тд?"));
            questionsAdapter.addItem(new Question().setQuestionString("Негры и тд?"));
            mRecyclerView.setAdapter(questionsAdapter);
        }
    }

    private void answer() {
        ParseObject guestAnswerObject = new ParseObject("Guests");
        for (int i = 0; i < mRecyclerView.getAdapter().getItemCount(); i++) {
            guestAnswerObject.add("name",
                    ((InvitationApplication) getActivity().getApplication()).getGuest()
                            .getName());
            RecyclerView.ViewHolder viewHolder = mRecyclerView.findViewHolderForPosition(i);
            if (viewHolder.getItemViewType() == QuestionViewHolder.QUESTION_VIEW_TYPE) {
                ((QuestionViewHolder) viewHolder).answer();
                guestAnswerObject
                        .add("answer", ((QuestionViewHolder) viewHolder).getQuestion().getAnswer());
                guestAnswerObject.add("question",
                        ((QuestionViewHolder) viewHolder).getQuestion().getQuestionString());
                guestAnswerObject
                        .add("create", Calendar.getInstance(TimeZone.getDefault()).getTime());
            }
        }
        guestAnswerObject.saveEventually();
    }
}
