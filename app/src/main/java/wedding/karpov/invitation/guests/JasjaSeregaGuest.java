package wedding.karpov.invitation.guests;

import android.content.Context;

/**
 * Created by akarpov on 2/5/15.
 */
public class JasjaSeregaGuest extends AbstarctGuest {

    public JasjaSeregaGuest(Context context) {
        super(context);
    }

    @Override
    public String getName() {
        return "Яся и Сережа";
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