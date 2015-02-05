package wedding.karpov.invitation.fragments;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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

    private EditText mAnswer;

    private String mQuestion;

    private List<String> mQuestionsList;

    public static QuestionCategoryFragment newInstance() {
        QuestionCategoryFragment fragment = new QuestionCategoryFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_question, container, false);
        mAnswer = (EditText) v.findViewById(R.id.answer_field);
        v.findViewById(R.id.refresh_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchQuestions();
            }
        });
        mQuestionsList = new ArrayList<>();
        v.findViewById(R.id.accept_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mQuestion != null && isOnline()) {
                    ParseObject guestAnswerObject = new ParseObject("Guests");
                    guestAnswerObject.put("name",
                            ((InvitationApplication) getActivity().getApplication()).getGuest()
                                    .getName());
                    guestAnswerObject.put("answer", mAnswer.getText().toString());
                    guestAnswerObject.put("question", mQuestion);
                    guestAnswerObject.put("create",
                            Calendar.getInstance(TimeZone.getDefault()).getTime().toString());
                    guestAnswerObject.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            Toast.makeText(getActivity(),
                                    "Отправлено!\n" + mQuestion + ":\n" + mAnswer.getText()
                                            .toString(), Toast.LENGTH_LONG).show();
                            setNewQuestion();
                        }
                    });
                }
            }
        });
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mAnswer.getText().length() < 1) {
            fetchQuestions();
        }

    }

    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getActivity()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    private void addQuestion(String question) {
        if (mQuestionsList == null) {
            mQuestionsList = new ArrayList<>();
        }
        mQuestionsList.add(question);
    }

    private void fetchQuestions() {
        if (isOnline()) {
            if (mAnswer.getText().length() < 1) {
                mAnswer.setHint("Обновление...");
            }
            ParseQuery<ParseObject> query = ParseQuery.getQuery("Questions");
            query.whereNotEqualTo("objectId", "qwerty");
            query.findInBackground(new FindCallback<ParseObject>() {
                @Override
                public void done(List<ParseObject> parseObjects, ParseException e) {
                    if (parseObjects != null && parseObjects.size() > 0) {
                        for (ParseObject object : parseObjects) {
                            addQuestion(object.getString("question"));
                            if (mAnswer.getText().length() < 1) {
                                setNewQuestion();
                            }
                        }
                    } else {
                        if (mAnswer.getText().length() < 1) {
                            setNewQuestion();
                        }
                    }
                }
            });
        } else {
            if (mAnswer.getText().length() < 1) {
                mAnswer.setHint("Проверьте соединение с интернетом");
            }
        }
    }

    private void setNewQuestion() {
        mAnswer.setText("");
        mAnswer.clearFocus();
        mQuestion = getQuestion();
        mAnswer.setHint(mQuestion);
    }

    private String getQuestion() {
        Random random = new Random();
        int q1 = random.nextInt(mQuestionsList.size());
        if (mQuestionsList != null && mQuestionsList.get(q1) != null) {
            mQuestion = mQuestionsList.get(q1);
        }
        return mQuestion;
    }

}
