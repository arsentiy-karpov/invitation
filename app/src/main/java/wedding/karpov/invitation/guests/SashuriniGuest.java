package wedding.karpov.invitation.guests;

import android.content.Context;

/**
 * Created by akarpov on 2/5/15.
 */
public class SashuriniGuest extends AbstarctGuest {

    public SashuriniGuest(Context context) {
        super(context);
    }

    @Override
    public String getName() {
        return "Александр, Мила и Ростик";
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