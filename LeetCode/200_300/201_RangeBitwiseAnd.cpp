class Solution {
	public:
		int rangeBitwiseAnd(int m, int n) {
			int mask = 1 << 30;
			int answer = 0;
			//思路 寻找m,n相同前缀 
			while(mask > 0 && ((m&mask)==(n&mask))) {
				answer |= (m&mask);
				mask >>=1;
			}

			return answer;
		}
};
