a = list(map(int, input().split()))
b = list(map(int, input().split()))
for i in range(len(a)):
    if a[i] <= b[i]: 
        print(0)
        break
else: print(1) 