package wedding.karpov.invitation.guests.helpers;

import android.content.Context;

import wedding.karpov.invitation.guests.*;

/**
 * Created by arsenitykarpov on 14/01/15.
 */
public class GuestFactory {

    public static Guest getGuestByCode(String code, Context context) {
        switch (code) {
            case "":
                return new UshakovaGuest(context);
            case "shap":
                return new ShapiroGuest(context);
//            case "shap":
//                return new AbramovaGuest(context);
//            case "":
//                return new AnishenkoGuest(context);
//            case "shap":
//                return new BiduljaGuest(context);
//            case "shap":
//                return new DanilshenkoGuest(context);
//            case "":
//                return new DanjaGuest(context);
//            case "shap":
//                return new DashaDGuest(context);
//            case "shap":
//                return new EldarGuest(context);
//            case "":
//                return new KarpovGuest(context);
//            case "shap":
//                return new KazashenkoGuest(context);
//            case "shap":
//                return new KolubakinGuest(context);
//            case "":
//                return new KristinaGuest(context);
//            case "shap":
//                return new MashaGuest(context);
//            case "shap":
//                return new NarekGuest(context);
//            case "":
//                return new NickGuest(context);
//            case "shap":
//                return new NikisGuest(context);
//            case "shap":
//                return new NixanGuest(context);
//            case "":
//                return new PolishkinGuest(context);
//            case "shap":
//                return new PopovizkajaGuest(context);
//            case "shap":
//                return new RomaGuest(context);
//            case "":
//                return new SolopovGuest(context);
//            case "shap":
//                return new TvardovskajaGuest(context);
//            case "shap":
//                return new VerchinovGuest(context);
//            case "":
//                return new VityaGuest(context);
//            case "shap":
//                return new ZeitlinGuest(context);
//            case "shap":
//                return new ZinjaGuest(context);
//            case "shap":
//                return new JasjaSeregaGuest(context);
//            case "":
//                return new NadjaLeshaGuest(context);
//            case "shap":
//                return new MamaPapaGuest(context);
//            case "shap":
//                return new MamaUGuest(context);
//            case "shap":
//                return new IgorOlgaGuest(context);
//            case "shap":
//                return new PapaUGuest(context);
//            case "shap":
//                return new LesjaGuest(context);
//            case "shap":
//                return new AnjaGuest(context);
//            case "shap":
//                return new SashuriniGuest(context);
//            case "shap":
//                return new LubaGuest(context);
//            case "shap":
//                return new OksanaGuest(context);
//            case "shap":
//                return new ValjaUraGuest(context);
//            case "shap":
//                return new MaksimGuest(context);
//            case "shap":
//                return new SergejGuest(context);
//            case "shap":
//                return new LenaGuest(context);
//            case "shap":
//                return new VovaGuest(context);
//            case "shap":
//                return new DashaUGuest(context);
        }
        return null;
    }

}
