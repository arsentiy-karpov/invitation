package wedding.karpov.invitation.guests;

import android.content.Context;

/**
 * Created by akarpov on 2/5/15.
 */
public class TestGuest extends AbstarctGuest {

    public TestGuest(Context context) {
        super(context);
    }

    @Override
    public String getName() {
        return "Debug";
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