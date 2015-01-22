package wedding.karpov.invitation;

import com.parse.Parse;
import com.parse.ParseInstallation;

import android.app.Application;

import wedding.karpov.invitation.guests.Guest;

/**
 * Created by arsenitykarpov on 14/01/15.
 */
public class InvitationApplication extends Application {

    private Guest mGuest;

    @Override
    public void onCreate() {
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "SzRF4OTakYGgJrm8iOEMb3f5diRpu6DqeZui3TQn",
                "jmstGxScVgEyw2cQWxF59Vdg2ru97b16itrh0Uvu");
        ParseInstallation.getCurrentInstallation().saveInBackground();
    }

    public void setGuest(Guest guest) {
        mGuest = guest;
    }

    public Guest getGuest() {
        return mGuest;
    }

}
