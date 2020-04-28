#!/usr/bin/env python
# -*- coding: utf-8 -*-
# https://pintia.cn/problem-sets/994805342720868352/problems/994805528788582400
def main():
    a = input("").split(" ")
    c = str(int(a[0]) + int(a[1]))
    le = len(c)
    for i in range(le):
        print(c[i], end='')
        if '-' == c[i]:
            continue
        if ((i + 1) % 3 == le % 3) & (i != le - 1):
            print(",", end='')


if __name__ == "__main__":
    main()
