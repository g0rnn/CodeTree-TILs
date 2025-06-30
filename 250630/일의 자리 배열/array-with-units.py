l = list(map(int, input().split()))
for i in range(2, 10):
    l.append((l[i-2] + l[i-1])%10)
print(*l)