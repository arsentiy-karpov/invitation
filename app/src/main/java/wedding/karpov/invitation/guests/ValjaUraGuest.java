package wedding.karpov.invitation.guests;

import android.content.Context;

/**
 * Created by akarpov on 2/5/15.
 */
public class ValjaUraGuest extends AbstarctGuest {

    public ValjaUraGuest(Context context) {
        super(context);
    }

    @Override
    public String getName() {
        return "Валентина и Юрий";
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