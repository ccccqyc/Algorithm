#include<iostream> 
#include<string>
#include<string.h>
using namespace std; 
string SpellItRight(int i)
{
  switch(i){
   case 0:return "zero\0"; 
   break;
   case 1:return "one\0";
   break; 
   case 2:return "two\0";
   break; 
   case 3:return "three\0";
   break; 
   case 4:return "four\0";
   break; 
   case 5:return "five\0";
   break; 
   case 6:return "six\0";
   break; 
   case 7:return "seven\0";
   break; 
   case 8:return "eight\0";
   break; 
  }
   return "nine\0"; 
}
int main()
{
  int  temp,len;
  string ms;
  char N[101]; 
  cin>>N;
    temp=0; 
  len=strlen(N);
    for(int i=0;i<len;i++)
  {
    temp+=N[i]-'0';
  }
    ms=SpellItRight(temp%10);  
    temp/=10;
    while(temp>0)
    {   
     ms=" "+ms;
       ms=SpellItRight(temp%10)+ms;   
     temp/=10;
    }  
     cout<<ms<<endl;
 return 0;
}
