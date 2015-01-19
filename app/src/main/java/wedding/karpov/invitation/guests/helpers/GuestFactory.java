package wedding.karpov.invitation.guests.helpers;

import android.content.Context;

import wedding.karpov.invitation.guests.Guest;
import wedding.karpov.invitation.guests.UshakovaGuest;

/**
 * Created by arsenitykarpov on 14/01/15.
 */
public class GuestFactory {

    public static Guest getGuestByCode(String code, Context context) {
        switch (code) {
            case "":
                return new UshakovaGuest(context);
        }
        return null;
    }

}
