#include <stdio.h>
#include <string.h>

struct bign {
	int d[1000];
	int len;
	bign() {
		memset(d,0,sizeof(d));
		len = 0;
	}
};

//比较 bign
int compare(bign a,bign b) {
	if(a.len > b.len) return 1;
	else if(a.len < b.len) return -1;
	else {
		for(int i = a.len -1; i>=0; i--) {
			if(a.d[i]>b.d[i]) return 1;
			else if(a.d[i]<b.d[i]) return -1;
		}
		return 0;
	}
}
// str -> bign
bign change(char str[]) {
	bign a;
	a.len = strlen(str);
	for(int i=0; i<a.len; i++) {
		a.d[i] = str[a.len - i- 1] -'0';
	}
	return a;
}

//精度 a+b
bign add(bign a, bign b) {
	bign c;
	int carry = 0;
	for(int i=0; i<a.len || i<b.len; i++) {
		int temp = a.d[i]+b.d[i]+carry;
		c.d[c.len++] = temp%10;
		carry = temp/10;
	}

	if(carry != 0) {
		c.d[c.len++] = carry;
	}
	return c;
}
//减法
bign sub(bign a,bign b) {
	bign c;
	for(int i = 0; i<a.len||i<b.len; i++) {
		if(a.d[i]<b.d[i]) {
			a.d[i+1]--;
			a.d[i] +=10;
		}
		c.d[c.len++] = a.d[i]-b.d[i];
	}
	//去除高位0,如果a=b 保留最低位0
	while(c.len - 1>=1&&c.d[c.len -1] ==0) {
		c.len--;
	}
	return c;
}
//乘法
bign multi(bign a,int b) {
	bign c;
	int carry =0;//进位
	for(int i =0; i<a.len; i++) {
		int temp = a.d[i] *b+carry;
		c.d[c.len++] = temp%10;
		carry = temp/10;
	}
	while(carry!=0) {
		c.d[c.len++] = carry %10;
		carry /=10;
	}
	return c;
}
//除法
//r 余数
int d;
bign divide(bign a,int b,int &r) {
	bign c;
	c.len = a.len;
	for(int i=a.len -1; i>=0; i--) {
		r = r*10+a.d[i];
		if(r<b) {
			c.d[i] =0;
		} else {
			c.d[i] = r/b;
			r = r%b;
		}
	}
	while(c.len-1>=1&&c.d[c.len-1]==0) {
		c.len-- ;
	}
	return c;
}
void print(bign a) {
	for(int i = a.len -1; i>=0; i--) {
		printf("%d",a.d[i]);
	}
}

int main() {
	char str1[1000],str2[1000];
	scanf("%s%s",str1,str2);
	bign a = change(str1);
	bign b = change(str2);
	printf("加法:a+b = ");
	print(add(a,b));
	printf("\n减法: a-b = ");
	print(sub(a,b));
	int c;
	printf("\n输入乘数或除数:");
	scanf("%d",&c);
	printf("\n乘法:a*c = ");
	print(multi(a,c));
	printf("\n除法:a/c = ");
	print(divide(a,c,d));
	printf("...%d",d);
	return 0 ;
}
