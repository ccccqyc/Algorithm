class Solution {
public:
    vector<string> ans; // ��Ϊȫ�ֱ���������helper��������
    vector<string> sList={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"}; //�ַ���ע�ⲻ������������
    
    vector<string> letterCombinations(string digits) {
        if(digits.size()==0) return {};  // �߽� 
        helper(digits, {}, 0);
        return ans;
    }

    void helper(string digits, string s, int idx){
        if(idx==digits.size()){ // ������������֤digitsȫ����ɨ��
            ans.push_back(s);   // ��һ�ֽ��ѹ��ans
            return;
        }
        else{
            // ����digits��λ�����е���������digits="234"
            // ��һ�����Ϊ"2"����������Ӧ���ַ���"abc"�������ַ���������Ϊ"a","b","c"
            // �ڶ������Ϊ"3"����������Ӧ���ַ���"def"�������ַ���������һ�����Ϊ"a"������ӡ�����Ϊ"ad", "ae"��"af".
            int pos=digits[idx]-'0';  // ��ȡidx��digits���ַ�,�硰2����Ӧ��2
            string tmpStr=sList[pos];  // ��ȡ�±�pos��Ӧ���ַ�������2��Ӧ��"abc"
            for(int i=0;i<tmpStr.size();i++){
                helper(digits,s+tmpStr[i],idx+1);   // ������һ�������ע��ͬһ�����ʱ���ı�s��idx�Ȳ���ֵ
            }
        }
    }
};
