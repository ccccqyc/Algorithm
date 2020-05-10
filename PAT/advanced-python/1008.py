#!/usr/bin/env python
# -*- coding: utf-8 -*-
# https://pintia.cn/problem-sets/994805342720868352/problems/994805511923286016

def main():
    a = input("").split(" ")
    lens = len(a)
    count = int(a[1]) * 6 + (lens - 1) * 5
    for i in range(2, lens):
        a1 = int(a[i - 1])
        a2 = int(a[i])
        if (a1 < a2):
            count += 6 * (a2 - a1)
        if (a1 > a2):
            count += 4 * (a1 - a2)
    print(count)


if __name__ == "__main__":
    main()
