package wedding.karpov.invitation.guests;

import android.content.Context;

/**
 * Created by akarpov on 2/5/15.
 */
public class MaksimGuest extends AbstarctGuest {

    public MaksimGuest(Context context) {
        super(context);
    }

    @Override
    public String getName() {
        return "Максим";
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