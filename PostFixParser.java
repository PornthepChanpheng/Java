public class PostFixParser {
private Stack stack;
private String input;

public PostFixParser(String postfixExpression){
   input = postfixExpression;
   stack = new Stack(input.length());
}

   public int evaluate(){
      char ch;
      int firstOperand;
      int secondOperand;
      int tempResult;

      for(int i=0;i<input.length();i++){
         ch = input.charAt(i);

         if(ch >= '0' && ch <= '9'){
            stack.push(Character.getNumericValue(ch));
         }else{
            firstOperand = stack.pop();
            secondOperand = stack.pop();
            switch(ch){
               case '+':
                  tempResult = firstOperand + secondOperand;
                  break;
               case '-':
                  tempResult = firstOperand - secondOperand;
                  break;
               case '*':
                  tempResult = firstOperand * secondOperand;
                  break;
               case '/':
                  tempResult = firstOperand / secondOperand;
                  break;   
               default:
                  tempResult = 0;
            }
            stack.push(tempResult);
         }
      }
      return stack.pop();
   }       
}