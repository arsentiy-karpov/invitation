package wedding.karpov.invitation.guests;

/**
 * Created by arsenitykarpov on 14/01/15.
 */
public interface Guest {

    public static enum GuestType {
        FRIEND,RELATIVE
    }

    public static enum GuestGender {
        M,F
    }

    String getName();

    GuestType getType();

    GuestGender getGender();

    CharSequence getWelcomeText();

    void approve(AbstarctGuest.OnApproveListener listener);

    boolean isApproved();
}
