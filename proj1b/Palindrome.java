public class Palindrome {
    /* convert the given String to Deque */
    public Deque<Character> wordToDeque(String word) {
        ArrayDeque<Character> arrayDeque = new ArrayDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            arrayDeque.addLast(word.charAt(i));
        }
        return arrayDeque;
    }

    /* */
    public boolean isPalindrome(String word) {
        return true;
    }
}
