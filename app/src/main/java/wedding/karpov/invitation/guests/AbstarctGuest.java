package wedding.karpov.invitation.guests;

import android.content.Context;

/**
 * Created by arsenitykarpov on 14/01/15.
 */
public abstract class AbstarctGuest implements Guest {

    private Context mContext;

    protected AbstarctGuest(Context context) {
        mContext = context;
    }

    @Override
    public String getWelcomeText() {
        String text = String.format("%s \n %s", getName(), mContext.getString(getResourceId()));
        return text;
    }

    protected abstract int getResourceId();

}
