public class InfixToPostfix {
    private Stack stack;
    private String input = "";
    private String output = "";

    public InfixToPostfix(String input) {
        this.input = input;
        stack = new Stack(input.length());
    }

    public String translate() {
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '+':
                case '-':
                    gotOperator(ch, 1);
                    break;
                case '*':
                case '/':
                    gotOperator(ch, 2);
                    break;
                case '(':
                    stack.push(ch);
                    break;
                case ')':
                    gotParenthesis(ch);
                    break;
                default:
                    output = output + ch;
                    break;
            }
        }

        while (!stack.isEmpty()) {
            output = output + (char) stack.pop();
        }

        return output;
    }

    // got operator from input
    public void gotOperator(char operator, int precedence) {
        while (!stack.isEmpty()) {
            char prevOperator = (char) stack.pop();
            if (prevOperator == '(') {
                stack.push(prevOperator);
                break;
            } else {
                int precedence1;
                if (prevOperator == '+' || prevOperator == '-') {
                    precedence1 = 1;
                } else {
                    precedence1 = 2;
                }

                if (precedence1 < precedence) {
                    stack.push(Character.getNumericValue(prevOperator));
                    break;
                } else {
                    output = output + prevOperator;
                }
            }
        }
        stack.push(operator);
    }

    // got operator from input
    public void gotParenthesis(char parenthesis) {
        while (!stack.isEmpty()) {
            char ch = (char) stack.pop();
            if (ch == '(') {
                break;
            } else {
                output = output + ch;
            }
        }
    }
}