package wedding.karpov.invitation.guests;

import android.content.Context;

/**
 * Created by akarpov on 2/5/15.
 */
public class PopovizkajaGuest extends AbstarctGuest {

    public PopovizkajaGuest(Context context) {
        super(context);
    }

    @Override
    public String getName() {
        return "Дашуля";
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