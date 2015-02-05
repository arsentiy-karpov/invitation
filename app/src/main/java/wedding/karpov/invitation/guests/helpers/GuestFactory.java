package wedding.karpov.invitation.guests.helpers;

import android.content.Context;

import wedding.karpov.invitation.guests.*;

/**
 * Created by arsenitykarpov on 14/01/15.
 */
public class GuestFactory {

    public static Guest getGuestByCode(String code, Context context) {
        switch (code) {
            case "ушак":
                return new UshakovaGuest(context);
            case "debug":
                return new TestGuest(context);
            case "sapndance":
                return new ShapiroGuest(context);
            case "hellokitty":
                return new AbramovaGuest(context);
            case "малаша":
                return new AnishenkoGuest(context);
            case "хоббит":
                return new BiduljaGuest(context);
            case "путейский":
                return new DanilshenkoGuest(context);
            case "песчанка":
                return new DanjaGuest(context);
            case "душечка":
                return new DashaDGuest(context);
            case "кексик":
                return new EldarGuest(context);
            case "кашапарков":
                return new KarpovGuest(context);
            case "шапкобородыйсороконожк":
                return new KazashenkoGuest(context);
            case "выкачалкагитаровна":
                return new KolubakinGuest(context);
            case "коктейльмикс":
                return new KristinaGuest(context);
            case "шасси":
                return new MashaGuest(context);
            case "американбой":
                return new NarekGuest(context);
            case "узбекостезис":
                return new NickGuest(context);
            case "жальайфон":
                return new NikisGuest(context);
            case "пизданет":
                return new NixanGuest(context);
            case "килт":
                return new PolishkinGuest(context);
            case "дерзкаябулочка":
                return new PopovizkajaGuest(context);
            case "гогольпетров":
                return new RomaGuest(context);
            case "пакетированный":
                return new SolopovGuest(context);
            case "улыбкалюба":
                return new TvardovskajaGuest(context);
            case "бебехович":
                return new VerchinovGuest(context);
            case "крабоваяпалочка":
                return new VityaGuest(context);
            case "куриныйзоб":
                return new ZeitlinGuest(context);
            case "рок":
                return new ZinjaGuest(context);
            case "гудеж":
                return new KatjaPGuest(context);
            case "конвертикскартинкой":
                return new DenGuest(context);
            case "луша":
                return new JasjaSeregaGuest(context);
            case "дорама":
                return new NadjaLeshaGuest(context);
            case "родителидома":
                return new MamaPapaGuest(context);
            case "плюшка":
                return new MamaUGuest(context);
            case "бебехово":
                return new IgorOlgaGuest(context);
            case "мартышка":
                return new PapaUGuest(context);
            case "терабития":
                return new LesjaGuest(context);
            case "нарния":
                return new AnjaGuest(context);
            case "карпжество":
                return new SashuriniGuest(context);
            case "пляски":
                return new LubaGuest(context);
            case "пьянкагулянка":
                return new OksanaGuest(context);
            case "валентинка":
                return new ValjaUraGuest(context);
            case "гульба":
                return new MaksimGuest(context);
            case "свадьба":
                return new SergejGuest(context);
            case "дедовквас":
                return new LenaDashaGuest(context);
            case "грибник":
                return new VovaGuest(context);
        }
        return null;
    }

}
