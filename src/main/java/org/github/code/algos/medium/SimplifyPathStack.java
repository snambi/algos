package org.github.code.algos.medium;

import java.util.Stack;

public class SimplifyPathStack {



    public String simplifyPath(String inputPath ){

        validateInput(inputPath);

        Stack<String> stack = new Stack<>();

        stack.push("/");

        int tokenbegin = 0;
        boolean tokenstarted = false;

        int i=1;
        while( i <inputPath.length() ){

            StringBuilder sb = new StringBuilder();
            boolean tokenComplete = false;
            while( !tokenComplete){
                char x = inputPath.charAt(i);
                if( isValidChar(x) ){

                    sb.append(x);

                    // get next char
                    char next = inputPath.charAt(i+1);

                    // check whether

                }else{
                    throw new IllegalArgumentException("Contain illegal character "+ x);
                }
            }

            i++;
        }

        return inputPath;
    }

    public boolean isValidChar(char c){
        // check whether it is '/'
        if( c == '/'){
            return true;
        }
        if( c == '.'){
            return true;
        }
        if( c >= 'a' && c <= 'z'){
            return true;
        }
        if( c >= 'A' && c <= 'Z' ){
            return true;
        }
        if( c >= '0' && c <= '9' ){
            return true;
        }

        return false;
    }

    private void validateInput( String path  ){

        if( path == null ){
            throw new IllegalArgumentException("Path cannot be null");
        }

        if( path.isEmpty() ){
            throw new IllegalArgumentException("Path cannot be empty");
        }

        if( path.length() > 3000 ){
            throw new IllegalArgumentException("Path cannot be longer than 3000");
        }

        if( path.charAt(0) !=  '/' ){
            throw new IllegalArgumentException("Path must have / at the beginning");
        }
    }

    public static void main(String[] args ){

    }
}
