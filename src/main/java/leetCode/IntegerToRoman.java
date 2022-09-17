package leetCode;

public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(36));

        for (int i = 1; i < 101; i++) {
            System.out.println(intToRoman(i));
        }
    }


    static public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder("");

        for (RomanDict romanVal : RomanDict.values()) {
            for (int i = 0; i < romanVal.getMaxPossibleOccuranceQuantity(); i++) {
                if (romanVal.getNumber() > num) {
                    break;
                }

                num -= romanVal.getNumber();
                roman.append(romanVal.getSignature());
            }

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

        private final int maxPossibleOccuranceQuantity;

        RomanDict(int number, String signature) {
            this.number = number;
            this.signature = signature;
            maxPossibleOccuranceQuantity = signature.length() == 1 ? 3 : 1;
        }

        public int getNumber() {
            return number;
        }

        public String getSignature() {
            return signature;
        }

        public int getMaxPossibleOccuranceQuantity() {
            return maxPossibleOccuranceQuantity;
        }
    }

}
