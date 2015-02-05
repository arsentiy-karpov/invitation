package wedding.karpov.invitation.guests;

import android.content.Context;

/**
 * Created by akarpov on 2/5/15.
 */
public class VovaGuest extends AbstarctGuest {

    public VovaGuest(Context context) {
        super(context);
    }

    @Override
    public String getName() {
        return "Вова";
    }

    @Override
    public GuestType getType() {
        return GuestType.RELATIVE;
    }

    @Override
    public GuestGender getGender() {
        return GuestGender.M;
    }
}