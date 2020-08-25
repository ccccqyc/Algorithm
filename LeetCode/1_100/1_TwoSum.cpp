class Solution {
public:
	//hash �ⷨ, һ�߼��뵽hashmap��,һ�߶Ա�,O(n) 
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
			//��for��ʼ���ܳ��� hashmap[temp] == i,�������[i,i] 
            hashmap[nums[i]] = i;
		}
		return arr;
    }
	}
	
	//�����ⷨ,O(n^2) 
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
