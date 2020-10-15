#include <vector>
using namespace std;

class Solution {
   public:
    void generateP(vector<vector<int>>& P, vector<int>& nums, int index,
                   int n) {
        if (index == n) {
            P.emplace_back(nums);
            return;
        }
        for (int i = index; i < n; i++) {
            swap(nums[index], nums[i]);
            generateP(P, nums, index + 1, n);
            swap(nums[index], nums[i]);
        }
    }
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> P;
        generateP(P, nums, 0, (int)nums.size());
        return P;
    }
};