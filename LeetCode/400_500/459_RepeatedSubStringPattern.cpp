class Solution {
public:
    //一个子串重复**多次**构成
    bool repeatedSubstringPattern(string s) {
        return (s + s).find(s,1) != s.size();
    }
};
