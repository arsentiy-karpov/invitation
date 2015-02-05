package wedding.karpov.invitation.guests;

import android.content.Context;

/**
 * Created by akarpov on 2/5/15.
 */
public class NikisGuest extends AbstarctGuest {

    public NikisGuest(Context context) {
        super(context);
    }

    @Override
    public String getName() {
        return "Никита";
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