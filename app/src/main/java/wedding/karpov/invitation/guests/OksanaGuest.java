package wedding.karpov.invitation.guests;

import android.content.Context;

/**
 * Created by akarpov on 2/5/15.
 */
public class OksanaGuest extends AbstarctGuest {

    public OksanaGuest(Context context) {
        super(context);
    }

    @Override
    public String getName() {
        return "Оксана";
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