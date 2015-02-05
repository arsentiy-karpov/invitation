package wedding.karpov.invitation.guests;

import android.content.Context;

/**
 * Created by akarpov on 2/5/15.
 */
public class DanilshenkoGuest extends AbstarctGuest {

    public DanilshenkoGuest(Context context) {
        super(context);
    }

    @Override
    public String getName() {
        return "Сергей";
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