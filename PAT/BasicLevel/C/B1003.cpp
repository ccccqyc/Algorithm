#include <iostream>
#include <string>

using namespace std;

bool func(string s) {
  bool thereturn = true;
  for (int i = 0; i < s.length(); i++) {
    if (s[i] != 'P' || s[i] != 'A' || s[i] != 'T' || s[i] != ' ') {
      thereturn = false;
      break;
    }
  }
  return thereturn;
}

int main() {
  int n;
  string s;
  cin >> n;
  getchar();
  for (int i = 0; i < n; i++) {
    getline(cin, s);
    cout << (func(s) ? "YES" : "NO") << endl;
  }

  return 0;
}