package hu.nive.ujratervezes.decoder;

public class Decoder {
    public String decode(int[] code) {

        if (code == null) throw new IllegalArgumentException();
        if (code.length == 0) return "";

        int letter = code[0] * code[0];

        StringBuilder decodeText = new StringBuilder();
        decodeText.append((char) letter);

        for (int i = 1; i < code.length; i++) {
            letter += code[i];
            decodeText.append((char)(letter));
        }

        return decodeText.toString();
    }
}
