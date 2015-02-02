package wedding.karpov.invitation.guests;

import android.content.Context;

import wedding.karpov.invitation.R;

/**
 * Created by arsenitykarpov on 14/01/15.
 */
public class UshakovaGuest extends AbstarctGuest {

    public UshakovaGuest(Context context) {
        super(context);
    }

    @Override
    public String getName() {
        return "Евгения";
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
