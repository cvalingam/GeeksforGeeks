import java.util.*;

class Solution {
    // Function to check if brackets are balanced or not.
    static boolean ispar(String x) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < x.length(); i++) {
            char ch = x.charAt(i);

            if (st.isEmpty() || ch == '(' || ch == '{' || ch == '[')
                st.push(ch);
            else {
                if ((st.peek() == '(' && ch == ')') || (st.peek() == '{' && ch == '}')
                        || (st.peek() == '[' && ch == ']'))
                    st.pop();
                else
                    st.push(ch);
            }
        }

        return st.isEmpty();
    }
}
