package wedding.karpov.invitation.guests;

import android.content.Context;

/**
 * Created by akarpov on 2/5/15.
 */
public class MamaPapaGuest extends AbstarctGuest {

    public MamaPapaGuest(Context context) {
        super(context);
    }

    @Override
    public String getName() {
        return "Татьяна и Дмитрий";
    }

    @Override
    public GuestType getType() {
        return GuestType.RELATIVE;
    }

    @Override
    public GuestGender getGender() {
        return GuestGender.P;
    }
}