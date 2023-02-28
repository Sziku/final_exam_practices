package hu.nive.ujratervezes.decoder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecoderTest {
    private Decoder decoder = new Decoder();
    @Test
    void testEmptyInput(){
        assertThrows(IllegalArgumentException.class, ()-> decoder.decode(null));
    }

    @Test
    void testEmptyArrayInput(){
        assertEquals("", decoder.decode(new int[]{}));
    }

    @Test
    void testOneLetterInput(){
        assertEquals("d", decoder.decode(new int[]{10}));
    }

    @Test
    void testOneWordWithSameLettersInput(){
        assertEquals("ddd", decoder.decode(new int[]{10,0,0}));
    }

    @Test
    void testOneWordVariousLettersInput(){
        assertEquals("delete", decoder.decode(new int[]{10,1,7,-7,15,-15}));
    }

    @Test
    void testOneWordVariousLettersWithUpperCaseLettersInput(){
        assertEquals("youAreDoingGreat", decoder.decode(new int[]{11,-10,6,-52,49,-13,-33,43,-6,5,-7,-32,43,-13,-4,19}));
    }

    @Test
    void testMultipleWordsInput(){
        assertEquals("Queen Of England", decoder.decode(new int[]{9,36,-16,0,9,-78,47,23,-70,37,41,-7,5,-11,13,-10}));
    }

}