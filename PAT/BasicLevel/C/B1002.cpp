#include <cstdlib>
#include <string>
#include <iostream>
#include <string.h>

using namespace std;

int main() {
	int sum =0;
	string arr[10]= {"ling","yi","er","san","si","wu","liu","qi","ba","jiu"};
	string s1 ;
	getline(cin,s1);
	for(int i=0;i<s1.length();i++){
		sum += s1[i]-'0';
	}
	
	char s2[100]={0};
	itoa(sum,s2,10);
	int length = strlen(s2);
	for(int i =0;i<length;i++){
		printf("%s",arr[s2[i]-'0'].c_str());
		if(i!=length-1) cout << " " ; 
	}
	return 0;
}
