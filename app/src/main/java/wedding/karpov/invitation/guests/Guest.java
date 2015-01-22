package wedding.karpov.invitation.guests;

/**
 * Created by arsenitykarpov on 14/01/15.
 */
public interface Guest {

    String getName();

    CharSequence getWelcomeText();

    void approve(AbstarctGuest.OnApproveListener listener);

    boolean isApproved();
}
