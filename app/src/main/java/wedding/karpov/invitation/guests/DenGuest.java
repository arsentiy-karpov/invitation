package wedding.karpov.invitation.guests;

import android.content.Context;

/**
 * Created by akarpov on 2/5/15.
 */
public class DenGuest extends AbstarctGuest {

    public DenGuest(Context context) {
        super(context);
    }

    @Override
    public String getName() {
        return "Денис";
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