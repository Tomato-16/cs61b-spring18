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
        return palindromeHelper(wordToDeque(word));
    }
    /* private helper method to determine if a deque of character is palindrome */
    private boolean palindromeHelper(Deque<Character> deque) {
        if (deque.size() == 1 || deque.size() == 0) {
            return true;
        } else if (deque.removeFirst() == deque.removeLast()){
            return palindromeHelper(deque);
        } else {
            return false;
        }
    }
}
