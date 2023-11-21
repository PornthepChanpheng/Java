public class PostFixDemo {
    public static void main(String args[]) {
        String input = "1*(2+3)";
        InfixToPostfix translator = new InfixToPostfix(input);
        String output = translator.translate();
        System.out.println("Infix expression is: " + input);
        System.out.println("Postfix expression is: " + output);

        PostFixParser parser = new PostFixParser(output);
        System.out.println("Result is: " + parser.evaluate());
    }
}