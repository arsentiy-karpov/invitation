package wedding.karpov.invitation.adapters;

import com.parse.ParseObject;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import wedding.karpov.invitation.InvitationApplication;
import wedding.karpov.invitation.R;
import wedding.karpov.invitation.objects.Question;
import wedding.karpov.invitation.viewholders.QuestionViewHolder;

/**
 * Created by akarpov on 1/28/15.
 */
public class QuestionsAdapter extends RecyclerView.Adapter {

    private List<Question> mItems = new ArrayList<>();

    public void addItem(Question item) {
        mItems.add(item);
    }

    @Override
    public int getItemViewType(int position) {
        if (mItems.get(position).getType() == Question.QuestionType.SIMPLE) {
            return QuestionViewHolder.QUESTION_VIEW_TYPE;
        }
        return 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        switch (i) {
            case QuestionViewHolder.QUESTION_VIEW_TYPE:
                View v = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.question_view_holder, viewGroup, false);
                return new QuestionViewHolder(v);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        switch (viewHolder.getItemViewType()) {
            case QuestionViewHolder.QUESTION_VIEW_TYPE:
                ((QuestionViewHolder) viewHolder).bindQuestion(mItems.get(i));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

}
