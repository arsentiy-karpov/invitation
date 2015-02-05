package wedding.karpov.invitation.guests;

import android.content.Context;

/**
 * Created by akarpov on 2/5/15.
 */
public class PolishkinGuest extends AbstarctGuest {

    public PolishkinGuest(Context context) {
        super(context);
    }

    @Override
    public String getName() {
        return "Артемий";
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