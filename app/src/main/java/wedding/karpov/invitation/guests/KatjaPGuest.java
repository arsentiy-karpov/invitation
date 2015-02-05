package wedding.karpov.invitation.guests;

import android.content.Context;

/**
 * Created by arsenitykarpov on 05/02/15.
 */
public class KatjaPGuest extends AbstarctGuest {

    public KatjaPGuest(Context context) {
        super(context);
    }

    @Override
    public String getName() {
        return "Екатерина";
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