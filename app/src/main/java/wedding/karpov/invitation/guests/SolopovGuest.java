package wedding.karpov.invitation.guests;

import android.content.Context;

/**
 * Created by akarpov on 2/5/15.
 */
public class SolopovGuest extends AbstarctGuest {

    public SolopovGuest(Context context) {
        super(context);
    }

    @Override
    public String getName() {
        return "Димка";
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