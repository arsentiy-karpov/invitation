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
import java.util.Random;
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


    public static QuestionCategoryFragment newInstance() {
        QuestionCategoryFragment fragment = new QuestionCategoryFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_question, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        initAdapter();
        return view;
    }

    private void initAdapter() {
        if (mAdapter == null) {
            Random random = new Random();
            int q1 = random.nextInt(5);
            int q2 = random.nextInt(5);

            QuestionsAdapter questionsAdapter = new QuestionsAdapter(getActivity());

            switch (q1) {
                case 0:
                    questionsAdapter.addItem(new Question().setQuestionString("Вопрос о нас 1?"));
                    break;
                case 1:
                    questionsAdapter.addItem(new Question().setQuestionString("Вопрос о нас 2?"));
                    break;
                case 2:
                    questionsAdapter.addItem(new Question().setQuestionString("Вопрос о нас 3?"));
                    break;
                case 3:
                    questionsAdapter.addItem(new Question().setQuestionString("Вопрос о нас 4?"));
                    break;
                case 4:
                    questionsAdapter.addItem(new Question().setQuestionString("Вопрос о нас 5?"));
                    break;
            }

            switch (q2) {
                case 0:
                    questionsAdapter.addItem(new Question().setQuestionString("Евреи и тд 1?"));
                    break;
                case 1:
                    questionsAdapter.addItem(new Question().setQuestionString("Евреи и тд 2?"));
                    break;
                case 2:
                    questionsAdapter.addItem(new Question().setQuestionString("Евреи и тд 3?"));
                    break;
                case 3:
                    questionsAdapter.addItem(new Question().setQuestionString("Евреи и тд 4?"));
                    break;
                case 4:
                    questionsAdapter.addItem(new Question().setQuestionString("Евреи и тд 5?"));
                    break;
            }
            mRecyclerView.setAdapter(questionsAdapter);
        }
    }
}