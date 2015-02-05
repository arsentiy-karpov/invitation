package wedding.karpov.invitation.guests;

import android.content.Context;

/**
 * Created by akarpov on 2/5/15.
 */
public class MashaGuest extends AbstarctGuest {

    public MashaGuest(Context context) {
        super(context);
    }

    @Override
    public String getName() {
        return "Маша";
    }

    @Override
    public GuestType getType() {
        return GuestType.FRIEND;
    }

    @Override
    public GuestGender getGender() {
        return GuestGender.F;
    }
}