package wedding.karpov.invitation;

import android.app.Application;

import wedding.karpov.invitation.guests.Guest;

/**
 * Created by arsenitykarpov on 14/01/15.
 */
public class InvitationApplication extends Application {

    private Guest mGuest;

    public void setGuest(Guest guest) {
        mGuest = guest;
    }

    public Guest getGuest() {
        return mGuest;
    }

}
