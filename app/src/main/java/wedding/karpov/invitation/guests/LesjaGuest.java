package wedding.karpov.invitation.guests;

import android.content.Context;

/**
 * Created by akarpov on 2/5/15.
 */
public class LesjaGuest extends AbstarctGuest {

    public LesjaGuest(Context context) {
        super(context);
    }

    @Override
    public String getName() {
        return "Александра";
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