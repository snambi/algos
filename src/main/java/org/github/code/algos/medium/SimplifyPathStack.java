package org.github.code.algos.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SimplifyPathStack {

    public String simplifyPath(String inputPath ){

        validateInput(inputPath);

        Stack<String> stack = new Stack<>();

        stack.push("/");

        int i=1;
        while( i <inputPath.length() ){

            StringBuilder token = new StringBuilder();
            boolean tokenComplete = false;
            while( !tokenComplete){
                char x = inputPath.charAt(i);
                if( isValidChar(x) ){

                    if( i == (inputPath.length() -1)  ){
                        token.append(x);
                        tokenComplete= true;
                        i++;
                        break;
                    }
                    // get next char
                    char next = inputPath.charAt(i+1);

                    // check whether "//"
                    if( x == '/' && next == '/'){
                        tokenComplete =true;
                        token.append(x);
                        i = i+2;
                        break;
                    }
                    if( x == '/' && next != '/'){
                        tokenComplete =true;
                        token.append(x);
                        i++;
                        break;
                    }

                    // check whether ".", "..", "..."
                    char n1 = inputPath.charAt(i+1);
                    char n2 = inputPath.charAt(i+1);
                    if( x == '.' && n1 == '.' && n2 != '.'){
                        // pop one dir back
                        stack.pop();
                        i = i+2;
                        tokenComplete =true;
                        break;
                    }
                    if( x == '.' && n1 != '.' && n2 != '.'){
                        // no op
                        i++;
                        tokenComplete =true;
                        break;
                    }
                    if( x == '.' && n1 == '.' && n2 == '.'){
                        token.append("...");
                        i = i+3;
                        tokenComplete =true;
                        break;
                    }

                    // check whether 'a..zA..Z0..9'
                    if( isAlhpaNumeric(x)){

                        i= i+1;
                        token.append(x);

                        char n = inputPath.charAt(i);
                        if( !isAlhpaNumeric(n)){
                            // break the loop
                            tokenComplete = true;
                            break;
                        }
                    }


                }else{
                    throw new IllegalArgumentException("Contain illegal character "+ x);
                }
            }

            stack.push(token.toString());
        }

        StringBuilder result = new StringBuilder();
        List<String> paths = new ArrayList<>();
        while( !stack.isEmpty() ){
            paths.add(stack.pop());
        }
        for( int j= (paths.size()-1) ; j>=0 ; j--){
            result.append(paths.get(j));
        }

        return result.toString();
    }

    public boolean isValidChar(char c) {
        // check whether it is '/'
        if (c == '/') {
            return true;
        }
        if (c == '.') {
            return true;
        }
        return isAlhpaNumeric(c);
    }

    public boolean isAlhpaNumeric(char c){
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
}
