package wedding.karpov.invitation.guests;

import android.content.Context;

/**
 * Created by akarpov on 2/5/15.
 */
public class MamaUGuest extends AbstarctGuest {

    public MamaUGuest(Context context) {
        super(context);
    }

    @Override
    public String getName() {
        return "Татьяна";
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