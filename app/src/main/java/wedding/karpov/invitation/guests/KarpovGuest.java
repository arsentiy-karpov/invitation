package wedding.karpov.invitation.guests;

import android.content.Context;

/**
 * Created by akarpov on 2/5/15.
 */
public class KarpovGuest extends AbstarctGuest {

    public KarpovGuest(Context context) {
        super(context);
    }

    @Override
    public String getName() {
        return "Павел";
    }

    @Override
    public GuestType getType() {
        return GuestType.FRIEND;
    }

    @Override
    public GuestGender getGender() {
        return GuestGender.M;
    }
}