package wedding.karpov.invitation.guests;

import android.content.Context;

/**
 * Created by akarpov on 2/5/15.
 */
public class DashaUGuest extends AbstarctGuest {

    public DashaUGuest(Context context) {
        super(context);
    }

    @Override
    public String getName() {
        return "Даша";
    }

    @Override
    public GuestType getType() {
        return GuestType.RELATIVE;
    }

    @Override
    public GuestGender getGender() {
        return GuestGender.F;
    }
}