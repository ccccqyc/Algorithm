class Solution {
	public:
		int rangeBitwiseAnd(int m, int n) {
			int mask = 1 << 30;
			int answer = 0;
			//˼· Ѱ��m,n��ͬǰ׺ 
			while(mask > 0 && ((m&mask)==(n&mask))) {
				answer |= (m&mask);
				mask >>=1;
			}

			return answer;
		}
};
