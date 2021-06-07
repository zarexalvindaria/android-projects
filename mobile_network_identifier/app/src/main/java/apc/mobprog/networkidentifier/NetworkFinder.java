package apc.mobprog.networkidentifier;

import android.annotation.SuppressLint;

public class NetworkFinder extends MainActivity {
    static String setPrefixValue;
    static String findNetwork;


    // Action of the "Determine Network" Button -- Determines Network
    protected static void findNetwork(String prefix) {
        String[] GlobeTM = {"0905", "0906", "0915", "0916", "0917", "0926", "0927", "0935", "0936",
                "0937", "0945", "0953", "0954", "0955", "0956", "0965", "0966", "0967", "0975",
                "0977", "0978", "0979", "0995", "0996", "0997", "+63905", "+63906", "+63915",
                "+63916", "+63917", "+63926", "+63927", "+63935", "+63936", "+63937",
                "+63945", "+63953", "+63954", "+63955", "+63956", "+63965", "+63966", "+63967",
                "+63975", "+63977", "+63978", "+63979", "+63995", "+63996", "+63997",};

        String[] TNT = {"0907", "0909", "0910", "0912", "0930", "0938", "0946", "0948", "0950",
                "+63907", "+63909", "+63910", "+63912", "+63930", "+63938", "+63946",
                "+63948", "+63950"};
        String[] Smart = {"0908", "0918", "0919", "0920", "0921", "0928", "0929", "0939", "0947",
                "0949", "0951", "0961", "0998", "0999", "+63908", "+63918", "+63919", "+63920",
                "+63921", "+63928", "+63929", "+63939", "+63947", "+63949", "+63951", "+63961",
                "+63998", "+63999",};
        String[] Sun = {"0922", "0923", "0924", "0925", "0931", "0932", "0933", "0934", "0940",
                "0941", "0942", "0943", "0973", "0974", "+63922", "+63923", "+63924", "+63925",
                "+63931", "+63932", "+63933", "+63934", "+63940", "+63941", "+63942", "+63943",
                "+63973", "+63974",};
        String[] GlobePP = {"09173", "09175", "09176", "09178", "09253", "09255", "09256", "09257",
                "09258", "+639173", "+639175", "+639176", "+639178", "+639253", "+639255",
                "+639256", "+639257", "+639258",};
        int prefLength = prefix.length();

        if (prefLength < MINDIGIT) { // Shows incomplete number if number is too short
            findNetwork = "INCOMPLETE!";
        } else if (prefLength == 4) {
            if (prefix.substring(0, 4).equals("0817")) {
                findNetwork = "GLOBE";
            }
            for (String s : GlobeTM)
            /* for (int i = 0; i < GlobeTM.length; i++) {  // Original format before enhancement
                if (prefix.equals(GlobeTM[i])) {
                    findNetwork = "GLOBE/TM";
                    break;
            } */
                if (prefix.substring(0, 4).equals(s)) {
                    findNetwork = "GLOBE/TM";
                    break;
                }
            for (String s : TNT)
                if (prefix.substring(0, 4).equals(s)) {
                    findNetwork = "TNT";
                    break;
                }
            for (String s : Smart)
                if (prefix.substring(0, 4).equals(s)) {
                    findNetwork = "SMART";
                    break;
                }

            for (String s : Sun)
                if (prefix.substring(0, 4).equals(s)) {
                    findNetwork = "SUN";
                    break;
                }
        } else if (prefLength == 5) {
            if (prefix.substring(0, 4).equals("0817")) {
                findNetwork = "GLOBE";
            } else {
                invalidateNetwork();
            }
            for (String s : GlobeTM)
                if (prefix.substring(0, 4).equals(s)) {
                    findNetwork = "GLOBE/TM";
                    break;
                }
            for (String s : TNT)
                if (prefix.substring(0, 4).equals(s)) {
                    findNetwork = "TNT";
                    break;
                }
            for (String s : Smart)
                if (prefix.substring(0, 4).equals(s)) {
                    findNetwork = "SMART";
                    break;
                }

            for (String s : Sun)
                if (prefix.substring(0, 4).equals(s)) {
                    findNetwork = "SUN";
                    break;
                }
            for (String s : GlobePP)
                if (prefix.substring(0, 5).equals(s)) {
                    findNetwork = "GLOBE POSTPAID";
                    break;
                }
        } else if (prefLength == 6) {
            if (prefix.substring(0, 6).equals("+63817")) {
                findNetwork = "GLOBE";
            } else {
                invalidateNetwork();
            }
            for (String s : GlobeTM)
                if ((prefix.substring(0, 4).equals(s)) || (prefix.substring(0, 6).equals(s))) {
                    findNetwork = "GLOBE/TM";
                    break;
                }
            for (String s : TNT)
                if ((prefix.substring(0, 4).equals(s)) || (prefix.substring(0, 6).equals(s))) {
                    findNetwork = "TNT";
                    break;
                }

            for (String s : Smart)
                if ((prefix.substring(0, 4).equals(s)) || (prefix.substring(0, 6).equals(s))) {
                    findNetwork = "SMART";
                    break;
                }

            for (String s : Sun)
                if ((prefix.substring(0, 4).equals(s)) || (prefix.substring(0, 6).equals(s))) {
                    findNetwork = "SUN";
                    break;
                }
            for (String s : GlobePP)
                if (prefix.substring(0, 5).equals(s)) {
                    findNetwork = "GLOBE POSTPAID";
                    break;
                }
        } else if (prefLength == 7) {
            if (prefix.substring(0, 6).equals("+63817")) {
                findNetwork = "GLOBE";
            } else {
                invalidateNetwork();
            }
            for (String s : GlobeTM)
                if ((prefix.substring(0, 4).equals(s)) || (prefix.substring(0, 6).equals(s))) {
                    findNetwork = "GLOBE/TM";
                    break;
                }
            for (String s : TNT)
                if ((prefix.substring(0, 4).equals(s)) || (prefix.substring(0, 6).equals(s))) {
                    findNetwork = "TNT";
                    break;
                }
            for (String s : Smart)
                if ((prefix.substring(0, 4).equals(s)) || (prefix.substring(0, 6).equals(s))) {
                    findNetwork = "SMART";
                    break;
                }
            for (String s : Sun)
                if ((prefix.substring(0, 4).equals(s)) || (prefix.substring(0, 6).equals(s))) {
                    findNetwork = "SUN";
                    break;
                }
            for (String s : GlobePP)
                if ((prefix.substring(0, 5).equals(s)) || (prefix.substring(0, 7).equals(s))) {
                    findNetwork = "GLOBE POSTPAID";
                    break;
                }
        } else {
            invalidateNetwork();
        }
    }

