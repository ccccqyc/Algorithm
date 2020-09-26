#include <iostream>
#include <cstdio>
#include <algorithm>
const int inf = 0x3f3f3f3f;
using namespace std;

int main(int argc, char const *argv[])
{
	int m;
	cin>>m;
	string id;
	int first = inf,last = 0;
	string first_id,last_id;
	for (int i = 0; i < m; ++i)
	{
		cin>>id;
		int h1,m1,s1,h2,m2,s2;
		scanf("%d:%d:%d",&h1,&m1,&s1);
		scanf("%d:%d:%d",&h2,&m2,&s2);
		int come = h1*3600+m1*60+s1;
		int left = h2*3600+m2*60+s2;
		if(come < first)
		{
			first = come;
			first_id = id;
		}
		if (left > last)
		{
			last_id = id;
			last = left;
		}
	}
	cout<<first_id<<' '<<last_id<<endl;
	return 0;
}

