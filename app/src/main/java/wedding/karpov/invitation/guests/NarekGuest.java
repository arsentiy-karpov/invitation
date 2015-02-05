package wedding.karpov.invitation.guests;

import android.content.Context;

/**
 * Created by akarpov on 2/5/15.
 */
public class NarekGuest extends AbstarctGuest {

    public NarekGuest(Context context) {
        super(context);
    }

    @Override
    public String getName() {
        return "Нарек";
    }

    @Override
    public Guest.GuestType getType() {
        return Guest.GuestType.FRIEND;
    }

    @Override
    public Guest.GuestGender getGender() {
        return Guest.GuestGender.M;
    }
}