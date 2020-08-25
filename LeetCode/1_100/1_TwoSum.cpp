class Solution {
public:
	//hash 解法, 一边加入到hashmap中,一边对比,O(n) 
	vector<int> twoSum_0(vector<int>& nums, int target){
    vector<int> twoSum(vector<int>& nums, int target) {
	    vector<int> arr(2);
		unordered_map<int,int> hashmap;
		int length  = nums.size();
		int temp;
		for(int i=0;i<length;i++){
			temp = target -  nums[i];
			if(hashmap.count(temp)){
				arr = {hashmap[temp],i};
                break;
			}
			//放for开始可能出现 hashmap[temp] == i,输出就是[i,i] 
            hashmap[nums[i]] = i;
		}
		return arr;
    }
	}
	
	//暴力解法,O(n^2) 
    vector<int> twoSum_1(vector<int>& nums, int target) {
        int temp, len = nums.size();
        vector<int> arr(2);
        for(int i =0;i<len;i++){
            temp = nums[i];
            for(int j =i+1;j<len;j++){
                if(target - temp==nums[j]){
                    arr[0] = i;
                    arr[1] = j;
                    goto here;
                }
            }
        }
        here:
        return arr;
    }
};
