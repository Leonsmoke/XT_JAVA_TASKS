package services.core;

import services.WriteService;
import services.interfaces.CollectionServiceInterface;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;

public class CheckBracketsService implements CollectionServiceInterface {
    Deque<Character> bracketStack = new ArrayDeque<>();
    @Override
    public void start() {
        if (checkStack()){
            System.out.println("The line is correct!");
        } else {
            System.out.println("The line is incorrect!");
        }
        
    }

    @Override
    public Collection getCollection() {
        return null;
    }

    private boolean checkStack(){
        System.out.println("Enter line with brackets:");
        String line = WriteService.getLine();
        boolean atLeastOneBracketFind = false;       // A variable that becomes true when at least one bracket is found

        for (Character symbol: line.toCharArray()
        ) {
            /*
             * If the character is an open bracket, then push it onto the stack
             * Otherwise, if the character is a closed bracket, then compare it with the last item on the stack.
             * If the type of brackets is the same, then delete the last character from the stack.
             * If the character is not a bracket, then the loop continues
             */
            if (isOpenBracket(symbol)){
                bracketStack.addFirst(symbol);
                atLeastOneBracketFind=true;
            } else if (isCloseBracket(symbol)){
                atLeastOneBracketFind=true;
                if (!bracketStack.isEmpty() && symbol-bracketStack.peekFirst()<=2){
                    bracketStack.pop();
                } else {
                    return false;
                }
            } else {
                continue;
            }
        }
        if (bracketStack.isEmpty() && atLeastOneBracketFind){
            return true;
        } else {
            return false;
        }
    }

    private boolean isOpenBracket(Character character){
        if (character==null){
            return false;
        }
        if (character=='(' || character=='[' || character=='{'){
            return true;
        }
        return false;
    }

    private boolean isCloseBracket(Character character){
        if (character==null){
            return false;
        }
        if (character==')' || character==']' || character=='}'){
            return true;
        }
        return false;
    }

}
