package wedding.karpov.invitation.viewholders;

import com.parse.ParseObject;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import wedding.karpov.invitation.R;
import wedding.karpov.invitation.objects.Question;

/**
 * Created by akarpov on 1/28/15.
 */
public class QuestionViewHolder extends RecyclerView.ViewHolder {

    private Question mQuestion;

    public static final int QUESTION_VIEW_TYPE = 0;

    public QuestionViewHolder(View itemView) {
        super(itemView);
    }

    public void bindQuestion(Question question) {
        mQuestion = question;
        EditText q = (EditText)itemView
                .findViewById(R.id.answer_field);
        q.setHint(mQuestion.getQuestionString());
    }

    public void answer() {
        EditText q = (EditText)itemView
                .findViewById(R.id.answer_field);
        getQuestion().setAnswer(q.getText().toString());
    }

    public Question getQuestion() {
        return mQuestion;
    }
}
