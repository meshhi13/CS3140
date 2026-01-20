import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PritheeTest {

    @Test
    void sonnetVerseNotNullOrEmpty() {
        String verse = Prithee.getSonnetVerse();
        assertNotNull(verse);
        assertFalse(verse.isEmpty());
        assertTrue(verse.contains("Two households"));
    }

    @Test
    void arraysHaveSameLength() {
        String[] raw = Prithee.getSonnetArray();
        String[] cleaned = Prithee.getCleanedSonnetArray();

        assertNotNull(raw);
        assertNotNull(cleaned);
        assertEquals(raw.length, cleaned.length, "Raw and cleaned arrays should align by index");
        assertTrue(raw.length > 0, "Split should produce at least one word");
    }

    @Test
    void cleanedArrayIsLowercase() {
        for (String w : Prithee.getCleanedSonnetArray()) {
            assertEquals(w.toLowerCase(), w, "Cleaned word should be lowercase: " + w);
        }
    }

    @Test
    void cleanedArrayHasNoCommasOrPeriods() {
        for (String w : Prithee.getCleanedSonnetArray()) {
            assertFalse(w.contains(","), "Cleaned word should not contain commas: " + w);
            assertFalse(w.contains("."), "Cleaned word should not contain periods: " + w);
        }
    }

    @Test
    void rawAndCleanedAlignByIndex() {
        String[] raw = Prithee.getSonnetArray();
        String[] cleaned = Prithee.getCleanedSonnetArray();

        for (int i = 0; i < raw.length; i++) {
            String normalizedRaw = normalizeLikePrithee(raw[i]);
            assertEquals(normalizedRaw, cleaned[i],
                    "Mismatch at index " + i +
                            "\nraw = " + raw[i] +
                            "\nnormalizedRaw = " + normalizedRaw +
                            "\ncleaned = " + cleaned[i]);
        }
    }


    @Test
    void randomDigitProducesCorrectPrefixWords() {
        String[] raw = Prithee.getSonnetArray();

        int randomDigit = 5;  // deterministic test index
        StringBuilder expectedPrefix = new StringBuilder();

        for (int i = 0; i < randomDigit; i++) {
            expectedPrefix.append(raw[i]).append(" ");
        }

        String prefix = expectedPrefix.toString();
        assertEquals("Two households, both alike in ",
                prefix,
                "Prefix words before randomDigit are incorrect");
    }

    private static String normalizeLikePrithee(String w) {
        return w.replaceAll(",", "")
                .replaceAll("\\.", "")
                .toLowerCase();
    }
}
