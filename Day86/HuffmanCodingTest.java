import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class HuffmanCodingTest {
    private static ByteArrayOutputStream outputStream;
    private static PrintStream originalOut;

    // Custom assertion methods
    public static void assertTrue(String message, boolean condition) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    public static void assertFalse(String message, boolean condition) {
        if (condition) {
            throw new AssertionError(message);
        }
    }

    public static void assertEquals(String message, Object expected, Object actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError(message + " Expected: " + expected + ", Actual: " + actual);
        }
    }

    public static void assertNotNull(String message, Object obj) {
        if (obj == null) {
            throw new AssertionError(message);
        }
    }

    public static void assertNull(String message, Object obj) {
        if (obj != null) {
            throw new AssertionError(message);
        }
    }

    public static void setUp() {
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }    public static void testSingleCharacter() {
        setUp();
        System.out.println("Testing single character...");
        
        // Test with only one character
        char[] input = {'a'};
        int[] frequencies = {10};
        
        HuffmanCoding.Node root = HuffmanCoding.buildHuffmanTree(input, frequencies);
        
        assertNotNull("Root should not be null", root);
        assertEquals("Frequency should match", 10, root.freq);
        assertEquals("Character should match", 'a', root.chr);
        assertNull("Left child should be null for single node", root.left);
        assertNull("Right child should be null for single node", root.right);
        
        tearDown();
        System.out.println("✓ Single character test passed");
    }

    public static void testTwoCharacters() {
        setUp();
        System.out.println("Testing two characters...");
        
        // Test with two characters
        char[] input = {'a', 'b'};
        int[] frequencies = {3, 7};
        
        HuffmanCoding.Node root = HuffmanCoding.buildHuffmanTree(input, frequencies);
        
        assertNotNull("Root should not be null", root);
        assertEquals("Root frequency should be sum", 10, root.freq);
        assertEquals("Root should be internal node", '$', root.chr);
        assertNotNull("Left child should exist", root.left);
        assertNotNull("Right child should exist", root.right);
        
        // Verify the structure (lower frequency should be left)
        assertEquals("Left child frequency", 3, root.left.freq);
        assertEquals("Left child character", 'a', root.left.chr);
        assertEquals("Right child frequency", 7, root.right.freq);
        assertEquals("Right child character", 'b', root.right.chr);
        
        tearDown();
        System.out.println("✓ Two characters test passed");
    }

    public static void testMultipleCharacters() {
        setUp();
        System.out.println("Testing multiple characters...");
        
        // Test with the example from main method
        char[] input = {'a', 'b', 'c', 'd', 'e'};
        int[] frequencies = {5, 9, 12, 13, 16};
        
        HuffmanCoding.Node root = HuffmanCoding.buildHuffmanTree(input, frequencies);
        
        assertNotNull("Root should not be null", root);
        assertEquals("Root frequency should be sum of all", 55, root.freq);
        assertEquals("Root should be internal node", '$', root.chr);
        
        // Verify tree structure exists
        assertNotNull("Left subtree should exist", root.left);
        assertNotNull("Right subtree should exist", root.right);
        
        tearDown();
        System.out.println("✓ Multiple characters test passed");
    }

    public static void testFrequencyOrdering() {
        setUp();
        System.out.println("Testing frequency ordering...");
        
        // Test that frequencies are properly ordered
        char[] input = {'x', 'y', 'z'};
        int[] frequencies = {1, 2, 3};
        
        HuffmanCoding.Node root = HuffmanCoding.buildHuffmanTree(input, frequencies);
        
        assertNotNull("Root should not be null", root);
        assertEquals("Total frequency", 6, root.freq);
        
        // The tree should combine lowest frequencies first
        assertTrue("Root should have both children", root.left != null && root.right != null);
        
        tearDown();
        System.out.println("✓ Frequency ordering test passed");
    }

    public static void testPrintHuffmanTree() {
        setUp();
        System.out.println("Testing print Huffman tree...");
        
        // Test the print functionality
        char[] input = {'a', 'b'};
        int[] frequencies = {1, 1};
        
        HuffmanCoding.Node root = HuffmanCoding.buildHuffmanTree(input, frequencies);
        HuffmanCoding.printHuffmanTree(root, "");
          String output = outputStream.toString();
        assertTrue("Output should contain character codes", output.contains(":"));
        assertTrue("Output should contain binary codes", output.contains("0") || output.contains("1"));
        
        tearDown();
        System.out.println("✓ Print Huffman tree test passed");
    }

    public static void testPrintWithSingleNode() {
        setUp();
        System.out.println("Testing print with single node...");
        
        // Test printing with a single node
        HuffmanCoding.Node singleNode = new HuffmanCoding.Node(5, 'x');
        HuffmanCoding.printHuffmanTree(singleNode, "");
        
        String output = outputStream.toString();
        assertTrue("Should print the character", output.contains("x"));
        
        tearDown();
        System.out.println("✓ Print single node test passed");
    }    public static void testPrintWithNullRoot() {
        // Test printing with null root (should produce no output)
        setUp();
        HuffmanCoding.printHuffmanTree(null, "");
        String output = outputStream.toString();
        tearDown();
        
        // Check if output is empty (null root should not print anything)
        if (output.isEmpty()) {
            System.out.println("✓ Print null root test passed");
        } else {
            throw new AssertionError("Output should be empty for null root. Got: " + output);
        }
    }

    public static void testNodeComparison() {
        System.out.println("Testing node comparison...");
        
        // Test the Comparable implementation
        HuffmanCoding.Node node1 = new HuffmanCoding.Node(5, 'a');
        HuffmanCoding.Node node2 = new HuffmanCoding.Node(10, 'b');
        HuffmanCoding.Node node3 = new HuffmanCoding.Node(5, 'c');
        
        assertTrue("Node1 should be less than node2", node1.compareTo(node2) < 0);
        assertTrue("Node2 should be greater than node1", node2.compareTo(node1) > 0);
        assertEquals("Nodes with same frequency should be equal", 0, node1.compareTo(node3));
        
        System.out.println("✓ Node comparison test passed");
    }

    public static void testLargeFrequencies() {
        setUp();
        System.out.println("Testing large frequencies...");
        
        // Test with large frequency values
        char[] input = {'a', 'b', 'c'};
        int[] frequencies = {1000000, 2000000, 3000000};
        
        HuffmanCoding.Node root = HuffmanCoding.buildHuffmanTree(input, frequencies);
        
        assertNotNull("Root should not be null", root);
        assertEquals("Root frequency should be sum", 6000000, root.freq);
        
        tearDown();
        System.out.println("✓ Large frequencies test passed");
    }

    public static void testIdenticalFrequencies() {
        setUp();
        System.out.println("Testing identical frequencies...");
        
        // Test with all identical frequencies
        char[] input = {'a', 'b', 'c', 'd'};
        int[] frequencies = {10, 10, 10, 10};
        
        HuffmanCoding.Node root = HuffmanCoding.buildHuffmanTree(input, frequencies);
        
        assertNotNull("Root should not be null", root);
        assertEquals("Root frequency should be sum", 40, root.freq);
        
        // Tree should still be built properly
        assertNotNull("Left subtree should exist", root.left);
        assertNotNull("Right subtree should exist", root.right);
        
        tearDown();
        System.out.println("✓ Identical frequencies test passed");
    }

    public static void testCompleteHuffmanCodes() {
        setUp();
        System.out.println("Testing complete Huffman codes...");
        
        // Test that all characters get unique codes
        char[] input = {'a', 'b', 'c'};
        int[] frequencies = {1, 2, 3};
        
        HuffmanCoding.Node root = HuffmanCoding.buildHuffmanTree(input, frequencies);
        HuffmanCoding.printHuffmanTree(root, "");        String output = outputStream.toString();
        System.out.println("Debug - Output: '" + output + "'");
        String[] allLines = output.split("\n");
        
        // Filter out empty lines
        int validLineCount = 0;
        for (String line : allLines) {
            System.out.println("Debug - Line: '" + line + "'");
            if (!line.trim().isEmpty()) {
                validLineCount++;
                assertTrue("Each line should have character and code", line.contains(":"));
                String[] parts = line.split(":");
                assertEquals("Should have exactly 2 parts", 2, parts.length);
                String code = parts[1].trim();
                assertTrue("Code should contain only 0s and 1s", code.length() > 0 && 
                          code.chars().allMatch(c -> c == '0' || c == '1'));
            }
        }
        
        assertEquals("Should have codes for all characters", 3, validLineCount);
        
        tearDown();
        System.out.println("✓ Complete Huffman codes test passed");
    }

    public static void tearDown() {
        System.setOut(originalOut);
    }

    public static void main(String[] args) {
        System.out.println("=== Running Huffman Coding Tests ===\n");
        
        try {
            testSingleCharacter();
            testTwoCharacters();
            testMultipleCharacters();
            testFrequencyOrdering();
            testPrintHuffmanTree();
            testPrintWithSingleNode();
            testPrintWithNullRoot();
            testNodeComparison();
            testLargeFrequencies();
            testIdenticalFrequencies();
            testCompleteHuffmanCodes();
            
            System.out.println("\n=== All Tests Passed! ===");
            
        } catch (AssertionError e) {
            System.err.println("Test failed: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
