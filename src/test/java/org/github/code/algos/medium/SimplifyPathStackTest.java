package org.github.code.algos.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimplifyPathStackTest {

    @Test()
    public void nullPathTest(){
        SimplifyPathStack sps = new SimplifyPathStack();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
           sps.simplifyPath(null);
        });
        assertEquals("Path cannot be null", exception.getMessage());
    }

    @Test()
    public void emptyPathTest(){
        SimplifyPathStack sps = new SimplifyPathStack();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            sps.simplifyPath("");
        });
        assertEquals("Path cannot be empty", exception.getMessage());
    }

    @Test()
    public void verylongPathTest(){
        SimplifyPathStack sps = new SimplifyPathStack();

        StringBuilder sb = new StringBuilder();

        for(int i=0; i< 301 ; i++ ){
            sb.append("/abcdefghi");
        }

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            sps.simplifyPath(sb.toString());
        });
        assertEquals("Path cannot be longer than 3000", exception.getMessage());
    }

    @Test
    public void illegalCharTest(){
        SimplifyPathStack sps = new SimplifyPathStack();

        assertEquals(sps.isValidChar('/'), true);
        assertEquals(sps.isValidChar('.'), true);
        assertEquals(sps.isValidChar('a'), true);
        assertEquals(sps.isValidChar('z'), true);
        assertEquals(sps.isValidChar('A'), true);
        assertEquals(sps.isValidChar('Z'), true);
        assertEquals(sps.isValidChar('0'), true);
        assertEquals(sps.isValidChar('9'), true);

        assertEquals(sps.isValidChar('5'), true);
        assertEquals(sps.isValidChar('g'), true);
        assertEquals(sps.isValidChar('U'), true);

        assertEquals(sps.isValidChar('*'), false);
    }

    @Test
    public void pathTests1(){
        SimplifyPathStack sps = new SimplifyPathStack();

        String inputPath = "/.../a/../b/c/../d/./";
        String path = sps.simplifyPath(inputPath);
        System.out.println("Input: "+ inputPath + ", Simplified: "+ path);

        assertNotNull(path);
    }

    @Test
    public void pathTests2(){
        SimplifyPathStack sps = new SimplifyPathStack();

        String inputPath = "/a/s";

        String path = sps.simplifyPath(inputPath);

        assertNotNull(path);
    }

    @Test
    public void pathTests3(){
        SimplifyPathStack sps = new SimplifyPathStack();

        String inputPath = "/...";
        String path = sps.simplifyPath(inputPath);

        System.out.println("Input: "+ inputPath + ", Simplified: "+ path);

        assertNotNull(path);
    }
}
