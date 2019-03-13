#include <iostream>
using namespace std;

#define MAXSIZE 50
typedef int KeyType;

typedef  struct {
	KeyType  key;
} ElemType;

typedef  struct {
	ElemType  *R;
	int  length;
} SSTable;

void  Create(SSTable &T) {
	int i;
	T.R=new ElemType[MAXSIZE+1];
	cin>>T.length;
	for(i=1; i<=T.length; i++)
		cin>>T.R[i].key;
}

int  Search_Bin(SSTable T, KeyType k);

int main () {
	SSTable T;
	KeyType k;
	Create(T);
	cin>>k;
	int pos=Search_Bin(T,k);
	if(pos==0) cout<<"NOT FOUND"<<endl;
	else cout<<pos<<endl;
	return 0;
}

int  Search_Bin(SSTable T, KeyType k) {
	int isFound = 0,low=0,high=T.length-1;
	
	
	while(!isFound){
		if(k==T.R[(low+high)/2].key){
			isFound = (low+high)/2+1;
		}if(k<T.R[(low+high)/2].key){
			high = (low+high)/2-1;
		}else{
			low = (low+high)/2+1;
		}
		
		if(low==high){
			break;
		}
	}
	
	return isFound;
}
