package wedding.karpov.invitation.guests;

import android.content.Context;

/**
 * Created by akarpov on 2/5/15.
 */
public class IgorOlgaGuest extends AbstarctGuest {

    public IgorOlgaGuest(Context context) {
        super(context);
    }

    @Override
    public String getName() {
        return "Игорь и Ольга";
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