public class strStr {
    //https://leetcode.com/problems/implement-strstr/discuss/
    public int strStr(String haystack, String needle) {
        if(haystack==null||needle==null||needle.length()>haystack.length()){
            return -1;
        }
        int i = haystack.indexOf(needle);
        return i;
    }
}
