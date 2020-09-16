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

    /* a third public method determine palindrome according to the comparator */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        return palindromeHelper(wordToDeque(word), cc);
    }
    private boolean palindromeHelper(Deque<Character> deque, CharacterComparator cc) {
        if (deque.size() == 1 || deque.size() == 0) {
            return true;
        } else if (cc.equalChars(deque.removeFirst(), deque.removeLast())){
            return palindromeHelper(deque, cc);
        } else {
            return false;
        }
    }
}
