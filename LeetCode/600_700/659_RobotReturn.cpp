class Solution {
public:
    bool judgeCircle_1(string moves) {
        return (count(moves.begin(),moves.end(),'U') == count(moves.begin(),moves.end(),'D')) && (count(moves.begin(),moves.end(),'L') == count(moves.begin(),moves.end(),'R'));
    }
    
    bool judgeCicrle_2(string moves) {
    	int x=0,y =0;
    	for(char move : moves){
    		if(move == 'U'){
    			y++;
			}else if(move == 'D'){
				y--;
			}else if(move == 'L'){
				x++;
			}else if(move == 'R'){
				x--;
			}
		}
		
		return x==0&&y==0;
	}
};
