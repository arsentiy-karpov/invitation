package wedding.karpov.invitation.guests;

import android.content.Context;

/**
 * Created by akarpov on 2/5/15.
 */
public class AnjaGuest extends AbstarctGuest {

    public AnjaGuest(Context context) {
        super(context);
    }

    @Override
    public String getName() {
        return "Анна";
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