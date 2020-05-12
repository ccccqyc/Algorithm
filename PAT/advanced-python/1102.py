#!/usr/bin/env python
# -*- coding: utf-8 -*-
# https://pintia.cn/problem-sets/994805342720868352/problems/994805365537882112


n = int(input())
arr = input("").split(" ")
arr2 = [0] * n
max = 0
mins = 10 ** 9

for i in range(n):
    temp = int(arr[i])
    if temp > max:
        max = temp
        arr2[i] = 1

res = []
for i in range(n - 1, -1, -1):
    temp = int(arr[i])
    if temp < mins:
        mins = temp
    else:
        arr2[i] = 0
    if arr2[i]:
        res.append(temp)

print(len(res))
print(" ".join(str(i) for i in sorted(res)))
