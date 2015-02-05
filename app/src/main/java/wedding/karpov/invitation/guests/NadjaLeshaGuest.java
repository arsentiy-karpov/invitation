package wedding.karpov.invitation.guests;

import android.content.Context;

/**
 * Created by akarpov on 2/5/15.
 */
public class NadjaLeshaGuest extends AbstarctGuest {

    public NadjaLeshaGuest(Context context) {
        super(context);
    }

    @Override
    public String getName() {
        return "Надя и Леша";
    }

    @Override
    public GuestType getType() {
        return GuestType.RELATIVE;
    }

    @Override
    public GuestGender getGender() {
        return GuestGender.M;
    }
}