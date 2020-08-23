class Solution {
	public:
		//排序,众数总在中间位置
		int majorityElement_1(vector<int>& nums) {
			sort(nums.begin(),nums.end());
			return nums[nums.size()/2];
		}
		// moore 投票,遍历一遍nums,
		int majorityElement_2(vector<int>& nums) {
			int count = 0,candidate;
			for(int num:nums) {
				if(count ==0) {
					candidate = num;
				}
				if(candidate == num) {
					count++;
				} else {
					count--;
				}
			}
			return candidate;
		}
		//hash 
		int majorityElement_3(vector<int>& nums) {
			unordered_map <int,int> mp;
			int length2 = nums.size()/2;
			for(int num:nums) {
				if(++mp[num] > length2) {
					return num;
				}
			}
			return -1;
		}


};
