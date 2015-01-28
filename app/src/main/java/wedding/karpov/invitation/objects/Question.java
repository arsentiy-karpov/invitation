package wedding.karpov.invitation.objects;

import com.parse.ParseObject;

/**
 * Created by akarpov on 1/28/15.
 */
public class Question {

    public enum QuestionType {
        SIMPLE;
    }

    private QuestionType mType;

    private String mAnswer;

    private String mQuestion;

    public Question setQuestionString(String question) {
        mQuestion = question;
        return this;
    }

    public String getQuestionString() {
        return mQuestion;
    }

    public QuestionType getType() {
        return mType;
    }

    public String getAnswer() {
        return mAnswer;
    }

    public void setAnswer(String answer) {
        mAnswer = answer;
    }

    public ParseObject addToParseObjectList(ParseObject parseObject) {
//        parseObject.add("answer", getAnswer());
//        parseObject
        return parseObject;
    }

    public void setType(QuestionType type) {
        mType = type;
    }
}