    @SuppressLint("SetTextI18n")
    // Sets the prefix value
    protected static void setPrefixValue(String pref, int prefixValue) {
        NetworkFinder.setPrefixValue = pref + prefixValue;
    }


//    public void determineFourChar() {
//            if (prefix.substring(0,4).equals("0817")) findNetwork = "GLOBE";
//
//            for (String s : GlobeTM)
//            /* for (int i = 0; i < GlobeTM.length; i++) {  // Original format before enhancement
//                if (prefix.equals(GlobeTM[i])) {
//                    findNetwork = "GLOBE/TM";
//                    break;
//            } */
//                if (prefix.substring(0,4).equals(s)) {
//                    findNetwork = "GLOBE/TM";
//                    break;
//            for (String s : TNT)
//                if (prefix.substring(0,4).equals(s)) {
//                    findNetwork = "TNT";
//                    break;
//                }
//            for (String s : Smart)
//                if (prefix.substring(0,4).equals(s)) {
//                    findNetwork = "SMART";
//                    break;
//                }
//
//            for (String s : Sun)
//                if (prefix.substring(0,4).equals(s)) {
//                    findNetwork = "SUN";
//                    break;
//                }
//        }

    public static void invalidateNetwork() {
        findNetwork = "INVALID!";
    }
}