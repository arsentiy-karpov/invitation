package wedding.karpov.invitation.guests;

import android.content.Context;

/**
 * Created by akarpov on 2/5/15.
 */
public class KristinaGuest extends AbstarctGuest {

    public KristinaGuest(Context context) {
        super(context);
    }

    @Override
    public String getName() {
        return "Кристина";
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