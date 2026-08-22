class Solution {

    List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {

        backtrack(s, 0, new ArrayList<>());

        return result;
    }

    public void backtrack(String s, int start, List<String> temp) {

        // Reached the end
        if (start == s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int end = start; end < s.length(); end++) {

            // Check if s[start...end] is palindrome
            if (isPalindrome(s, start, end)) {

                temp.add(s.substring(start, end + 1));

                backtrack(s, end + 1, temp);

                // Backtrack
                temp.remove(temp.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int i, int j) {

        while (i < j) {

            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}