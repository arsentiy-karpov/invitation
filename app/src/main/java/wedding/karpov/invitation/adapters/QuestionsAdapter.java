package wedding.karpov.invitation.adapters;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import wedding.karpov.invitation.InvitationApplication;
import wedding.karpov.invitation.R;
import wedding.karpov.invitation.objects.Question;
import wedding.karpov.invitation.viewholders.AppUpdateInfoViewHolder;
import wedding.karpov.invitation.viewholders.QuestionViewHolder;

/**
 * Created by akarpov on 1/28/15.
 */
public class QuestionsAdapter extends RecyclerView.Adapter {

    private List<Question> mItems = new ArrayList<>();

    private Activity mActivity;

    public QuestionsAdapter(Activity activity) {
        mActivity = activity;
    }

    public void addItem(Question item) {
        mItems.add(item);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount() - 1) {
            return AppUpdateInfoViewHolder.APP_INFO_VIEW_TYPE;
        } else if (mItems.get(position).getType() == Question.QuestionType.SIMPLE) {
            return QuestionViewHolder.QUESTION_VIEW_TYPE;
        }
        return 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = null;
        switch (i) {
            case QuestionViewHolder.QUESTION_VIEW_TYPE:
                v = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.question_view_holder, viewGroup, false);
                return new QuestionViewHolder(v);
            case AppUpdateInfoViewHolder.APP_INFO_VIEW_TYPE:
                v = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.app_info_view_holder, viewGroup, false);
                return new AppUpdateInfoViewHolder(v);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, int i) {
        switch (viewHolder.getItemViewType()) {
            case QuestionViewHolder.QUESTION_VIEW_TYPE:
                ((QuestionViewHolder) viewHolder).bindQuestion(mItems.get(i));
                ((QuestionViewHolder) viewHolder).itemView.findViewById(R.id.accept_btn)
                        .setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ((QuestionViewHolder) viewHolder).answer();
                                ParseObject guestAnswerObject = new ParseObject("Guests");
                                guestAnswerObject.put("name",
                                        ((InvitationApplication) mActivity.getApplication())
                                                .getGuest()
                                                .getName());
                                ((QuestionViewHolder) viewHolder).answer();
                                guestAnswerObject
                                        .put("answer",
                                                ((QuestionViewHolder) viewHolder).getQuestion()
                                                        .getAnswer());
                                guestAnswerObject.put("question",
                                        ((QuestionViewHolder) viewHolder).getQuestion()
                                                .getQuestionString());
                                guestAnswerObject
                                        .put("create",
                                                Calendar.getInstance(TimeZone.getDefault())
                                                        .getTime());
                                guestAnswerObject.saveEventually(new SaveCallback() {
                                    @Override
                                    public void done(ParseException e) {
                                        Toast.makeText(mActivity,
                                                "Отправлено!\n" + ((QuestionViewHolder) viewHolder)
                                                        .getQuestion()
                                                        .getQuestionString() + ":\n"
                                                        + ((QuestionViewHolder) viewHolder)
                                                        .getQuestion()
                                                        .getAnswer(), Toast.LENGTH_LONG).show();
                                    }
                                });
                            }
                        });

                break;
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size() + 1;
    }


}
