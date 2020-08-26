class Solution {
public:
    vector<string> ans; // 设为全局变量，方便helper函数引用
    vector<string> sList={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"}; //字符表，注意不能用括号声明
    
    vector<string> letterCombinations(string digits) {
        if(digits.size()==0) return {};  // 边界 
        helper(digits, {}, 0);
        return ans;
    }

    void helper(string digits, string s, int idx){
        if(idx==digits.size()){ // 回溯条件，保证digits全部被扫描
            ans.push_back(s);   // 将一种结果压入ans
            return;
        }
        else{
            // 依据digits的位数进行迭代，例如digits="234"
            // 第一层迭代为"2"，将遍历对应的字符串"abc"并更新字符串，依次为"a","b","c"
            // 第二层迭代为"3"，将遍历对应的字符串"def"并更新字符串，若上一层迭代为"a"，则添加、更新为"ad", "ae"与"af".
            int pos=digits[idx]-'0';  // 获取idx在digits的字符,如“2”对应的2
            string tmpStr=sList[pos];  // 获取下标pos对应的字符串，如2对应的"abc"
            for(int i=0;i<tmpStr.size();i++){
                helper(digits,s+tmpStr[i],idx+1);   // 进行下一层迭代，注意同一层迭代时不改变s和idx等参数值
            }
        }
    }
};
