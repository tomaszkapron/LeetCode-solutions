package leetCode;

public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(36));

        for (int i = 1; i < 101; i++) {
            System.out.println(intToRoman(i));
        }
    }


    static public String intToRoman(int num) {
        int counter = 0;
        StringBuilder roman = new StringBuilder("");

        for (RomanDict romanVal : RomanDict.values()) {
            while (romanVal.getNumber() <= num) {
                counter++;
                num -= romanVal.getNumber();
            }

            if (counter == 0) {
                continue;
            } else if (counter == 4) {
                roman.append(romanVal.getLetter());
                roman.append(romanVal.getHigherLetter());
            } else {
                for (int i = 0; i < counter; i++) {
                    roman.append(romanVal.getLetter());
                }
            }
            counter = 0;
            if (num == 0) {
                break;
            }

        }

        return roman.toString();
    }

    enum RomanDict {
        M(1000, "M"),
        CM(900, "CM"),
        D(500, "D"),
        CD(400, "CD"),
        C(100, "C"),
        XC(90, "XC"),
        L(50, "L"),
        XL(40, "XL"),
        X(10, "X"),
        IX(9, "IX"),
        V(5, "V"),
        IV(4, "IV"),

        I(1, "I");

        private final int number;
        private final String signature;

        RomanDict(int number, String letter) {
            this.number = number;
            this.signature = letter;
        }

        public int getNumber() {
            return number;
        }

        public String getLetter() {
            return signature;
        }

        public String getHigherLetter() {
            switch (this) {
                case D:
                    return RomanDict.M.getLetter();
                case C:
                    return RomanDict.D.getLetter();
                case L:
                    return RomanDict.C.getLetter();
                case X:
                    return RomanDict.L.getLetter();
                case V:
                    return RomanDict.X.getLetter();
                case I:
                    return RomanDict.V.getLetter();
                default:
                    return RomanDict.I.getLetter();
            }
        }
    }
}
